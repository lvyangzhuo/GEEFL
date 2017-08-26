package com.jeefl.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lyz on 2017-8-6.
 */
@RestController
@EnableAutoConfiguration
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }


    @RequestMapping(value = "/http")
    public void HttpServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        int index = 0;
        while ((line = input.readLine()) != null) {
            System.out.print(index);
            System.out.println(line);
            if (line.length() == 0)
                break;
            index++;
        }

        output.write("Hello World");
        output.flush();
        input.close();
        output.close();
    }

}
