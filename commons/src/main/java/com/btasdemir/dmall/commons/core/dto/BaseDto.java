package com.btasdemir.dmall.commons.core.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {

	private static final long serialVersionUID = -512904443886604446L;
	
	private Long Id;
	
}
