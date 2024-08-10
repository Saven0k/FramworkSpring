package org.example.notes.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel writerChannel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "inputChannel", outputChannel = "writerChannel")
    public GenericTransformer<String,String> Transformer(){
        return String::toLowerCase;
    }

    @Bean
    @ServiceActivator(inputChannel = "inputChannel")
    public FileWritingMessageHandler messageHandler(){
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "D:/JavSem/Seminar6/Notes"
                ));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }


}
