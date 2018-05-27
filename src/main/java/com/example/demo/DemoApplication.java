package com.example.demo;

import com.example.demo.entity.ExtendableCategory;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.repository.ExtendableCategoryRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.NonExtendableCategoryRepository;
import com.example.demo.service.interfaces.ExtendebleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;
import lombok.Data;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private ExtendebleCategoryService extendebleCategoryService;

//    @Autowired
//    private ExtendableCategoryRepository extendableCategoryRepository;

//    @Autowired
//    private NonExtendableCategoryRepository nonExtendableCategoryRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        ExtendebleCategoryService extendebleCategoryService = context.getBean(ExtendebleCategoryService.class);

        ExtendableCategory publicTransport = new ExtendableCategory();
        publicTransport.setId(1);
        publicTransport.setName("Public Transport");
        extendebleCategoryService.save(publicTransport);

        ExtendableCategory lviv = new ExtendableCategory();
        lviv.setId(2);
        lviv.setName("Lviv");
        lviv.setNextLevelCategory(publicTransport);
        extendebleCategoryService.save(lviv);

        ExtendableCategory kyiv = new ExtendableCategory();
        kyiv.setId(3);
        kyiv.setName("Kyiv");
        kyiv.setNextLevelCategory(publicTransport);
        extendebleCategoryService.save(kyiv);

        System.out.println("LIST========================");
        extendebleCategoryService.listExtendableCategories().stream().forEach(System.out::println);

        System.out.println("FINDBYNAME========================");
        ExtendableCategory findBy = extendebleCategoryService.findByName("Lviv").get();
        System.out.println(findBy.getName()+" "+findBy.getId());


        System.out.println("FINDBYNEXTLEVELID========================");
        extendebleCategoryService.findByNextLevelCategoryId(1).stream().forEach(System.out::println);

        System.out.println("FINDBYNEXTLEVELCATEGORY========================");
        extendebleCategoryService.findByNextLevelCategory(publicTransport).stream().forEach(System.out::println);

//        extendebleCategoryService.delete(lviv);

//        extendebleCategoryService.delete(publicTransport);
    }

}
