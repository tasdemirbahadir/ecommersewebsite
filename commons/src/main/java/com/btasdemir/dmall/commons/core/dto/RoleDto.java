package com.btasdemir.dmall.commons.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class RoleDto extends BaseDto {

	private static final long serialVersionUID = 6599095655666805637L;

	private String name;
    
    private String description;
	
}
