package org.uatransport.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.modelmapper.ModelMapper;
import org.springframework.expression.ParseException;
import org.uatransport.entity.Feedback;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
public class FeedbackDTO {

    private Integer id;
    private String answer;
    private Integer userId;
    private Integer transitId;
    private Integer criteriaId;

    ModelMapper modelMapper = new ModelMapper();

    public Feedback convertToEntity() throws ParseException {
        return modelMapper.map(this, Feedback.class);
        // return feedback
        // .setId(this.getId()==null?new Feedback().getId():this.getId())
        // .setAnswer(this.getAnswer())
        // .setUser(new User().setId(this.getUserId()))
        // .setFeedbackCriteria(new FeedbackCriteria().setId(this.getCriteriaId()))
        // .setTransit(new Transit().setId(this.getTransitId()));
    }

    public static List<Feedback> toEntity(List<FeedbackDTO> feedbackDTOList) {
        return feedbackDTOList.stream().map(FeedbackDTO::convertToEntity).collect(Collectors.toList());
    }

    private FeedbackDTO convertToDto(Feedback feedback) {
        FeedbackDTO feedbackDTO = modelMapper.map(this, FeedbackDTO.class);
        return feedbackDTO.setAnswer(feedback.getAnswer()).setUserId(feedback.getUser().getId())
                .setCriteriaId(feedback.getFeedbackCriteria().getId())
                .setTransitId(feedback.getFeedbackCriteria().getId());
    }
}
