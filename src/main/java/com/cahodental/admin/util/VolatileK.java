package com.cahodental.admin.util;

/*
 * Created by renhongjiang on 2019/3/6.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程变量的同步问题
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/3/6 9:52
 */
public class VolatileK {
    /*
    线程同步时遇到的问题和解决办法
    主要原因：race++ 是非原子操作： 取值 加一 赋值
    1. synchronized修饰方法increase()
    2. 用原子类型的变量race代替，使用getAndIncrement方法实现原子操作
     */

    public static AtomicInteger race = new AtomicInteger(0);

    /*public static volatile int race = 0;*/
    public static void increase() {
        //race++;
        race.getAndIncrement();
    }

    public static final int THREAD_COUNT = 2000;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
            System.out.println("race = " + race);
        }
    }

}