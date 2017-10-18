package com.jeefl.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import javafx.scene.input.DataFormat;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
            if (line.length() == 0){
                break;
            }
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


    public static void mark(String srcImgPath, String outImgPath, Color markContentColor, String waterMarkContent) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcImgFile);
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            //Font font = new Font("Courier New", Font.PLAIN, 12);
            Font font = new Font("宋体", Font.PLAIN, 50);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色

            g.setFont(font);
            int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
            int y = srcImgHeight - 3;
            //int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
            //int y = srcImgHeight / 2;
            g.drawString(waterMarkContent, x, y);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "png", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取水印文字总长度
     * @param waterMarkContent 水印的文字
     * @param g
     * @return 水印文字总长度
     */
    public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    public static void main(String[] args) {
        // 原图位置, 输出图片位置, 水印文字颜色, 水印文字
        //HelloWorldController.mark("d:/postWatermark.png", "d:/afterWatermark.jpg", Color.red, "水印效果测试");
    }

}
