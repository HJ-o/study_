package com.edwith.display_info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwith.display_info.dao.DisplayinfoDao;
import com.edwith.display_info.dto.Displayinfo;

@Service
public class DisplayinfoService {

	@Autowired
	DisplayinfoDao displayinfoDao;
	
	public List<Displayinfo> getDisplayinfos(int categoryId) {
		if(categoryId == 0) return displayinfoDao.getDisplayinfos();
		else return displayinfoDao.getDisplayinfos(categoryId);
	}

	public int getProductCount(int categoryId) {
		if(categoryId == 0) return displayinfoDao.getProductCount();
		else return displayinfoDao.getProductCount(categoryId);
	}

}
