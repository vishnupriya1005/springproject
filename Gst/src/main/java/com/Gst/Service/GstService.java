package com.Gst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gst.Dao.GstDao;
import com.Gst.Entity.Gst;

@Service
public class GstService {
	@Autowired
	GstDao gDao;
	public String addGst(Gst g) {
		return gDao.addGst(g);
	}
    public String addGstList(List<Gst> g) {
    	return gDao.addGstList(g);
    }
    public List<Gst> getByHsn (int hsn){
    	return gDao.getByHsn(hsn);
    }
    public int getTaxByHsn(int hsn) {
    	return gDao.getTaxByHsn(hsn);
    }
    public int getDiscountByHsn(int hsn) {
    	return gDao.getDiscountByHsn(hsn);
    }
}
