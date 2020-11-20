package com.vochidai.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vochidai.daoimp.SanPhamImp;
import com.vochidai.entity.ChiTietSanPham;
import com.vochidai.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<SanPham> LayDanhSachSanPhamLimit(int spbatdau) {
		Session session=sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams=(List<SanPham>)session.createQuery("from sanpham").setFirstResult(spbatdau).setMaxResults(10).getResultList();
		
		return listSanPhams;
	}
	@Override
	@Transactional
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham){
		Session session=sessionFactory.getCurrentSession();
		String query="from sanpham sp where sp.masanpham="+masanpham;
		SanPham SanPhams=(SanPham) session.createQuery(query).getSingleResult();
		
		
		return SanPhams;
	}
	
}
