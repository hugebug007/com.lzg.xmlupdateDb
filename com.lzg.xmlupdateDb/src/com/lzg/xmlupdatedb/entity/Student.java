package com.lzg.xmlupdatedb.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Student")
public class Student implements Serializable {

	/**
	 * 学生表测试类
	 */
	private static final long serialVersionUID = -118421523502838450L;
	@DatabaseField(generatedId = true)
	private Integer id;
	@DatabaseField
	private String name;
	@DatabaseField
	private String sex;
	@DatabaseField
	private String no;
	@DatabaseField
	private String greed;

	// @DatabaseField
	// private String isPeer;
	// @DatabaseField
	// private String siteCode;

	public Student() {
		super();
	}

	public Student(String name, String sex, String no
	// , String isPeer, String siteCode
	) {
		super();
		this.name = name;
		this.sex = sex;
		this.no = no;
		// this.isPeer = isPeer;
		// this.siteCode = siteCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	// public String getIsPeer() {
	// return isPeer;
	// }
	//
	// public void setIsPeer(String isPeer) {
	// this.isPeer = isPeer;
	// }
	//
	// public String getSiteCode() {
	// return siteCode;
	// }
	//
	// public void setSiteCode(String siteCode) {
	// this.siteCode = siteCode;
	// }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
