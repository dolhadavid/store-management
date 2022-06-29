package com.store.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 3561104912320386394L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "username", unique = true)
  @Size(max = 50)
  private String username;

  @Column(name = "name")
  @Size(max = 50)
  private String name;

  @Column(name = "surname")
  @Size(max = 50)
  private String surname;
}
