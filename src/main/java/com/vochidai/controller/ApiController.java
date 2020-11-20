package com.vochidai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vochidai.entity.GioHang;
import com.vochidai.service.NhanVienService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "email", "giohang" })
public class ApiController {

	@Autowired
	NhanVienService nhanVienService;

	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {

		boolean kiemtra = nhanVienService.KiemTraDangNhap(email, matkhau);
		modelMap.addAttribute("email", email);

		return "" + kiemtra;
	}

	@GetMapping("ThemGioHang")
	@ResponseBody
	public void ThemGioHang(@RequestParam int masp, @RequestParam int masize, @RequestParam int mamau,
			@RequestParam String tensp, @RequestParam String giatien, @RequestParam String tenmau,
			@RequestParam String tensize, @RequestParam int soluong, HttpSession httpSession) {
		
		if (null==httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = new ArrayList<>();

			GioHang gioHang = new GioHang();
			gioHang.setMasp(masp);
			gioHang.setMasize(masize);
			gioHang.setMamau(mamau);
			gioHang.setTensp(tensp);
			gioHang.setSoluong(1);
			gioHang.setTensize(tensize);
			gioHang.setTenmau(tenmau);
			gioHang.setGiatien(giatien);

			gioHangs.add(gioHang);
			httpSession.setAttribute("giohang", gioHangs);
			
			List<GioHang> listGioHangs=(List<GioHang>) httpSession.getAttribute("giohang");
			System.out.println(listGioHangs.size());
			
		} else {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri=KiemTraSanPhamDaTonTaiGioHang(listGioHangs,httpSession, masp, masize, mamau);
			if(vitri==-1) {
				GioHang gioHang = new GioHang();
				gioHang.setMasp(masp);
				gioHang.setMasize(masize);
				gioHang.setMamau(mamau);
				gioHang.setTensp(tensp);
				gioHang.setTensize(tensize);
				gioHang.setTenmau(tenmau);
				gioHang.setGiatien(giatien);
				gioHang.setSoluong(1);
				
				listGioHangs.add(gioHang);
				
			}else {
				int soluongmoi=listGioHangs.get(vitri).getSoluong()+1;
				listGioHangs.get(vitri).setSoluong(soluongmoi);
			}
		}
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		for(GioHang gioHang:listGioHangs) {
			System.out.println(gioHang.getMasp()+" - "+gioHang.getTenmau()+" - "+gioHang.getTensize()+" - "+gioHang.getSoluong());
		}
	}

	private int KiemTraSanPhamDaTonTaiGioHang(List<GioHang> listGioHangs ,HttpSession httpSession, int masp, int masize, int mamau) {

		for (int i = 0; i < listGioHangs.size(); i++) {
			if (listGioHangs.get(i).getMasp() == masp && listGioHangs.get(i).getMamau() == mamau
					&& listGioHangs.get(i).getMasize() == masize) {
				return i;
			}
		}
		return -1;
	}
}
