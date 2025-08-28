package com.asli.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    public void printMessage() {
        System.out.println("Merhaba, Spring IoC çalışıyor!");
    }
}
