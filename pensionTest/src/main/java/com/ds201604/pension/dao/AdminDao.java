package com.ds201604.pension.dao;


import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ds201604.pension.vo.Admin;
import com.ds201604.pension.vo.Pension;
import com.ds201604.pension.vo.Room;
import com.ds201604.pension.vo.RoomList;


public class AdminDao extends SqlSessionDaoSupport{
	
	//로그인
	public Admin loginAdmin(Admin admin){
		return this.getSqlSession().selectOne("Admin.login", admin);
	}
	
	//펜션 등록
	public void regPension(Pension pension){
		this.getSqlSession().insert("Admin.regPension", pension);
	}
	
	//펜션 목록 가져오기
	public List<Pension> getPensionList(){
		return this.getSqlSession().selectList("Admin.getPensionList");
	}
	
	//방 목록 가져오기
	public List<Room> getRoomList(int pension_no){
		return this.getSqlSession().selectList("Admin.getRoomList", pension_no);
	}
	
	//방 삭제
	public void deleteRoom(int room_no){
		this.getSqlSession().delete("Admin.deleteRoom", room_no);
	}
	
	//방 추가,수정
	public void addupdateRoom(List<Room> add_roomList, RoomList update_roomList){
		
		for(int i=0; i<add_roomList.size(); i++){
			Room add_room = add_roomList.get(i);
			this.getSqlSession().insert("Admin.addRoom", add_room);
		}
		
		for(int i=0; i<update_roomList.getRoomList().size(); i++){
			Room update_room = update_roomList.getRoomList().get(i);
			this.getSqlSession().update("Admin.updateRoom", update_room);
		}
	}
}