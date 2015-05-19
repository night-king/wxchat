package com.joe.wxchat.service.impl;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.joe.wxchat.utils.Constants;
import com.joe.utils.MessageUtils;
import com.joe.wxchat.entity.message.req.ReqTextMessage;
import com.joe.wxchat.service.ICoreService;
import com.joe.wxchat.service.strategy.TextMessageStrategy;
import com.joe.wxchat.utils.UserSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("coreService")
public class CoreServiceImpl implements ICoreService {

    public static Logger log = Logger.getLogger(CoreServiceImpl.class);


    @Override
    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            //parse xml to requestMap
            Map<String, String> requestMap = MessageUtils.parseXml(request);

            //check the user
            UserSession.checkUser(requestMap.get("FromUserName"));

            //parse xml to reqTextMessage
            ReqTextMessage reqTextMessage = new ReqTextMessage();
            reqTextMessage.setContent(requestMap.get("Content"));
            reqTextMessage.setFromUserName(requestMap.get("FromUserName"));
            reqTextMessage.setToUserName(requestMap.get("ToUserName"));
            reqTextMessage.setMsgType(requestMap.get("MsgType"));
            reqTextMessage.setMsgId(Long.valueOf(requestMap.get("MsgId")));

            // 文本消息
            if (reqTextMessage.getMsgType().equals(Constants.REQ_MESSAGE_TYPE_TEXT)) {
                // 接收用户发送的文本消息内容  
                TextMessageStrategy textMessageStrategy = new TextMessageStrategy();
                respMessage = MessageUtils.messageToXml(textMessageStrategy.dealText(reqTextMessage));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }


} 