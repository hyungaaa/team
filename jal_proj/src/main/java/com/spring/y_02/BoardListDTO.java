package com.spring.y_02;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BoardListDTO {
	int bno;
	String uuid;
	String uname;
	String btitle;
	String pnum;
	String bdate;
	String btext;
	int bbits;

}
