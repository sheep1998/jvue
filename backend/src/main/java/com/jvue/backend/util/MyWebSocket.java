package com.jvue.backend.util;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint(value = "/myWebSocket/{userid}")
@Component
public class MyWebSocket {
    private Session session;
    private static CopyOnWriteArrayList<MyWebSocket> webSockets = new CopyOnWriteArrayList<>();
    private static Map<Integer,Session> sessionPool = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="userid") Integer userid){
        this.session = session;
        webSockets.add(this);
        sessionPool.put(userid,session);
        System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
        String[] params = message.split("@");
        if(params[0].equals("0")){
            String newMessage = "1"+message.substring(1);

            this.sendOneMessage(1,newMessage);
        }
        else if(params[0].equals("1")){
            String newMessage = "0"+message.substring(1);
            this.sendOneMessage(0,newMessage);
        }
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(MyWebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息
    public void sendOneMessage(Integer userid, String message) {
        Session session = sessionPool.get(userid);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
