package com.study.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.hellospring.payment.EnumMapper;
import com.study.hellospring.payment.FeeType;
import com.study.hellospring.payment.PayGroup;
import com.study.hellospring.payment.PayType;

@Configuration
public class AppConfig {

    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();

        enumMapper.put("FeeType", FeeType.class);

        return enumMapper;
    }
}
