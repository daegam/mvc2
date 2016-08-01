package com.ds201604.pension.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ds201604.pension.dao.AdminDao;
import com.ds201604.pension.vo.Admin;
import com.ds201604.pension.vo.Pension;
import com.ds201604.pension.vo.Room;
import com.ds201604.pension.vo.RoomImage;
import com.ds201604.pension.vo.RoomList;

@Controller
public class AdminController {
	FileOutputStream fos;

	@Resource(name = "adminDao")
	private AdminDao adminDao;

	// 로그인
	@RequestMapping(value = "/loginAdmin.do", method = RequestMethod.GET)
	public ModelAndView adminLogin() {

		return new ModelAndView("member/login", "login", new Admin());

	}

	@RequestMapping(value = "/loginAdmin.do", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute(value = "login") Admin admin, HttpSession session) {

		Admin login_admin = adminDao.loginAdmin(admin);

		if (login_admin == null) {
			System.out.println("관리자 로그인 실패");
			return "redirect:loginMember.do";
		} else {
			System.out.println("관리자 로그인 성공");
			session.setAttribute("login_admin", admin);
			return "admin/adminPage";
		}
	}

	// 펜션목록
	@RequestMapping(value = "/pensionList.do", method = RequestMethod.GET)
	public String pensionList(Model model) {
		
		List<Pension> arr_pension = adminDao.getPensionList();
		model.addAttribute("arr_pension", arr_pension);
		
		return "admin/pensionList";
		
	}

	// 펜션등록
	@RequestMapping(value = "/regPension.do", method = RequestMethod.GET)
	public ModelAndView regPension() {

		return new ModelAndView("admin/regPension", "pension", new Pension());
	}

	@RequestMapping(value = "/regPension.do", method = RequestMethod.POST)
	public String regPension(@ModelAttribute(value = "pension") Pension pension) {

		try{
			byte[] b = pension.getPicture().getBytes();
			
			String filename = pension.getPicture().getOriginalFilename();
			File file = new File("C:\\Users\\DS\\git\\mvc2\\pensionTest\\src\\main\\webapp\\resources\\img\\pension", filename);
			if(file.exists()){
				filename = System.currentTimeMillis() + pension.getPicture().getOriginalFilename();
				file = new File("C:\\Users\\DS\\git\\mvc2\\pensionTest\\src\\main\\webapp\\resources\\img\\pension", filename);
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(b);
			fos.close();
			
			pension.setPicture_name(filename);
			
			adminDao.regPension(pension);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "redirect:pensionList.do";
	}
	
	//방 리스트
	@RequestMapping(value = "/roomList.do", method = RequestMethod.GET)
	public String roomList(
			@RequestParam(value="pension_no") int pension_no,
			@RequestParam(value="pension_name") String pension_name,
			Model model) {
		
		List<Room> arr_room = adminDao.getRoomList(pension_no);
		
		model.addAttribute("arr_room", arr_room);
		model.addAttribute("pension_no", pension_no);
		model.addAttribute("pension_name", pension_name);
		return "admin/roomList";
	}
	
	//방 삭제하기
	@RequestMapping(value = "/roomDel.do", method = RequestMethod.GET)
	public String roomDel(
			@RequestParam(value="pension_no") int pension_no,
			@RequestParam(value="pension_name") String pension_name,
			@RequestParam(value="room_no") int room_no,
			Model model) {
		
		adminDao.deleteRoom(room_no);
		List<Room> arr_room = adminDao.getRoomList(pension_no);
		
		model.addAttribute("arr_room", arr_room);
		model.addAttribute("pension_no", pension_no);
		model.addAttribute("pension_name", pension_name);
		
		return "admin/roomList";
	}
	
	//방 추가,저장
	@RequestMapping(value = "/roomAddUpdate.do", method = RequestMethod.GET)
	public String roomAddUpdate(
			@RequestParam(value="pension_no") int pension_no,
			@RequestParam(value="pension_name") String pension_name,
			Model model) {
		
		RoomList roomList = new RoomList();
		List<Room> arr_room = adminDao.getRoomList(pension_no);
		
		if(arr_room.size() != 0){
			for(int i=0; i<arr_room.size(); i++){
				roomList.add(arr_room.get(i));
			}
			model.addAttribute("roomList", roomList);
		}
		
		model.addAttribute("pension_no", pension_no);
		model.addAttribute("pension_name", pension_name);
		return "admin/roomAddUpdate";
	}
	
	@RequestMapping(value = "/roomAddUpdate.do", method = RequestMethod.POST)
	public String roomAddUpdate(
			@ModelAttribute("roomList") RoomList update_roomList,
			@RequestParam(value="pension_no") int pension_no,
			@RequestParam(value="pension_name") String pension_name,
			@RequestParam(value="name", required=false, defaultValue="") String[] name,
			@RequestParam(value="size", required=false, defaultValue="" ) String[] size,
			@RequestParam(value="standard_num", required=false, defaultValue="") String[] standard_num,
			@RequestParam(value="max_num", required=false, defaultValue="") String[] max_num,
			@RequestParam(value="weekdays_price", required=false, defaultValue="") String[] weekdays_price,
			@RequestParam(value="weekend_price", required=false, defaultValue="") String[] weekend_price,
			@RequestParam(value="adult_addprice", required=false, defaultValue="") String[] adult_addprice,
			@RequestParam(value="child_addprice", required=false, defaultValue="") String[] child_addprice){
		
		List<Room> add_roomList = new ArrayList<Room>();
		
		for(int i=0; i<name.length; i++){
			Room room = new Room();
			room.setName(name[i]);
			room.setPension_no(pension_no);
			room.setSize(size[i]);
			room.setStandard_num(Integer.parseInt(standard_num[i]));
			room.setMax_num(Integer.parseInt(max_num[i]));
			room.setWeekdays_price(Integer.parseInt(weekdays_price[i]));
			room.setWeekend_price(Integer.parseInt(weekend_price[i]));
			room.setAdult_addprice(Integer.parseInt(adult_addprice[i]));
			room.setChild_addprice(Integer.parseInt(child_addprice[i]));
			
			add_roomList.add(room);
		}
		
		adminDao.addupdateRoom(add_roomList, update_roomList);
		
		return "redirect:roomList.do?pension_no=" + pension_no + "&pension_name=" + pension_name;
	}
	
	//사진 업로드
	@RequestMapping(value = "/uploadRoomImage.do", method = RequestMethod.POST)
	public String uploadRoomImage(
			@RequestPart(value="room_img", required=false) List<MultipartFile> arr_room_img,
			@RequestParam(value="room_no") int room_no) {
		
		List<RoomImage> arr_ri;
		
		try{
			MultipartFile room_img;
			for(int i=0; i<arr_room_img.size(); i++){
				room_img = arr_room_img.get(i);
				System.out.println(room_img);
				if(room_img == null){
					System.out.println("비엇음");
				}
				
				byte[] b = room_img.getBytes();
				
				String filename = room_img.getOriginalFilename();
				File file = new File("C:\\Users\\DS\\git\\mvc2\\pensionTest\\src\\main\\webapp\\resources\\img\\room", filename);
				
				if(file.exists()){
					filename = System.currentTimeMillis() + room_img.getOriginalFilename();
					file = new File("C:\\Users\\DS\\git\\mvc2\\pensionTest\\src\\main\\webapp\\resources\\img\\room", filename);
				}
				
				fos = new FileOutputStream(file);
				fos.write(b);
				fos.close();
				
				RoomImage roomImage = new RoomImage();
				roomImage.setName(filename);
				roomImage.setRoom_no(room_no);
				System.out.println(room_no);
			}
			
			
			/*
			
			pension.setPicture_name(filename);
			
			adminDao.regPension(pension);*/
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}