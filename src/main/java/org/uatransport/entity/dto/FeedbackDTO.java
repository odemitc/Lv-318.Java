package org.uatransport.entity.dto;


import lombok.Data;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.FeedbackCriteria;
import org.uatransport.entity.Transit;
import org.uatransport.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class FeedbackDTO {

    private Integer id;
    private String answer;
    private Integer userId;
    private Integer transitId;
    private Integer criteriaId;

    private Feedback toEntity() {
        return new Feedback()
                .setUser(new User().setId(this.getUserId()))
                .setFeedbackCriteria(new FeedbackCriteria().setId(this.getCriteriaId()))
                .setTransit(new Transit().setId(this.getTransitId()))
                .setAnswer(this.getAnswer());
    }

    public static List<Feedback> toEntity(List<FeedbackDTO> feedbackDTOList) {
        return feedbackDTOList.stream()
                .map(FeedbackDTO::toEntity)
                .collect(Collectors.toList());
    }
}
