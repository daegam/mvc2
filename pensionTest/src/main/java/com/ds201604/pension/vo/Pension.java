package com.ds201604.pension.vo;

import org.springframework.web.multipart.MultipartFile;

public class Pension {
	private String no;					//펜션 번호
	private String name;				//펜션 이름
	private MultipartFile picture;		//펜션 대표사진
	private String picture_name;		//사진 이름
	private String busy_season_start;	//성수기 시작일
	private String busy_season_end;		//성수기 마감일
	private String check_in_time;		//입실시간
	private String check_out_time;		//퇴실시간
	private String addr;				//주소
	private String tel;					//문의전화
	private String reg_date;			//펜션 등록일자
	
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
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public String getBusy_season_start() {
		return busy_season_start;
	}
	public void setBusy_season_start(String busy_season_start) {
		this.busy_season_start = busy_season_start;
	}
	public String getBusy_season_end() {
		return busy_season_end;
	}
	public void setBusy_season_end(String busy_season_end) {
		this.busy_season_end = busy_season_end;
	}
	public String getCheck_in_time() {
		return check_in_time;
	}
	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}
	public String getCheck_out_time() {
		return check_out_time;
	}
	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getPicture_name() {
		return picture_name;
	}
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}
}