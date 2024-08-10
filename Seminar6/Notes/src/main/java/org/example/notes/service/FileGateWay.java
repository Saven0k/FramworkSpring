package org.example.notes.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;



@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface FileGateWay {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String text);
}
