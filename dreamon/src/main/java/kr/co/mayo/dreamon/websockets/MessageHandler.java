package kr.co.mayo.dreamon.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//다른 구성 요소에 주입될 수 있는 구성 요소임을 Spring에게 알림.
//@Component로 하니 경로를 찾지 못함.
@Controller
public class MessageHandler {
    
    //필드에 SimpMessagingTemplate 인스턴스(객체)를 삽입하도록 Spring에게 지시.
    //SimpMessagingTemplate은 WebSocket을 통해 클라이언트에 메시지를 보내기 위해 Spring에서 제공하는 구성 요소.
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageHandler(SimpMessagingTemplate messagingTemplate){

        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/send/message")
    public void onReceiveMessage(String message){
        
        System.out.println("Received message : " + message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
