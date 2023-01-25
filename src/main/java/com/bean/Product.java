package com.bean;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;



@Entity
public class Product {

	@Id
	private int pid;
	private String pname;
	private float price;
	private String url;
	private int cid;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", url=" + url + "]";
	}


	
	
	
	
}
