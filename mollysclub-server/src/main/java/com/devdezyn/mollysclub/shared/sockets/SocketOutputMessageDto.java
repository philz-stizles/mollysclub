package com.devdezyn.mollysclub.shared.sockets;

import lombok.*;

@Setter
@Getter
@Builder
public class SocketOutputMessageDto {
     private String from;
     private String message;
    private String time;
}
