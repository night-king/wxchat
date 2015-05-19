package com.joe.wxchat.execute.command;

import com.joe.server.dao.entity.Article;
import com.joe.server.service.ArticleService;
import com.joe.utils.LineSeparator;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.message.resp.RespTextMessage;
import com.joe.wxchat.entity.user.User.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;
import com.joe.wxchat.utils.OpertionConstants;

/**
 * NOTE:
 * Created by zhouwd on 15-5-17.
 */
public class ViewCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleService articleService = getArticleServiceBean();
        String context = user.getCurrentContent().replace(OpertionConstants.OPER_VIEW, "");
        try {
            int id = Integer.valueOf(context);
            Article article = articleService.queryArticleDetail(id);
            RespTextMessage respTextMessage = DefaultResponseTextMessage.createDefaultTextMsg(user.getUserName());

            respTextMessage.setContent("<a color='blue'>" + article.getTitle() + "</a>" + LineSeparator.Web + article.getContent());
            return respTextMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
