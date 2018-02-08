package com.btasdemir.dmall.commons.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class User extends AuditEntity {
	
	@Column(name="first_name", nullable = false, columnDefinition = "varchar(255)")
    @NonNull private String firstName;
	
	@Column(name="last_name", nullable = false, columnDefinition = "varchar(255)")
    @NonNull private String lastName;
	
	@Column(name="email", nullable = false, columnDefinition = "varchar(255)")
    @NonNull private String email;
	
	@Column(name="password", nullable = false, columnDefinition = "varchar(255)")
    @NonNull private String password;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="role_id")
    @NonNull private Role role;
	
	@Override
	public User clone() throws CloneNotSupportedException  {
		AuditEntity clone = super.clone();
		return (User) clone;
	}

}
