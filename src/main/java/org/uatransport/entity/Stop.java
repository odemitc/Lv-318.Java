package org.uatransport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
public class Stop {

  @Id @GeneratedValue private Integer id;
  private String street;
}
