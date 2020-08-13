package com.techelevator.model;

public class CatCard {

	private Long catCardId;
	private String imgUrl;
	private String catFact;
	private String caption;
	
	public CatCard(Long catCardId, String imgUrl, String catFact, String caption) {
		this.catCardId = catCardId;
		this.imgUrl = imgUrl;
		this.catFact = catFact;
		this.caption = caption;
	}
	
	public CatCard() {
		
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
		return catFact;
	}
	public void setCatFact(String catFact) {
		this.catFact = catFact;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	

	
}
