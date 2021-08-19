package com.example.kafka0809_1;

import com.example.kafka0809_1.listener.IKafkaListener;
import com.example.kafka0809_1.listener.testCunsumer;
import com.example.kafka0809_1.util.SpringContextUtil;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.MemberValue;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Kafka08091Application {

    public static void main(String[] args) throws NotFoundException {
//        SpringApplication.run(Kafka08091Application.class, args);
        ConfigurableApplicationContext run = SpringApplication.run(Kafka08091Application.class, args);
        /*SpringContextUtil.setApplicationContext(run);
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringContextUtil.getApplicationContext();
        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        // 通过BeanDefinitionBuilder创建bean定义,创建bean信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(testCunsumer.class);
        // 设置属性userService,此属性引用已经定义的bean:userService,这里userService已经被spring容器管理了.
//        beanDefinitionBuilder.addPropertyReference("topic", "testService");
        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("testController", beanDefinitionBuilder.getBeanDefinition());
        IKafkaListener receiver = (IKafkaListener) SpringContextUtil.getBean("testController");*/


    }

}
