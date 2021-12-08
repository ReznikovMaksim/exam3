package com.company;

import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer {
    private String fileName;

    public JsonSerializer(String fileName) {
        this.fileName = fileName;
    }

    public Product[] getGoods() throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader(fileName)){
            Product[] products = gson.fromJson(reader,Product[].class);
            for(int i = 0; i < products.length; i++){
                products[i].fillState();
            }
            return products;
        }
    }
    public void writeGoods(Product[] products) throws IOException {
        Gson gson = new Gson();
        try(Writer writer = new FileWriter(fileName)){
            String json = gson.toJson(products);
            writer.write(json);
        }
    }
}
