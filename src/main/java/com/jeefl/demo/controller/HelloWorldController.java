package com.jeefl.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import javafx.scene.input.DataFormat;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lyz on 2017-8-6.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/demo/hello")
public class HelloWorldController {

    @RequestMapping(value = "hello")
    public String hello(){
        return "Hello World";
    }


    @RequestMapping(value = "http",method = RequestMethod.GET)
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

    @RequestMapping(value = "output")
    public void output() throws IOException{
        File file = new File("d:"+File.separator+"test.txt");
        OutputStream outputStream = new FileOutputStream(file,true);
        String str = "hello word";
        byte[] bytes = str.getBytes();
        outputStream.write(bytes);
        outputStream.close();
    }


    @RequestMapping(value = "input")
    public void input() throws IOException{
        File file = new File("d:"+File.separator+"test.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        inputStream.read(bytes);
        inputStream.close();
        System.out.println(bytes);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------//

    @RequestMapping(value = "write")
    public void write()throws IOException{
        File file = new File("d:"+File.separator+"test2.txt");
        Writer writer = new FileWriter(file,true);
        String str = "hello word";
        writer.write(str);
        writer.close();
    }


    @RequestMapping(value = "read")
    public void read()throws IOException{
        File file = new File("d:"+File.separator+"test2.txt");
        Reader reader = new FileReader(file);
        char[] chars = new char[1024];
        int temp = 0;
        int len = 0;
        while ((temp=reader.read()) != -1){
            chars[len] = (char)temp;
            len++;
        }
        reader.close();
        System.out.println(new String(chars,0,len));
    }

    /**
     * 计划任务
     */
    //@Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println("每五秒执行一次  "+sdf.format(new Date()));
    }

}
