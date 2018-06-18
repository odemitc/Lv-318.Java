package org.uatransport.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "question")
@EqualsAndHashCode(of = "id")
public class Question {

  @Id @GeneratedValue private Integer id;

  private Integer groupId;

  private String name;
}
