package com.Gst.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Gst.Entity.Gst;
import com.Gst.Repository.GstRepository;

@Repository
public class GstDao {
@Autowired
GstRepository gRepo;
public String addGst(Gst g) {
	gRepo.save(g);
	return "Gst added successfully";
}
public String addGstList(List<Gst> g) {
	gRepo.saveAll(g);
	return "Gst List Added Successfully";
}
public List<Gst> getByHsn(int hsn){
	return gRepo.getByHsn(hsn);
}
public int getTaxByHsn(int hsn) {
	return gRepo.getTaxByHsn(hsn);
}
public int getDiscountByHsn(int hsn) {
	return gRepo.getDiscountByHsn(hsn);
}
}
