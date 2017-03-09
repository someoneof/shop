package com.demo.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 海峰 on 2017/3/8.
 */
@WebListener
public class SiteSessionListener implements HttpSessionListener{

    private static Map<String,HttpSession> sessions=new HashMap<String, HttpSession>();
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent)
    {
//        System.out.println(sessionEvent.getSession().getId());
        sessions.put(sessionEvent.getSession().getId(),sessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent)
    {
        sessions.remove(sessionEvent.getSession().getId());
    }

    public static HttpSession getSession(String sessionID)
    {
//        System.out.println("listtener,sessionID="+sessionID);
        return sessions.get(sessionID);
    }

    public static void remove(String sessionID)
    {
//        System.out.println("listtener,remove session");
        if(sessions.containsKey(sessionID)) sessions.remove(sessionID);
    }
}
