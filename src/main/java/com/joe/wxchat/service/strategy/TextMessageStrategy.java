package com.joe.wxchat.service.strategy;

import com.joe.wxchat.entity.message.req.ReqTextMessage;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.user.User.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.command.*;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;
import com.joe.wxchat.utils.OpertionConstants;
import com.joe.wxchat.utils.UserSession;
import org.apache.log4j.Logger;

public class TextMessageStrategy {

    private Logger logger = Logger.getLogger(TextMessageStrategy.class);

    public RespBaseMessage dealText(ReqTextMessage textMessage) {
        String content = textMessage.getContent();
        User user = UserSession.getUserInfo(textMessage.getFromUserName());
        if (content == null) {
            return DefaultResponseTextMessage.getErrorTextMsg(user);
        }
        textMessage.setContent(content);
        UserSession.updateUserStatus(user, textMessage);

        AbstractCommand command;
        if (content.startsWith(OpertionConstants.OPER_QUERY)) {
            command = new QueryCommand();
        } else if (content.startsWith(OpertionConstants.OPER_VIEW)) {
            command = new ViewCommand();
        } else if (content.startsWith(OpertionConstants.OPER_PRE)) {
            command = new PreCommand();
        } else if (content.startsWith(OpertionConstants.OPER_NEXT)) {
            command = new NextCommand();
        } else if (content.startsWith(OpertionConstants.OPER_CLEAR)) {
            command = new ClearCommand();
        } else if (content.startsWith(OpertionConstants.OPER_ADD)) {
            command = new CreateCommand();
        } else if (content.startsWith(OpertionConstants.OPER_END)) {
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
