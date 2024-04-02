package com.example.moin.controller;

import com.example.moin.dto.ArticleForm;
import com.example.moin.entity.Article;
import com.example.moin.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 어노테이션 골뱅이
public class ArticleController {
    @Autowired //스프링부트가 미리 생성해놓은 객체를 가져가다 자동연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //System.out.println(form.toString()); -> 로깅으로 대체!
        log.info(form.toString());
        //1. Dto를 변환! to Entity!
        Article article = form.toEntity();

        //2. Repository에게 Entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());

        return "";
    }
}
