package com.btasdemir.dmall.commons.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "category")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends AuditEntity {
	
	@Column(name="category_key", nullable = false, columnDefinition = "varchar(255)", unique = true)
	@NonNull private String categoryKey;
	
	@Column(name="name", nullable = false, columnDefinition = "varchar(255)")
	@NonNull private String name;
	
	@Column(name="description", nullable = true, columnDefinition = "varchar(255)")
	private String description;
	
	@ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="parent_id")
	private Category parent;

	@Override
	public Category clone() throws CloneNotSupportedException  {
		AuditEntity clone = super.clone();
		return (Category) clone;
	}

}
