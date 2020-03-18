package com.easyhome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: geziex
 * @Date: 2020/3/18 0018 12:03
 * @Author: Mr.Zheng
 * @Description:
 */
@RestController
public class FourthController {

    @RequestMapping(value = "/brackets", method = RequestMethod.POST)
    public String brackets(String s) {
        int left = -1;
        int right = -1;
        List<Integer> ds = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '(') {
                left = i;
                int temp = String.valueOf(stringBuilder).indexOf(')', right + 1);
                if (temp == -1) {
                    stringBuilder.replace(i, i + 1, "");
                    if (i<right){
                        right = right - 1;
                    }
                    if (i > stringBuilder.length()) {
                        break;
                    }
                    i = i - 1;
                }
                right = temp == -1 ? right : temp;
                continue;
            }
            if (i == -1) {
                continue;
            }
            if (stringBuilder.charAt(i) == ')') {
                int temp = i;
                if (temp != right) {
                    stringBuilder.replace(i, i + 1, "");
                }
                continue;
            }
        }
        return "text:" + String.valueOf(stringBuilder);
    }

}
