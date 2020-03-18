
package com.easyhome.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SecondController {

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String[] students(Integer[] students) {
        String[] strings = new String[students.length];
        for (int i = 0; i < students.length; i++
        ) {
            strings[i] = "C";
            if (students[i] >= 60) {
                strings[i] = "B";
                if (students[i] >= 90) {
                    strings[i] = "A";
                }
            }
        }
        return strings;
    }

}
