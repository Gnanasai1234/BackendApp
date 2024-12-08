package com.klef.jfsd.sdp.controller;

import java.awt.image.RescaleOp;
import java.net.ResponseCache;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.klef.jfsd.sdp.model.Article;
import com.klef.jfsd.sdp.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	
	@PostMapping("/addarticle")
	public ResponseEntity<Void> addArticle(@RequestBody Article article)
	{
		return articleService.addArticle(article);
	}
	@GetMapping("/viewallarticles")
	public ResponseEntity<List<Article>> viewallarticle()
	{
		return articleService.getAllArticles();
	}
	
	@GetMapping("/viewarticlebyid/{aid}")
	public ResponseEntity<Article> viewarticlebyid(@PathVariable int aid)
	{
		return articleService.viewarticlebyid(aid);
	}
	
	@PostMapping("/updatearticle")
	public ResponseEntity<Void> updatearticle(@RequestBody Article article)
	{
		return articleService.updatearticle(article);
	}
}
