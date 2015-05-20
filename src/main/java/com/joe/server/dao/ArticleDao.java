package com.joe.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.joe.server.dao.entity.Article;
import com.joe.wxchat.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

/**
 * NOTE: Article dao.
 * Created by zhouwd on 15-5-16.
 */
@Repository
public class ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Article> queryArticleList(int pageNum, int pageRow, String queryStr) {
        int start = pageNum * pageRow;
        int end = pageNum * pageRow + pageRow;
        String sql = "select * from article where title like ? limit " + start + " , " + end;
        return jdbcTemplate.query(sql, new Object[]{"%" + queryStr + "%"}, new RowMapper<Article>() {
            @Override
            public Article mapRow(ResultSet resultSet, int i) throws SQLException {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setDateTime(resultSet.getLong("dateTime"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setAuthor(resultSet.getString("author"));
                return article;
            }
        });
    }

    public Article queryArticleDetail(int id) {
        String sql = "select * from article where id=?";
        RowMapper<Article> rw = ParameterizedBeanPropertyRowMapper.newInstance(Article.class);
        return jdbcTemplate.queryForObject(sql, rw, id);
    }

    public int insertArticle(Article article) {
        String sql = "insert into article(title,content,author,dateTime) values(?,?,?,?)";
        return jdbcTemplate.update(sql, article.getTitle(), article.getContent(), article.getAuthor(), article.getDateTime());
    }

    public int queryCounts(String queryStr) {
        String sql = "select count(*) as countNum from article where title like ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, "%" + queryStr + "%");
        return result / Constants.RESP_MESSAGE_ARTICLES_PAGENUM;
    }

    public int deleteAriticle(int id){
        String sql="delete from article where id=?";
        return jdbcTemplate.update(sql, id);
    }
}
