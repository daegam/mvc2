package com.ds201604.pension.vo;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String postcode;
	private String road_addr;
	private String jibun_addr;
	private String detail_addr;
	private String join_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRoad_addr() {
		return road_addr;
	}
	public void setRoad_addr(String road_addr) {
		this.road_addr = road_addr;
	}
	public String getJibun_addr() {
		return jibun_addr;
	}
	public void setJibun_addr(String jibun_addr) {
		this.jibun_addr = jibun_addr;
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
}