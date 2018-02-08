package com.btasdemir.dmall.commons.core.dto;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuditDto extends BaseDto {

	private static final long serialVersionUID = 7970293544402827079L;
	
	private DateTime crDate;
	private DateTime moDate;
	private Boolean deleted;

}
