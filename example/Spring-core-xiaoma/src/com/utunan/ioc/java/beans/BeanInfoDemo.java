package com.utunan.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);


        Stream.of(beanInfo.getEventSetDescriptors()).forEach(
                propertyDescriptor -> {
                    Class<?> propertyType = propertyDescriptor.getListenerType();
                    String propertyName = propertyDescriptor.getName();

                    System.out.println(propertyType);
                    System.out.println(propertyName);
                }
        );
    }
}
