package com.joe.wxchat.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.joe.wxchat.entity.message.req.ReqTextMessage;
import com.joe.wxchat.entity.user.User.User;
import org.apache.log4j.Logger;

/**
 * NOTE:
 * Created by zhouwd on 15-5-16.
 */
public class UserSession {
    private static Logger logger = Logger.getLogger(UserSession.class);

    private static Map<String, User> userMap = new HashMap<>();


    public static void updateUserStatus(User user, ReqTextMessage reqTextMessage) {
        user.setLastOperTime(new Date().getTime());
        user.getReqMessageList().add(reqTextMessage);
        String content = reqTextMessage.getContent();
        user.setCurrentContent(reqTextMessage.getContent());
        if (content.startsWith(OpertionConstants.OPER_QUERY)) {
            user.setQueryContent(content.replace(OpertionConstants.OPER_QUERY,""));
            user.setPageNum(0);
            user.setOperType(User.OPER_QUERY);
        } else if (content.startsWith(OpertionConstants.OPER_ADD)) {
            user.setOperType(User.OPER_ADD);
            user.getArticleFlow().setCurrentStep(0);
        }

    }

    /**
     * Check user exist.
     *
     * @param userName
     */
    public static void checkUser(String userName) {
        logger.info(UserSession.class+".checkUser----");
        logger.info(userMap.keySet());
        User user = userMap.get(userName);
        if (user == null) {
            user = new User();
            user.setUserName(userName);
            user.setLastOperTime(new Date().getTime());
            user.setOperType(User.OPER_NONE);
            userMap.put(userName, user);
            //When add user to userMap, First,check the size of userMap. If the size bigger than 10000, remove the sleep user.
            if (userMap.size() > 10000) {
                userMap.remove(getEarliestUser().getUserName());
            }
        }
    }

    public static User getUserInfo(String userName) {
        return userMap.get(userName);
    }

    private static User getEarliestUser() {
        User earliestUser = new User(Long.MAX_VALUE);
        for (User user : userMap.values()) {
            if (user.getLastOperTime() < earliestUser.getLastOperTime()) {
                earliestUser = user;
            }
        }
        return earliestUser;
    }
}
