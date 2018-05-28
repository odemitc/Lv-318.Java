package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FeedbackCriteria {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer groupId;

    private String question;

    @Enumerated(value = EnumType.STRING)
    private FeedbackType type;

//    @Embedded
//    private FeedbackTypeIdentifier feedbackTypeIdentifier;

    public enum FeedbackType {
        RATING,
        BUSY_HOURS;


//        public <T> T convertAnswer(String answer) {
//            return //TODO;
//        }
    }
//
//    @Embeddable
//    public class FeedbackTypeIdentifier {
//        int x;
//        double y;
//    }
}
