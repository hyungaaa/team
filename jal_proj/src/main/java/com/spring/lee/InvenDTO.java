package com.spring.lee;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class InvenDTO {
	PdDTO pdDTO;
	Pd_inDTO pd_inDTO;
	InvenDTO2 invenDTO2;
}
