package com.vochidai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vochidai.dao.SanPhamDAO;
import com.vochidai.daoimp.SanPhamImp;
import com.vochidai.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{
	@Autowired
	SanPhamDAO sanPhamDAO;

	@Override
	public List<SanPham> LayDanhSachSanPhamLimit(int spbatdau) {
		
		return sanPhamDAO.LayDanhSachSanPhamLimit(spbatdau);
	}

	@Override
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham) {
		return sanPhamDAO.LayDanhSachChiTietSanPhamTheoMa(masanpham);
	}
	
	
}
