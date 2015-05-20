package com.joe.wxchat.execute;

import com.joe.server.service.ArticleService;
import com.joe.utils.SpringContextHolder;
import com.joe.wxchat.entity.message.resp.RespBaseMessage;
import com.joe.server.dao.entity.User;

/**
 *
 * Created by zhouwd on 15-5-17.
 */
public abstract class AbstractCommand {

    public abstract RespBaseMessage execute(User user);

    public ArticleService getArticleServiceBean(){
        return SpringContextHolder.getBean("articleService");
    }
}
