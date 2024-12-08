package com.klef.jfsd.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Article;
import com.klef.jfsd.sdp.repository.ArticleRepo;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ArticleRepo articleRepo;
	
	@Override
	public ResponseEntity<Void> addArticle(Article article) {
		try {
			articleRepo.save(article);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}

	@Override
	public ResponseEntity<List<Article>> getAllArticles() {
		try {
			List<Article> articles= articleRepo.findAll();
			System.out.println(articles);
			return new ResponseEntity<>(articles,HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Void> updatearticle(Article article) {
		try {
			articleRepo.save(article);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Article> viewarticlebyid(int aid) {
	    try {
	        Article article = articleRepo.findByAid(aid);
	        
	        
	            return new ResponseEntity<>(article, HttpStatus.ACCEPTED);
	       
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


}
