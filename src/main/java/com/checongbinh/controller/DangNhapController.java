package com.checongbinh.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.checongbinh.entity.NhanVien;
import com.checongbinh.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {

	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default(){
		
		return "dangnhap";
	}
	
	@PostMapping
	public String DangKy(@RequestParam String email,@RequestParam String matkhau,@RequestParam String nhaplaimatkhau) {
		
		boolean ktmail= validate(email);
		if(ktmail) {
			if(matkhau.equals(nhaplaimatkhau)) {
				NhanVien nhanVien=new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setMatkhau(matkhau);
				nhanVien.setTendangnhap(email);
				
				nhanVienService.ThemNhanVien(nhanVien);
			}
		}else {
			
		}
		
		return "dangnhap";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
	
	public static boolean validate(String emailStr) {
		Matcher matcher= VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
}
