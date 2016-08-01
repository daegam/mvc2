package com.ds201604.pension.vo;

public class Room {
	private String no; // 방 번호
	private String name; // 방 이름
	private int pension_no; // 펜션 번호
	private String size; // 방 크기
	private int standard_num; // 입실 기준인원
	private int max_num; // 입실 최대인원
	private int weekdays_price; // 주중요금
	private int weekend_price; // 주말요금
	private int adult_addprice; // 어른 추가요금
	private int child_addprice; // 어린이 추가요금
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPension_no() {
		return pension_no;
	}
	public void setPension_no(int pension_no) {
		this.pension_no = pension_no;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getStandard_num() {
		return standard_num;
	}
	public void setStandard_num(int standard_num) {
		this.standard_num = standard_num;
	}
	public int getMax_num() {
		return max_num;
	}
	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}
	public int getWeekdays_price() {
		return weekdays_price;
	}
	public void setWeekdays_price(int weekdays_price) {
		this.weekdays_price = weekdays_price;
	}
	public int getWeekend_price() {
		return weekend_price;
	}
	public void setWeekend_price(int weekend_price) {
		this.weekend_price = weekend_price;
	}
	public int getAdult_addprice() {
		return adult_addprice;
	}
	public void setAdult_addprice(int adult_addprice) {
		this.adult_addprice = adult_addprice;
	}
	public int getChild_addprice() {
		return child_addprice;
	}
	public void setChild_addprice(int child_addprice) {
		this.child_addprice = child_addprice;
	}
}