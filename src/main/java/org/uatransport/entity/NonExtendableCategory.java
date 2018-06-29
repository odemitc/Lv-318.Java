package org.uatransport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<FeedbackCriteria> feedbackCriterias;
}
