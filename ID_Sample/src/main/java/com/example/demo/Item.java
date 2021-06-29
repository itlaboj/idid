package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Item {
	//フィールド
	@Id
	//@Column(name="code")
	private int code;
	private String name;
	private int price;

	//コンストラクタ
	public Item() {

	}

	public Item(int code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	//アクセッサ・メソッド
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
