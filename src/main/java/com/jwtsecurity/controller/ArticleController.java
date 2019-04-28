package com.jwtsecurity.controller;

import com.jwtsecurity.bo.ResponseMessage;
import com.jwtsecurity.model.Article;
import com.jwtsecurity.services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LadyLady on 2019-04-19.
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleServices articleServices;


    @GetMapping("{id}")
    public ResponseMessage findOneArticle(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();

        Article oneArticle = articleServices.findOneArticle(id);
        responseMessage.setMessage("查询成功");
        responseMessage.setStrutsCode("200");
        responseMessage.setData(oneArticle);

        return responseMessage;


    }


    @PutMapping
    public ResponseMessage updateArticle(@RequestBody Article article) {

        Article updateArticle = articleServices.updateArticle(article);


        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("更新成功");
        responseMessage.setStrutsCode("200");
        responseMessage.setData(updateArticle);
        return responseMessage;

    }

    @PostMapping
    public ResponseMessage addNewArticle(@RequestBody Article article) {

        final Article addArticle = articleServices.addArticle(article);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("添加成功");
        responseMessage.setStrutsCode("200");
        responseMessage.setData(addArticle);
        return responseMessage;

    }

    @DeleteMapping("{id}")
    public ResponseMessage deleteArticle(@PathVariable Integer id) {

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);
        responseMessage.setMessage("失败");
        if (articleServices.deleteArticle(id)) {
            responseMessage.setMessage("成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(null);
        }


        return responseMessage;

    }
}
