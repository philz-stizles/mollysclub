package com.devdezyn.mollysclub.shared.sockets;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SocketMessageDto {
    private MessageType type;
    private String sender;
    private String message;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
