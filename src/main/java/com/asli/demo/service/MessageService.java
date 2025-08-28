package com.asli.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessagePrinter printer;

    // Constructor Injection
    public MessageService(MessagePrinter printer) {
        this.printer = printer;
    }
    // Constructor bir sınıfın ihtiyaç duyduğu başka bir nesneyi sınıfın constructor’ı üzerinden almasıdır.
    public void sendMessage() {
        printer.printMessage();
    }
}
