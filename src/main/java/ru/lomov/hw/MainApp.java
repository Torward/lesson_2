package ru.lomov.hw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       MainController mainController = context.getBean(MainController.class);
       mainController.init();
        context.close();
    }
}
