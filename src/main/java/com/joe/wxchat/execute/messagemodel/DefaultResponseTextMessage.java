package com.joe.wxchat.execute.messagemodel;


import java.util.Date;

import com.joe.utils.LineSeparator;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.utils.Constants;
import com.joe.wxchat.utils.OpertionUtils;
import org.apache.log4j.Logger;

public class DefaultResponseTextMessage {

    private static Logger logger = Logger.getLogger(DefaultResponseTextMessage.class);

    public static RespTextMessage getErrorTextMsg(User user) {
        RespTextMessage respTextMessage = createDefaultTextMsg(user.getUserName());
        String ls = LineSeparator.Web;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("欢迎使用Java程序员面试手册，请参考下面描述进行操作。提醒：。").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_ADD).append("或者").append(OpertionUtils.EN_STR_ADD).append("：新增记录").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_SAVE).append("或者").append(OpertionUtils.EN_STR_SAVE).append("：保存记录").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_DEL).append("或者").append(OpertionUtils.EN_STR_DEL).append("：删除记录").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_QUERY).append("或者").append(OpertionUtils.EN_STR_QUERY).append("：模糊查询").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_VIEW).append("或者").append(OpertionUtils.EN_STR_VIEW).append("：查看详细").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_PRE).append("或者").append(OpertionUtils.EN_STR_PRE).append("：向前翻页").append(ls);
        stringBuilder.append(OpertionUtils.CN_STR_NEXT).append("或者").append(OpertionUtils.EN_STR_NEXT).append("：向后翻页").append(ls);
        stringBuilder.append("如有疑问，请点击<a href='www.baidu.com' style='color:#0000FF'>详细帮助文档</a>").append(ls);
        respTextMessage.setContent(stringBuilder.toString());
        return respTextMessage;
    }

    public static RespTextMessage getAskTextMsg(User user) {
        RespTextMessage respTextMessage = createDefaultTextMsg(user.getUserName());
        respTextMessage.setContent("请输入查询（“!% 关键字 ”）的命令或者创建（“!+”）的命令。");
        return respTextMessage;
    }

    public static RespTextMessage getTipsTextMsg(User user) {
        RespTextMessage respTextMessage = createDefaultTextMsg(user.getUserName());
        respTextMessage.setContent("该命令暂未实现。");
        return respTextMessage;
    }


    public static RespTextMessage getNullTextMsg(User user) {
        RespTextMessage respTextMessage = createDefaultTextMsg(user.getUserName());
        respTextMessage.setContent("如有疑问，请点击<a style='color:#0000FF'>未查到相关数据，请更新关键字。</a>");
        return respTextMessage;
    }

    public static RespTextMessage createDefaultTextMsg(String toUserName) {
        logger.info("----create default text message-------");
        logger.info("toUser.name=" + toUserName);
        RespTextMessage respTextMessage = new RespTextMessage();
        respTextMessage.setCreateTime(new Date().getTime());
        respTextMessage.setFromUserName(Constants.SERVER_ID);
        respTextMessage.setToUserName(toUserName);
        respTextMessage.setMsgType(Constants.RESP_MESSAGE_TYPE_TEXT);
        return respTextMessage;
    }

}
