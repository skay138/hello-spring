package com.study.hellospring.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PayGroupTest {

    @Test
    public void testPayGroup에게_직접_결제종류_물어보기_문자열() throws Exception {
        PayType payType = PayType.KAKAO_PAY;
        PayGroup payGroup = PayGroup.findByPayType(payType);

        assertThat(payType.name()).isEqualTo("KAKAO_PAY");
        assertThat(payType.getTitle()).isEqualTo("카카오페이");

        assertThat(payGroup.name()).isEqualTo("CARD");
        assertThat(payGroup.getTitle()).isEqualTo("카드");

    }

}
