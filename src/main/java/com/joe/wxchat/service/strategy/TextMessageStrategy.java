package com.joe.wxchat.service.strategy;

import com.joe.server.dao.entity.User;
import com.joe.wxchat.entity.message.req.ReqTextMessage;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.command.*;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;
import com.joe.wxchat.utils.OpertionUtils;
import com.joe.wxchat.utils.UserSession;

public class TextMessageStrategy {

//    private Logger logger = Logger.getLogger(TextMessageStrategy.class);

    public RespBaseMessage dealText(ReqTextMessage textMessage) {
        String content = textMessage.getContent();
        User user = UserSession.getUserInfo(textMessage.getFromUserName());
        if (content == null) {
            return DefaultResponseTextMessage.getErrorTextMsg(user);
        }
        textMessage.setContent(content);
        UserSession.updateUserStatus(user, textMessage);

        AbstractCommand command;
        int operType = OpertionUtils.getOperType(content);
        if (OpertionUtils.TYPE_QUERY ==operType) {
            command = new QueryCommand();
        } else if (OpertionUtils.TYPE_DEL ==operType) {
            command = new DelCommand();
        } else if (OpertionUtils.TYPE_VIEW ==operType) {
            command = new ViewCommand();
        } else if (OpertionUtils.TYPE_PRE ==operType) {
            command = new PreCommand();
        } else if (OpertionUtils.TYPE_NEXT ==operType) {
            command = new NextCommand();
        } else if (OpertionUtils.TYPE_CLEAR ==operType) {
            command = new ClearCommand();
        } else if (OpertionUtils.TYPE_ADD ==operType) {
            command = new CreateCommand();
        } else if (OpertionUtils.TYPE_SAVE ==operType) {
            command = new SaveCommand();
        } else {
            if (user.getOperType() == User.OPER_ADD) {
                command = new UpdateCommand();
            } else {
                command = new WarnCommand();
            }
        }
        return command.execute(user);
    }

}
