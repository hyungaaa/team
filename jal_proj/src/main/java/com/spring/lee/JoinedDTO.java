package com.spring.lee;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JoinedDTO {

	private PdDTO pdDTO;
	private Pd_inDTO pd_inDTO;
	private Pd_outDTO pd_outDTO;
}
