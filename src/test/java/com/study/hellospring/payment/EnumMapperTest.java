package com.study.hellospring.payment;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

import org.junit.jupiter.api.Test;

class EnumMapperTest {

    EnumMapper enumMapper = new EnumMapper();

    @Test
    public void EnumMapper_테스트() throws Exception {
        enumMapper.put("FeeType", FeeType.class);

        PayType payType = PayType.KAKAO_PAY;
        PayGroup payGroup = PayGroup.findByPayType(payType);

        assertThat(payType.name()).isEqualTo("KAKAO_PAY");
        assertThat(payType.getTitle()).isEqualTo("카카오페이");
        assertThat(payGroup.getTitle()).isEqualTo("카드");

    }

}
