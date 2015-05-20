package com.joe.wxchat.execute.command;

import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.server.dao.entity.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;

/**
 * NOTE:
 * Created by zhouwd on 15-5-17.
 */
public class WarnCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        return DefaultResponseTextMessage.getErrorTextMsg(user);
    }
}
