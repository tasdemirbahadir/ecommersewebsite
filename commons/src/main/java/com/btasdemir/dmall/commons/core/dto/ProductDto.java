package com.btasdemir.dmall.commons.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class ProductDto extends AuditDto {

	private static final long serialVersionUID = -6594861659946573276L;
	
	private String title;
	private String description;
	private CategoryDto category;
	
}
