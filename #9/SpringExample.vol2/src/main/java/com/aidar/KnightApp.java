package com.aidar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
        /*
        DI/IoC в действии: не объект ищет и подключает нужные зависимости, а Spring IoC container, пользуясь конфигурацией (бином),
        написанной разработчиком, снабжает его необходимыми зависимостями. Это позволяет сделать более прозрачной и аккуратной структуру
        связанных между собой объектов, упрощает тесты, так как при такой модели тест класса конкретного объекта не затрагивает другие,
        которые связаны с этим объектом.
        */
        Knight arthur = context.getBean("knight_Arthur", Knight.class);
        System.out.println("Knight named Arthur managed to complete quest - " + arthur.embarkOnQuest());
        /*
        А это уже autowire с параметром byName, что означает - конфигурация будет искать бин с таким же именем, как и параметр,
        требующий инициализации. Причем здесь нужен не конструктор, а сеттер.
        */
        Knight unknown = context.getBean("knight_Unknown", Knight.class);
        System.out.println("Knight with unknown name managed to complete quest - " + unknown.embarkOnQuest());
    }
}
