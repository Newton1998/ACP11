package org.example.EShop;

import org.example.EShop.dao.JPAUserDao;
import org.example.EShop.model.Product;
import org.example.EShop.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/app-context.xml");
        JPAUserDao dao = context.getBean(JPAUserDao.class);
        String random = String.valueOf((int)(Math.random() * 100));
        User user = new User("avsimvadim@gmal.co" + random, "Kiril", "94848", "1");
        Product product = new Product("Car", 1344.0, "hey", "No", user);
        List<Product> list = List.of(product);
        user.setProducts(list);
        dao.create(user);
        dao.findAll().stream().forEach(System.out::println);
    }
}
