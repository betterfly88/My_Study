package com.class101.homework.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTypeTest {

    @Test
    public void 상품타입_분류하기(){
        // given
        String classType = "클래스";
        String kitType = "키트";

        // when
        ProductType cType = ProductType.setProductType(classType);
        ProductType kType = ProductType.setProductType(kitType);

        //then
        assertTrue(cType.equals(ProductType.CLASS));
        assertTrue(kType.equals(ProductType.KIT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 상품타입_정의되지_않은값(){
        // given
        String EMPTY = "공백";

        //when & then
        ProductType.setProductType(EMPTY);
    }
}