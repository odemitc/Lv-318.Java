package org.uatransport.config.modelmapperconfig;

import lombok.RequiredArgsConstructor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import org.uatransport.entity.Feedback;
import org.uatransport.entity.dto.FeedbackDTO;

@Component
@RequiredArgsConstructor
public class FeedbackMap extends PropertyMap<Feedback, FeedbackDTO> {
    @Override
    protected void configure() {
        map().setTransitId(source.getTransit().getId())
                .setCriteriaId(source.getFeedbackCriteria().getId())
                .setUserId(source.getUser().getId());
        map(source.getFeedbackCriteria().setId(map().getCriteriaId()));
        map(source.getTransit().setId(map().getTransitId()));
        map(source.getUser().setId(map().getUserId()));
    }

}
