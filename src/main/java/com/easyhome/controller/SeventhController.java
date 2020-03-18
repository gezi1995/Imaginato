package com.easyhome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geziex
 * @Date: 2020/3/18 0018 14:45
 * @Author: Mr.Zheng
 * @Description:
 */
@RestController
public class SeventhController {

    @RequestMapping(value = "/07", method = RequestMethod.POST)
    public int tair(int tairs) {
        int maxJump = 2;
        int i = uptair(tairs, maxJump);
        return i;
    }

    private static int uptair(int tairs, int maxJump) {
        int jump = 0;
        if (tairs == 0) {
            return 1;
        }
        if (tairs >= maxJump) {
            for (int i = 1; i <= maxJump; i++) {
                jump += uptair(tairs - i, maxJump);
            }
        } else {
            jump = uptair(tairs, tairs);
        }
        return jump;
    }

}
