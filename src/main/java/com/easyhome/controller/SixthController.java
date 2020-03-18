package com.easyhome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geziex
 * @Date: 2020/3/18 0018 14:44
 * @Author: Mr.Zheng
 * @Description:
 */
@RestController
public class SixthController {

    @RequestMapping(value = "/06", method = RequestMethod.POST)
    public String deadLock() {
        new Thread(() -> {
            synchronized (String.class) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1, 等lock2");
                synchronized (Integer.class) {
                    System.out.println("线程1完成");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (Integer.class) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2, 等lock1");
                synchronized (String.class) {
                    System.out.println("线程2完成");
                }
            }
        }).start();
        return "deadLock";
    }

}
