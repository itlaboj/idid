package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	//フィールド
	@Id
	//@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;

	//コンストラクタ
	public User() {

	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	//アクセッサ・メソッド
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
