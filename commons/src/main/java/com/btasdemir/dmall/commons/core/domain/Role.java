package com.btasdemir.dmall.commons.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "role")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Role extends BaseEntity {
	
	public Role(Long id, String name, String description) {
		super(id);
		this.setName(name);
		this.setDescription(description);
	}
	
    @Column(name="name", nullable = false, columnDefinition = "varchar(255)")
    @NonNull private String name;
    
    @Column(name="description", columnDefinition = "varchar(255)")
    private String description;
    
	@Override
	public Role clone() throws CloneNotSupportedException  {
		BaseEntity clone = super.clone();
		return (Role) clone;
	}

}
