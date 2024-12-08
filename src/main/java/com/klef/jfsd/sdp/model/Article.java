package com.klef.jfsd.sdp.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "article_table")
public class Article {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String relatedto;
	private String title;
	 	@Column(columnDefinition = "TEXT") 
	    private String description;
	 	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getRelatedto() {
		return relatedto;
	}
	public void setRelatedto(String relatedto) {
		this.relatedto = relatedto;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
