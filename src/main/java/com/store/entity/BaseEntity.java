package com.store.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class BaseEntity implements Serializable {
  // TODO(DDA): handle to not used default createdBy after authorization mechanism is done
  private static final String SYSTEM_USER = "SYSTEM";
  private static final long serialVersionUID = -5511626253029466905L;

  @Column(name = "creation_date")
  protected ZonedDateTime creationDate;

  @Column(name = "created_by")
  protected String createdBy;

  @PrePersist
  public void prePersist() {
    creationDate = ZonedDateTime.now();
    createdBy = SYSTEM_USER;
  }
}
