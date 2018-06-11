package org.uatransport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.modelmapper.ModelMapper;
import org.uatransport.entity.dto.FeedbackDTO;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Feedback {

    @Id
    @GeneratedValue
    private Integer id;

    private String answer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "transit_id")
    private Transit transit;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "criteria_id")
    private FeedbackCriteria feedbackCriteria;

    ModelMapper modelMapper = new ModelMapper();

    private FeedbackDTO convertToDto() {
        FeedbackDTO feedbackDTO = modelMapper.map(this, FeedbackDTO.class);
        return feedbackDTO.setId(this.getId())
                .setAnswer(this.getAnswer())
                .setUserId(this.getUser().getId())
                .setCriteriaId(this.getFeedbackCriteria().getId())
                .setTransitId(this.getFeedbackCriteria().getId());

    }
}
