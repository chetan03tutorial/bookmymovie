package com.bmm.reservation.system;

@FunctionalInterface
public interface ApplicationRunner {
    public void run(String[] args);

    default public void apply(String[] args){
        this.run(args);
    }
}
