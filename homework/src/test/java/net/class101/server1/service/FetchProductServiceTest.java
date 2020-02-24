package net.class101.server1.service;

import net.class101.server1.model.Product;
import net.class101.server1.model.ProductType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FetchProductServiceTest {
    private FetchProductService fetchProductService;
    private String fileName = "product_list.csv";


    @Before
    public void init(){
        fetchProductService = new FetchProductService();
        fetchProductService.setFileName(fileName);
    }

    @Test
    public void 파일_읽기() {
        // given & when
        File f = fetchProductService.getFile();

        // then
        assertTrue(f.exists());
    }

    @Test
    public void 상품정보_파싱(){
        // given
        String row = "16374|클래스|스마트스토어로 월 100만원 만들기, 평범한 사람이 돈을 만드는 비법|151950|99999";

        // when
        Product product = fetchProductService.parseToProduct(row.split("\\|"));

        // then
        assertThat(product.getProductId(), is(16374L));
        assertThat(product.getProductType(), is(ProductType.CLASS));
        assertThat(product.getTitle(), is("스마트스토어로 월 100만원 만들기, 평범한 사람이 돈을 만드는 비법"));
        assertThat(product.getStocks(), is(99999));
        assertThat(product.getPrice(), is(151950L));
    }

    @Test
    public void 상품리스트_세팅하기() throws IOException {
        fetchProductService.read();
    }

    @Test
    public void 상품리스트_확인() throws IOException {
        //given
        fetchProductService.read();

        // when
        Map<Long, Product> list = fetchProductService.getProductList();

        //then
        assertTrue(list.size() == 20);
        assertTrue(list.get(42031L).getPrice() == 209000);
        assertTrue(list.get(74218L).getProductType() == ProductType.CLASS);
    }
}