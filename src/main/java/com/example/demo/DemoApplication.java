package com.example.demo;

import com.example.demo.entity.ExtendableCategory;
import com.example.demo.entity.FeedbackCriteria;
import com.example.demo.entity.NonExtendableCategory;
import com.example.demo.repository.ExtendableCategoryRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.NonExtendableCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

//    @Autowired
//    private ExtendableCategoryRepository extendableCategoryRepository;
//
//    @Autowired
//    private NonExtendableCategoryRepository nonExtendableCategoryRepository;
//
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);


//
//        ExtendableCategoryRepository categoryRepository = context.getBean(ExtendableCategoryRepository.class);
//        NonExtendableCategoryRepository nonExtendableCategoryRepo = context.getBean(NonExtendableCategoryRepository.class);
//
//        ExtendableCategory publicTransport = new ExtendableCategory().setName("Public Transport");
//        ExtendableCategory lviv = new ExtendableCategory().setName("Lviv").setNextLevelCategory(publicTransport);
//        NonExtendableCategory tram = new NonExtendableCategory();
//
//        tram.setName("Tram")
//                .setNextLevelCategory(lviv);
//
//        nonExtendableCategoryRepo.save(tram);
    }

//    @Override
//    @Transactional
//    public void run(ApplicationArguments args) throws Exception {
//
//        Optional<ExtendableCategory> lviv = extendableCategoryRepository.findById(17);
//
//        NonExtendableCategory nonExtendableCategory = new NonExtendableCategory();
//
////        lviv.get().setName("Lviv");
//
//        nonExtendableCategory
//                .setName("Masrshrutka")
//                .setNextLevelCategory(lviv.get());
//
//        nonExtendableCategoryRepository.save(nonExtendableCategory);
//    }
}
