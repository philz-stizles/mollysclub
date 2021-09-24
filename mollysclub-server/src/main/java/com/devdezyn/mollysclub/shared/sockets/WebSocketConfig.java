// package com.devdezyn.mollysclub.shared.sockets;

// import com.devdezyn.mollysclub.auth.security.AuthChannelInterceptor;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.messaging.simp.config.ChannelRegistration;
// import org.springframework.messaging.simp.config.MessageBrokerRegistry;
// import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
// import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

// @Configuration
// @EnableWebSocketMessageBroker
// public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//     @Value("${app.websocket.allowed-origins}")
//     private String[] allowedOrigins;

//     @Autowired
//     private AuthChannelInterceptor authChannelInterceptor;

//     @Override
//     public void configureMessageBroker(MessageBrokerRegistry registry) {
        
//         // Set prefix for endpoints the client will send messages to
//         registry.setApplicationDestinationPrefixes("/app");

//         // Set prefix for the endpoint that the client listens for our messages from
//         registry.enableSimpleBroker("/topic");

//         // Use this for enabling a Full featured broker like RabbitMQ
//         // registry.enableStompBrokerRelay("/topic")
//         //     .setRelayHost("localhost")
//         //     .setRelayPort(61613)
//         //     .setClientLogin("guest")
//         //     .setClientPasscode("guest");
    
//     }
    
//     @Override
//     public void registerStompEndpoints(StompEndpointRegistry registry) {

//         // Registers the endpoint where the connection will take place
//         registry.addEndpoint("/stomp")
//                 // Allow the origin http://localhost:63343 to send messages to us. (Base URL of the client)
//                 .setAllowedOrigins(allowedOrigins)
//                 // Enable SockJS fallback options
//                 .withSockJS(); // What sockjs does is it allows for backup plans in case the client 
//         // cannot connect via WebSocket. If this happens it will try to connect using another 
//         // protocol to try to mimic a WebSocket connection. This is particularly useful if we 
//         // want to allow the use of older browsers that do not support WebSockets.

//     }
    
//     @Override
//     public void configureClientInboundChannel(ChannelRegistration registration) {

//         // Add our interceptor for authentication/authorization
//         registration.interceptors(authChannelInterceptor);

//     }
// }
