package com.joe.wxchat.execute.command;

import java.util.List;

import com.joe.server.dao.entity.Article;
import com.joe.server.service.ArticleService;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.wxchat.entity.user.User.User;
import com.joe.wxchat.execute.AbstractCommand;
import com.joe.wxchat.execute.messagemodel.ArticleResponseMessage;
import com.joe.wxchat.execute.messagemodel.DefaultResponseTextMessage;
import com.joe.wxchat.utils.OpertionConstants;

/**
 * NOTE:
 * Created by zhouwd on 15-5-17.
 */
public class QueryCommand extends AbstractCommand {
    @Override
    public RespBaseMessage execute(User user) {
        ArticleService articleService = getArticleServiceBean();
        String context = user.getCurrentContent().replace(OpertionConstants.OPER_QUERY, "");
        int pageCount = articleService.queryCounts(context);
        if (pageCount < 0) {
            return DefaultResponseTextMessage.getNullTextMsg(user);
        }
        user.setPageNum(0);
        user.setCurrentContent(context);
        user.setPageCounts(pageCount);
        List<Article> articleList = articleService.queryArticleList(user);
        return ArticleResponseMessage.getDefaultTextMsg(user, articleList);
    }
}
