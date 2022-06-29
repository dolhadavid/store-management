package com.store.entity;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class BaseVersionEntity extends BaseEntity {

  private static final String SYSTEM_USER = "SYSTEM";
  private static final long serialVersionUID = -5511626253029466905L;

  public BaseVersionEntity(ZonedDateTime creationDate, String createdBy, Long version) {
    super(creationDate, createdBy);
    this.version = version;
  }

  @Version
  @Column(name = "version")
  @NotAudited
  protected Long version;
}
