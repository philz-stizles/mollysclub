package com.devdezyn.mollysclub.shared.sockets;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SocketMessageDto {
    private String from;
    private String message;
}
