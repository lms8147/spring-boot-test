package com.example.springboottest.websoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyHandler extends TextWebSocketHandler {

    public static final Logger logger = LoggerFactory.getLogger(MyHandler.class);

    private static Set<WebSocketSession> clients = Collections
            .synchronizedSet(new HashSet<WebSocketSession>());

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String str = message.getPayload();
        logger.info("message(" + session.toString() + ") : " + str);
        synchronized (clients) {
            // Iterate over the connected sessions
            // and broadcast the received message
            for (WebSocketSession client : clients) {
                if (!client.equals(session)) {
                    client.sendMessage(message);
                }
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        logger.info("open(" + session.toString() + ")");
        clients.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);

        logger.info("close(" + session.toString() + ")");
        clients.remove(session);
    }

}