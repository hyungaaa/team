package com.spring.lee;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor // 생성자
//@EqualsAndHashCode // hashcode + equals // 객체가 같은지 판단 기준 map의 key로 사용하는 등의 경우
@Data	// 통합
public class Pd_outDTO {

	int poutseq;
	String plot;
	Date poutdate;
	int poutcnt;
	String poutstate;
	String pnum;
}
