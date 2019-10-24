package com.bmm.reservation.system;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class BaseRunner {

    public void print(String[] beans) {
        Stream<String> beanNames = Arrays.asList(beans).stream();
        System.out.println("bean name is == ");
        beanNames.forEach(System.out ::println);
    }

    abstract public void run(String[] args);


}
