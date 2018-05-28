package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FeedbackCriteria {

    @Id
    @GeneratedValue
    private int id;

    private int groupId;

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
