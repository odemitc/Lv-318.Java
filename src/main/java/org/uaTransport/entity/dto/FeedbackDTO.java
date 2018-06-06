package org.uaTransport.entity.dto;


import lombok.Data;
import org.uaTransport.entity.Feedback;
import org.uaTransport.entity.FeedbackCriteria;
import org.uaTransport.entity.Transit;
import org.uaTransport.entity.User;

@Data
public class FeedbackDTO {
    private Integer id;
    private String answer;
    private Integer userId;
    private Integer transitId;
    private Integer criteriaId;

    public Feedback toEntity() {
        return new Feedback()
                .setUser(new User().setId(this.getUserId()))
                .setFeedbackCriteria(new FeedbackCriteria().setId(this.getCriteriaId()))
                .setTransit(new Transit().setId(this.getTransitId()))
                .setAnswer(this.getAnswer());
    }
}
