package com.techelevator.model;

public class CatCard {

	private Long catCardId;
	private String imgUrl;
	private String catfact;
	private String caption;
	
	
	public CatCard() {
		
	}
	
	public CatCard(Long catCardId, String imgUrl, String fact, String caption) {
		this.catCardId = catCardId;
		this.imgUrl = imgUrl;
		this.catfact = fact;
		this.caption = caption;
	}
	
	public Long getCatCardId() {
		return catCardId;
	}
	public void setCatCardId(Long catCardId) {
		this.catCardId = catCardId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCatFact() {
		return catfact;
	}
	public void setCatFact(String fact) {
		this.catfact = fact;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	
	
}
