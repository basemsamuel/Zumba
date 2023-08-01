package com.ZumbaProStudio.controller;

public class batchInfo {
	public int bid;
	public String name;
	public String stime;
	public String etime;
	public int capacity;
	public String description;
	public String days;
	
	public batchInfo() {
		
	}
	
	public batchInfo(int bid, String name, String stime, String etime, int capacity, String description, String days) {
		super();
		this.bid = bid;
		this.name = name;
		this.stime = stime;
		this.etime = etime;
		this.days = days;
		this.capacity = capacity;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "batchInfo [bid=" + bid + ", name=" + name + ", stime=" + stime + ", etime=" + etime + ", capacity=" + capacity + ", description=" + description + ", days=" + days +"]";
	}

	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	public String getBatchName() {
		return name;
	}
	public void setBatchName(String name) {
		this.name = name;
	}
	public String getStart() {
		return stime;
	}
	public void setStart(String stime) {
		this.stime = stime;
	}
	public String getEnd() {
		return etime;
	}
	public void setEnd(String etime) {
		this.etime = etime;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getDetails() {
		return description;
	}
	public void setDetails(String description) {
		this.description = description;
	}
}
