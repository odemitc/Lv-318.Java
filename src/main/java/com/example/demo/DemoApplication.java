package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@RequiredArgsConstructor
public class DemoApplication {
//    private final ApplicationContext context;

//    @Autowired
//    private ExtendableCategoryRepository extendableCategoryRepository;
//
//    @Autowired
//    private TransitRepository transitRepository;
//
//    @Autowired
//    private NonExtendableCategoryRepository nonExtendableCategoryRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        int x = 1;


//        context.getBean(StopRepository.class).saveAll(Arrays.asList(
//            new Stop().setStreet("Zelena").setBuilding("131"),
//            new Stop().setStreet("Mebleva").setBuilding("14")
//        ));

//        context.getBean(TransitRepository.class).save(new Transit()
//            .setName("138 J Washington - Lapaivka")
//            .setCategory(context.getBean(NonExtendableCategoryRepository.class).findById(25).get())
//            .setStops((List<Stop>)context.getBean(StopRepository.class).findAllById(Arrays.asList(1, 2)))
//        );

//        int sum = context.getBean(FeedbackRepository.class).findByTransitId(1)
//                .stream()
//                .filter(feedback -> feedback.getFeedbackCriteria().getType() == FeedbackCriteria.FeedbackType.RATING)
//                .mapToInt(feedback -> Integer.valueOf(feedback.getAnswer()))
//                .sum();
//
//        System.out.println(sum);
//
//        int x = 777;

//        ExtendableCategoryRepository categoryRepository = context.getBean(ExtendableCategoryRepository.class);
//        NonExtendableCategoryRepository nonExtendableCategoryRepo = context.getBean(NonExtendableCategoryRepository.class);
////
//        ExtendableCategory publicTransport = new ExtendableCategory().setName("Public Transport");
//        ExtendableCategory lviv = new ExtendableCategory().setName("Lviv").setNextLevelCategory(publicTransport);
//        NonExtendableCategory tram = new NonExtendableCategory();
//
//        tram.setName("Tram")
//                .setNextLevelCategory(lviv);
//
//        nonExtendableCategoryRepo.save(tram);
//    }

//    @Override
//    @Transactional
//    public void run(ApplicationArguments args) throws Exception {
//        Transit transit = context.getBean(TransitRepository.class).findById(5).get();
//        transit.getFeedbacks().size();
//    }
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
//   }
    }
}
