package kr.co.mayo.dreamon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
public class WebSecurityConfig {
    
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		    
            http
                .csrf(csrf->csrf.disable())                                     //POST 요청 시 
			    .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/member/**").hasAnyRole("MEMBER", "ADMIN")    //2개 이상의 권한 허용 시.
                .requestMatchers("/admin/**").hasRole("ADMIN")                  //1개의 권한만 허용 시.
                .anyRequest().permitAll()
                //.requestMatchers("/", "/home").permitAll()
				//.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/user/signIn")
				.permitAll()
			)
			.logout((logout) -> logout
            .logoutUrl("/user/logout")                                          //로그아웃 시, 스프링이 매칭해주는 url 주소? : header.html에서 로그아웃 버튼 href에 기입한 url.
            .logoutSuccessUrl("/index")                                         //로그아웃 처리 후 index 페이지로 이동시킴.
            .permitAll());

            
		return http.build();
	}

    //2.사용자 정보를 제공하는 서비스
	@Bean
	public UserDetailsService userDetailsService() {
		
        //2.1.사용자 정보를 담고 있는 자료형
        UserDetails user = User.builder()                                       //기본 코드 : withDefaultPasswordEncoder()
                               .username("grj90")
                               .password("{noop}11111")
                               .roles("MEMBER", "ADMIN")
                               .build();

		return new InMemoryUserDetailsManager(user);
	}

}
