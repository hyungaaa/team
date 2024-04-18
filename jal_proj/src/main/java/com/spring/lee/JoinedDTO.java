package com.spring.lee;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JoinedDTO {

	private Pd_inDTO pd_inDTO;
	private PdDTO pdDTO;
}
