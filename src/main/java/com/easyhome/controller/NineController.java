package com.easyhome.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: geziex
 * @Date: 2020/3/18 0018 12:03
 * @Author: Mr.Zheng
 * @Description:
 */
@RestController
public class NineController {

    private final static Map<String, Object> map = new HashMap<>();

    @RequestMapping(value = "/pool", method = RequestMethod.POST)
    public int cach(HashMap<String,Object>[] arrs) {
        for (HashMap h : arrs
        ) {
            Iterator iter = h.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                map.put((String) entry.getKey(),entry.getValue());
            }
        }
        return map.size();
    }

    @RequestMapping(value = "/pool/{key}", method = RequestMethod.GET)
    public Object get(@PathVariable("key") String key) {
        return map.get(key) != null ? map.get(key):"404";
    }

    @RequestMapping(value = "/pool/{key}", method = RequestMethod.POST)
    public String delete(@PathVariable("key") String key) {
        Object remove = map.remove(key);
        if (remove != null){
            return "200";
        }
        return "404";
    }

}
