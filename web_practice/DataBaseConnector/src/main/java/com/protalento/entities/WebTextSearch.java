package com.protalento.entities;

import java.time.LocalDateTime;

import com.protalento.utilities.LocalDateUtillities;

public class WebTextSearch {
	//private fields:
	private int id;
	private String text;
	private String url;
	private String htmlContent;
	private int coincidences;
	private LocalDateTime date;
	
	//Constructors: 
	public WebTextSearch() {
		super();
	}

	public WebTextSearch(int id, String text, String url, String htmlContent, int coincidences, LocalDateTime date) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.htmlContent = htmlContent;
		this.coincidences = coincidences;
		this.date = date;
	}
	
	//Getters and Setters: 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public int getCoincidences() {
		return coincidences;
	}

	public void setCoincidences(int coincidences) {
		this.coincidences = coincidences;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "WebTextSearch [id=" + id + ", text=" + text + ", url=" + url + ", htmlContent=" + htmlContent
				+ ", coincidences=" + coincidences + ", date=" + LocalDateUtillities.getLocalDateTimeString(date, LocalDateUtillities.SQL_DATETIME_PATTERN) + "]";
	}

}
