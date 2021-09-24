// package com.devdezyn.mollysclub.shared.sockets;

// import java.text.SimpleDateFormat;
// import java.util.Date;

// import org.springframework.messaging.handler.annotation.MessageMapping;
// import org.springframework.messaging.handler.annotation.Payload;
// import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
// import org.springframework.stereotype.Controller;

// @Controller
// public class SocketMessageController {

//     // Handles messages from /app/chat. (Note the Spring adds the /app prefix for us).
//     @MessageMapping("/chat.sendMessage")
//     // Sends the return value of this method to /topic/messages
//     @SendTo("/topic/messages")
//     public SocketOutputMessageDto getMessages(SocketMessageDto dto) {

//         String time = new SimpleDateFormat("HH:mm").format(new Date());
//         return SocketOutputMessageDto.builder().from(dto.getSender()).message(dto.getMessage()).time(time).build();
//     }
    
//     @MessageMapping("/chat.addUser")
//     @SendTo("/topic/public")
//     public SocketMessageDto addUser(@Payload SocketMessageDto socketMessageDto, SimpMessageHeaderAccessor headerAccessor) {
//         // Add username in web socket session
//         headerAccessor.getSessionAttributes().put("username", socketMessageDto.getSender());
//         return socketMessageDto;
//     }

// }
