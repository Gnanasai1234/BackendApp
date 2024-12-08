package com.klef.jfsd.sdp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.model.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

	Article findByAid(int aid);

}
