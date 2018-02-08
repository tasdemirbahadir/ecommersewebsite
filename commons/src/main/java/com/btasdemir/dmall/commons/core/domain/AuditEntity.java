package com.btasdemir.dmall.commons.core.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

import com.btasdemir.dmall.commons.core.dto.AuditDto;
import com.btasdemir.dmall.commons.core.util.DateUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AuditEntity extends BaseEntity {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cr_date", nullable = true, columnDefinition = "datetime")
	private Date crDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mo_date", nullable = true, columnDefinition = "datetime")
	private Date moDate;
	
	@Column(name="deleted", nullable = true, columnDefinition = "bit(1)")
	private Boolean deleted = false;
	
	@PreUpdate
	public void setUpdateDate() {  
		this.setMoDate(new Timestamp(new DateTime().getMillis()));
	}
	
	@PrePersist
	public void setCreateDate() {  
		this.setCrDate(new Timestamp(new DateTime().getMillis()));
	}
	
	@Override
	public AuditEntity clone() throws CloneNotSupportedException  {
		BaseEntity clone = super.clone();
		return (AuditEntity) clone;
	}
	
	public AuditEntity(AuditDto auditDto, DateUtils dateUtils) {
		if (auditDto != null) {
			this.setCrDate(dateUtils.toDate(auditDto.getCrDate()));
			this.setMoDate(dateUtils.toDate(auditDto.getMoDate()));
		}
	}

}
