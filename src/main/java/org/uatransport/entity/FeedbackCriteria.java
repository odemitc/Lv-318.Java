package org.uatransport.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.uatransport.service.converter.ConversionStrategy;
import org.uatransport.service.converter.impl.AccepterConversionStrategy;
import org.uatransport.service.converter.impl.CapacityBusyHoursConversionStrategy;
import org.uatransport.service.converter.impl.RatingConversionStrategy;
import org.uatransport.service.converter.model.CapacityFeedback;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "feedback_criteria")
@EqualsAndHashCode(of = "id")
public class FeedbackCriteria {

  @Id @GeneratedValue private Integer id;

  private Integer weight;

  @JsonManagedReference
  @OneToMany
  @JoinColumn(name = "criteria_id")
  private List<Question> questions;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "type", updatable = false)
  private FeedbackType type;

  @RequiredArgsConstructor
  public enum FeedbackType {
    RATING(new RatingConversionStrategy()),
    ROUTE_BUSY_HOURS(new CapacityBusyHoursConversionStrategy()),
    ACCEPTER(new AccepterConversionStrategy()),
    CAPACITY(new CapacityBusyHoursConversionStrategy());

    private final ConversionStrategy<?> conversionStrategy;

    @SuppressWarnings("unchecked")
    public <T> T convertFeedback(Feedback feedback) {
      return (T) conversionStrategy.convert(feedback);
    }
  }

  public static class TypedFeedbackType<T> {
    public static final TypedFeedbackType<CapacityFeedback> CAPACITY = new TypedFeedbackType<>();

    public FeedbackType get() {
       return FeedbackType.CAPACITY;
    }
  }
}
