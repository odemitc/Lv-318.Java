package com.example.demo.entity;

import com.example.demo.service.converter.ConversionStrategy;
import com.example.demo.service.converter.impl.BusyHoursDurationConversionStrategy;
import com.example.demo.service.converter.impl.RatingConversionStrategy;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class FeedbackCriteria {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer groupId;

    private String question;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private FeedbackType type;

//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "load", insertable = false, updatable = false)
//    private Load load;

    @RequiredArgsConstructor
    public enum FeedbackType {
        RATING(new RatingConversionStrategy()),
        BUSY_HOURS(new BusyHoursDurationConversionStrategy());

        private final ConversionStrategy<?> conversionStrategy;

        @SuppressWarnings("unchecked")
        public <T> T convertFeedback(Feedback feedback) {
            return (T) conversionStrategy.convert(feedback);
        }
    }

//    public enum Load {
//        СИДІВ,
//        СТОЯВ,
//        ЛЕДВЕ_ЗАЛІЗ
//    }
}
