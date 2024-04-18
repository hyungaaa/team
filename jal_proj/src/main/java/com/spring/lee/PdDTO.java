package com.spring.lee;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PdDTO {
	
	String pnum;
	String wzone;
	String scid;
	String pname;
	String pday;
	String punit;
	int pamount;
	String psize;
	
}
