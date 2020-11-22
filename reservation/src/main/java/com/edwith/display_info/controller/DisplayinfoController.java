package com.edwith.display_info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edwith.display_info.dto.Displayinfo;
import com.edwith.display_info.service.DisplayinfoService;

@RestController
@RequestMapping(path="/api/displayinfos")
public class DisplayinfoController {
//상품 목록 구하기
	@Autowired
	DisplayinfoService displayinfoService;
	
	@GetMapping("/{category_Id}")
	@ResponseBody		//왜 @ResponseBody를 써줘야 @PathVariable값이 null이 안되는가?
	public Map<String, Object> getdisplayinfos(@PathVariable Optional<Integer> category_Id){ //null값으로 들어올 경우를 대비하여 Optional 사용
		int categoryId = category_Id.isPresent()? category_Id.get() : 0;
		List<Displayinfo> displayinfo = displayinfoService.getDisplayinfos(categoryId);
		Map<String, Object> map = new HashMap<>();
		map.put("size", displayinfo.size());
		map.put("items", displayinfoService.getProductCount(categoryId));
		map.put("products", displayinfo);
		return map;
	}
	
	
}
