package com.woniuxy.snailrestaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {
    /**
     * ServerEndpointExporter 作用
     *
     * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
     *
     *
     */
    @Lazy(value = false)
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
