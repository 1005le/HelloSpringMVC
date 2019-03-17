package org.o7planning.hellospringmvc.config;

import org.o7planning.hellospringmvc.model.Order;
import org.o7planning.hellospringmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.o7planning.hellospringmvc.*") 
public class ApplicationContextConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
  
    //cách tao  bean : kieu du lieu là person ,trên config:
    @Bean(name="person", initMethod="init",destroyMethod="destroy")
    @Scope(value="prototype")
    public Person person() {
    	Person person = new Person("Ha1","Ha Noi1");
		return person;
    	
    }
    //cach tao bean theo inject , su dung autowire băng cách thêm đôi sô Person person
    
    @Bean(name="person2")
    public Person person2() {
    	Person person = new Person("Ha2","Ha Noi2");
		return person;
    	
    }
    @Bean
    @Autowired
    @Qualifier("person2")
    public Order order(Person person) {
    	//Autowire: Spring sẽ tìm bean kiểu dữ liệu là Person, sau đó gán vào đối số
    	//su dung inject de bean person thông qua tên hàm
    	//Spring hieu rang : su dung person2 làm gia tri cho bien Person
		return new Order(person);
    	
    }
}
