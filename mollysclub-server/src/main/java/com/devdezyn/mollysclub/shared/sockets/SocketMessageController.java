package com.devdezyn.mollysclub.shared.sockets;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketMessageController {

    // Handles messages from /app/chat. (Note the Spring adds the /app prefix for us).
    @MessageMapping("/chat")
    // Sends the return value of this method to /topic/messages
    @SendTo("/topic/messages")
    public SocketOutputMessageDto getMessages(SocketMessageDto dto){
    
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return SocketOutputMessageDto.builder()
          .from(dto.getFrom())
          .message(dto.getMessage())
          .time(time)
          .build();
    }

}
