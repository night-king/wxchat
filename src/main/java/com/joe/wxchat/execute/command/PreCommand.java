package com.joe.wxchat.execute.command;

import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.user.User.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;

/**
 *
 * Created by zhouwd on 15-5-17.
 */
public class PreCommand extends AbstractCommand {

    @Override
    public RespBaseMessage execute(User user) {
        if(User.OPER_QUERY==user.getOperType()){

        }else if(User.OPER_ADD==user.getOperType()){

        }
        return DefaultResponseTextMessage.getTipsTextMsg(user);
    }
}
