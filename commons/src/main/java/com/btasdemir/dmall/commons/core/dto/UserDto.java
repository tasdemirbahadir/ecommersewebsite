package com.btasdemir.dmall.commons.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class UserDto extends AuditDto {
	
	private static final long serialVersionUID = -6399446322162626153L;
    
	private String firstName;
	
    private String lastName;
	
    private String email;
	
    private RoleDto role;
	
}
