package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Inheritance
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("FEEDBACK_CRITERIA")
@Accessors(chain = true)
@Table(name = "criteria")
@EqualsAndHashCode(of = "id")
public class FeedbackCriteria {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer groupId;

    private String question;

    @Enumerated(value = EnumType.STRING)
    private FeedbackType type;

//    private FeedbackTypeIdentifier feedbackTypeIdentifier;

    public enum FeedbackType {
        RATING,
        BUSY_HOURS;


        public <T> T convertAnswer(String answer) {
            return null; //TODO;
        }
    }

    @Embeddable
    public class FeedbackTypeIdentifier {

        @Enumerated(value = EnumType.STRING)
        private FeedbackType type;

        private transient Class<?> feedbackClass;

        private FeedbackTypeIdentifier() {

        }
    }
}
