package com.btasdemir.dmall.commons.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Product extends AuditEntity {
	
    @Column(name="title", nullable = false, columnDefinition = "varchar(255)")
    @NonNull private String title;
    
    @Column(name="description", nullable = false, columnDefinition = "varchar(1000)")
    @NonNull private String description;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch= FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST}, fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    @NonNull private User user;
    
	@Override
	public Product clone() throws CloneNotSupportedException  {
		AuditEntity clone = super.clone();
		return (Product) clone;
	}

}