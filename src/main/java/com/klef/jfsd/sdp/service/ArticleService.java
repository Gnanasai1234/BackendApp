package com.klef.jfsd.sdp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.klef.jfsd.sdp.model.Article;

public interface ArticleService {
	
	public ResponseEntity<Void> addArticle(Article article);

	public ResponseEntity<List<Article>> getAllArticles();

	public ResponseEntity<Void> updatearticle(Article article);

	public ResponseEntity<Article> viewarticlebyid(int aid);

}
