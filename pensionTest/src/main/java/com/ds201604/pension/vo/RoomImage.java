package com.ds201604.pension.vo;

public class RoomImage {
	private int no;				//방 사진 번호
	private String name;		//방 사진 이름
	private int room_no;		//방 번호
	private String upload_date;	//최근 업로드 시간
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
}