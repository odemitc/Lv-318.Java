package org.uaTransport.entity.dto;


import lombok.Data;
import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;
import org.uaTransport.entity.User;

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
