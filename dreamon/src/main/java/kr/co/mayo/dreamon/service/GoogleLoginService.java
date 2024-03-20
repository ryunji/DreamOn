package kr.co.mayo.dreamon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import kr.co.mayo.dreamon.entity.Member;
import kr.co.mayo.dreamon.repository.MemberRepository;

@Service
public class GoogleLoginService {

    @Autowired
    MemberRepository repository;

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();
    
    public GoogleLoginService(Environment env) {
        this.env = env;
    }
    public void socialLogin(
        String code, String registrationId) {
        String accessToken = getAccessToken(code, registrationId);
        System.out.println("accessToken = " + accessToken);

        JsonNode userResourceNode = getUserResource(accessToken, registrationId);
        System.out.println("userResourceNode = " + userResourceNode);

        String id       = userResourceNode.get("id").asText();
       // Long googleId   = Long.parseLong(id);
        String email    = userResourceNode.get("email").asText();
        String nickname = userResourceNode.get("name").asText();
        System.out.println("id = " + id);
        System.out.println("email = " + email);
        System.out.println("nickname = " + nickname);

        // Member member = new Member();
        // member.setId(googleId);
        // member.setEmail(email);
        // member.setKorName(nickname);
        // boolean saveYn = saveMember(member);

    }

    private boolean saveMember(Member member){

        repository.saveGoogleNewMember();
        return true;
    }
   
    private String getAccessToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id");
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();
        return accessTokenNode.get("access_token").asText();
    }

    private JsonNode getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2."+registrationId+".resource-uri");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();
    }
}
