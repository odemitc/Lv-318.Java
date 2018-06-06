package org.uaTransport.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("NON_EXTENDABLE")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class NonExtendableCategory extends ExtendableCategory {

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<FeedbackCriteria> feedbackCriterias;
}
