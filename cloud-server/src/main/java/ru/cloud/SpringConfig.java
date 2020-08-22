package ru.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cloud.service.netty.NettyServer;

@Configuration
public class SpringConfig {

    @Bean
    public NettyServer nettyServer() throws InterruptedException {
        return new NettyServer(4444);
    }

}
