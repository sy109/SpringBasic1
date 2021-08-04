package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.nimbus.State;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        
//        //Thread A : A 사용자 10000원 주문
//        statefulService1.order("nameA",10000);
//        //Thread B : b 사용자 20000원 주문
//        statefulService1.order("nameB",20000);
        
        //Thread A : 사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
        //Thread A : A 사용자 10000원 주문
        int UserA_Price = statefulService1.order("nameA", 10000);
        //Thread B : b 사용자 20000원 주문
        int UserB_Price = statefulService1.order("nameB", 20000);

        System.out.println("UserA_Price = " + UserA_Price);
        System.out.println("UserB_Price = " + UserB_Price);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}