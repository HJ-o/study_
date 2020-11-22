package com.edwith.display_info.dao;

import static com.edwith.display_info.dao.DisplayinfoDaoSqls.SELECTAll;
import static com.edwith.display_info.dao.DisplayinfoDaoSqls.SELECT_COUNT_PRODUCT;
import static com.edwith.display_info.dao.DisplayinfoDaoSqls.SELECT_COUNT_PRODUCT_by_ID;
import static com.edwith.display_info.dao.DisplayinfoDaoSqls.SELECT_by_ID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edwith.display_info.dto.Displayinfo;

@Repository
public class DisplayinfoDao {
	//Dao들도 공용 interface로 구현해두면 편할듯?

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Displayinfo> rowMapper = BeanPropertyRowMapper.newInstance(Displayinfo.class);
	
	
	public List<Displayinfo> getDisplayinfos() {
		return jdbc.query(SELECTAll, rowMapper);
	}
	
	public List<Displayinfo> getDisplayinfos(int categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", categoryId);
		return jdbc.query(SELECT_by_ID, params, rowMapper);
	}

	
	//items(해당 카테고리에 속하는 product의 수)를 반환
	public int getProductCount() {
		return jdbc.queryForObject(SELECT_COUNT_PRODUCT, Collections.emptyMap(), Integer.class);
	}

	public int getProductCount(int categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", categoryId);
		return jdbc.queryForObject(SELECT_COUNT_PRODUCT_by_ID, params, Integer.class);
	}

}
