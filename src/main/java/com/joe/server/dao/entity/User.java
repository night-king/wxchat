package com.joe.server.dao.entity;

import com.joe.wxchat.entity.message.req.ReqTextMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.wxchat.execute.flow.ArticleFlow;
import com.joe.wxchat.utils.MessageList;

/**
 * NOTE:User
 * Created by zhouwd on 15-5-16.
 */
public class User {
    public static int OPER_NONE = -1;
    public static int OPER_QUERY = 0;
    public static int OPER_ADD = 1;

    public static int ROLE_ADMIN=0;
    public static int ROLE_REGISTER=1;
    public static int ROLE_GUEST;


    private String userName;
    private String currentContent;
    private String queryContent;
    private int pageCounts;
    private int pageNum;
    private long lastOperTime;
    private int operType = OPER_QUERY;
    private int userRole=ROLE_ADMIN;
    private ArticleFlow articleFlow = new ArticleFlow();
    private MessageList<ReqTextMessage> reqMessageList = new MessageList<>();
    private MessageList<RespTextMessage> respMessageList = new MessageList<>();

    public User() {
    }

    public User(long lastOperTime) {
        this.lastOperTime = lastOperTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCurrentContent() {
        return currentContent;
    }

    public void setCurrentContent(String currentContent) {
        this.currentContent = currentContent;
    }

    public String getQueryContent() {
        return queryContent;
    }

    public void setQueryContent(String queryContent) {
        this.queryContent = queryContent;
    }

    public int getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(int pageCounts) {
        this.pageCounts = pageCounts;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getLastOperTime() {
        return lastOperTime;
    }

    public void setLastOperTime(long lastOperTime) {
        this.lastOperTime = lastOperTime;
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public ArticleFlow getArticleFlow() {
        return articleFlow;
    }

    public void setArticleFlow(ArticleFlow articleFlow) {
        this.articleFlow = articleFlow;
    }

    public MessageList<ReqTextMessage> getReqMessageList() {
        return reqMessageList;
    }

    public void setReqMessageList(MessageList<ReqTextMessage> reqMessageList) {
        this.reqMessageList = reqMessageList;
    }

    public MessageList<RespTextMessage> getRespMessageList() {
        return respMessageList;
    }

    public void setRespMessageList(MessageList<RespTextMessage> respMessageList) {
        this.respMessageList = respMessageList;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
