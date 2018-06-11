package org.uatransport.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.uatransport.service.converter.ConversionStrategy;
import org.uatransport.service.converter.impl.BusyHoursDurationConversionStrategy;
import org.uatransport.service.converter.impl.RatingConversionStrategy;
import org.uatransport.service.converter.impl.RouteBusyHoursConversionStrategy;

import javax.persistence.*;

@Entity
@Data
@Inheritance
@DiscriminatorColumn(name = "CRITERIA_TYPE")
@DiscriminatorValue("FEEDBACK_CRITERIA")
@Accessors(chain = true)
@Table(name = "feedback_criteria")
@EqualsAndHashCode(of = "id")
public class FeedbackCriteria {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "question_id")
    private Integer questionId;

//    @ElementCollection
//    @CollectionTable(name = "feedback_criteria", joinColumns = @JoinColumn(name = "question_id"))
//    private List<String> question;

    private Integer weight;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", updatable = false)
    private FeedbackType type;

    @RequiredArgsConstructor
    public enum FeedbackType {

        RATING(new RatingConversionStrategy()),
        BUSY_HOURS(new BusyHoursDurationConversionStrategy()),
        ROUTE_BUSY_HOURS(new RouteBusyHoursConversionStrategy()),
        ACCEPTER(new RatingConversionStrategy()),
        CAPACITY(new RatingConversionStrategy());

        private final ConversionStrategy<?> conversionStrategy;

        @SuppressWarnings("unchecked")
        public <T> T convertFeedback(Feedback feedback) {
            return (T) conversionStrategy.convert(feedback);
        }

    }
}
