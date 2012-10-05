package com.mindstorm.quoteapp;

public class Quote {
	String id;
	String who;
	String what;
    
    public Quote() {
		super();
	}
	public Quote(String id, String who, String what) {
		super();
		this.id = id;
		this.who = who;
		this.what = what;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public String getId() {
		return id;
	}
}
