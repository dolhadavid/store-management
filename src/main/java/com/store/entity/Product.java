package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
@Table(name = "products")
public class Product extends BaseVersionEntity {
  // TODO: add relation with user after authorization mechanism is done
  private static final long serialVersionUID = -3482277318640867969L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "price")
  private Double price;

  @Column(name = "description")
  @Size(max = 200)
  private String description;

  @OneToOne
  @JoinTable(
      name = "product_user",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private User user;
}
