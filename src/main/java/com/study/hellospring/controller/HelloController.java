package com.study.hellospring.controller;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.hellospring.payment.EnumMapper;
import com.study.hellospring.payment.EnumMapperValue;
import com.study.hellospring.payment.FeeType;

@Controller
public class HelloController {

    @Autowired
    EnumMapper enumMapper;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", defaultValue = "익명") String name, Model model) {
        model.addAttribute("name", name);

        return "hello-template";
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("payment")
    @ResponseBody
    public String payment() {

        List<EnumMapperValue> payTypeList = enumMapper.get("PayType");

        System.out.println(payTypeList);

        List<EnumMapperValue> e = Arrays.stream(FeeType.values()).map(EnumMapperValue::new)
                .collect(Collectors.toList());

        return e.toString();
    }
}
