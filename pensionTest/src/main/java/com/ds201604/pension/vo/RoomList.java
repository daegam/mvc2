package com.ds201604.pension.vo;

import java.util.ArrayList;
import java.util.List;

public class RoomList {
	private List<Room> roomList;
	
	public RoomList(){
		roomList = new ArrayList<Room>();
	}
	
	public void add(Room room){
		this.roomList.add(room);
	}

	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
}