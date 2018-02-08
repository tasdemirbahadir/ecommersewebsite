package com.btasdemir.dmall.commons.core.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.btasdemir.dmall.commons.core.dto.BaseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Override
	public BaseEntity clone() throws CloneNotSupportedException  {
		Object clone = super.clone();
		return (BaseEntity) clone;
	}
	
	public BaseEntity(BaseDto baseDto) {
		if (baseDto != null) {
			this.setId(baseDto.getId());
		}
	}

}
