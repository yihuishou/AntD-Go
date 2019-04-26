package com.jwtsecurity.services;

import com.jwtsecurity.model.Article;

/**
 * Created by LadyLady on 2019-04-26.
 */

public interface ArticleServices {

    Article findArticle(Integer id);

    boolean deleteArticle(Integer id);

    Article updateArticle(Article article);

    Article addArticle(Article article);

}
