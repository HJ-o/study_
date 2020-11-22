package com.edwith.display_info.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Displayinfo {
	private Long product_id;
	private Long category_id;
	private Long displayinfo_id;
	private String name;
	private String description;
	private String content;
	private String event;
	private String opening_hours;
	private String place_name;
	private String place_lot;
	private String place_street;
	private String tel;
	private String homepage;
	private String email;
	private Timestamp create_date;
	private Timestamp modify_date;
}
