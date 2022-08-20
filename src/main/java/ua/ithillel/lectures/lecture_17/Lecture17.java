package ua.ithillel.lectures.lecture_17;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.ithillel.lectures.lecture_17.entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Lecture17 {
    public static void main(String[] args) throws IOException {
        Product product = new Product("product", 10);
        Product product1 = new Product("product1", 100);
        List<Product> products = List.of(product1, product);

        try (Writer writer = new FileWriter("product.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(products, writer);
        }
    }
}
