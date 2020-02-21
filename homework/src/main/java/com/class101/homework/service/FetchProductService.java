package com.class101.homework.service;


import com.class101.homework.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FetchProductService {
    private static final String DELIMITER = "\\|";
    private Map<Long, Product> productList = new HashMap<>();

    private String fileName;

    @Value("${product.list.fileName}")
    public void setFileName(String fileName){
        this.fileName = fileName;
    }


    public File getFile() {

        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }

    public void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(getFile()))){

            String row = "";
            while((row = br.readLine()) != null){
                String [] rows = row.split(DELIMITER);
                productList.put(Long.parseLong(rows[0]), parseToProduct(rows));
            }
        }
    }

    public Product parseToProduct(String [] rows){
        return Product.bindToProduct(rows);
    }

    public Map<Long, Product> getProductList(){
        return this.productList;
    }
}