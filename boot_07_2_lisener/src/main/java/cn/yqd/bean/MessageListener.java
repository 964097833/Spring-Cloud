package cn.yqd.bean;

import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    /**接收消息的方法*/
    public void receiveMessage(String message){
        System.out.println("收到一条消息："+message);
    }
}