package ua.ithillel.lectures.lecture_9;

import ua.ithillel.lectures.lecture_3.school.Student;
import ua.ithillel.lectures.lecture_9.generics.Camera;
import ua.ithillel.lectures.lecture_9.generics.Container;
import ua.ithillel.lectures.lecture_9.generics.Phone;
import ua.ithillel.lectures.lecture_9.generics.Product;

import java.util.ArrayList;
import java.util.List;

public class Lecture9 {
    public static void main(String[] args) {
        rawTypes();

        generics();
    }

    private static void generics() {
        Container < Product> container = new Container<>();

        Camera camera = new Camera("Canon", 150);
        Phone phone = new Phone("Samsung",100);

        container.add(camera);
        container.add(phone);

        List<Product>products = new ArrayList<>();
        products.add(camera);
        products.add(phone);

        System.out.println("Products contains product " + findProduct(products,phone));
    }

    public static <T>  boolean findProduct(List<T> products,T product){
        for (T p: products){
            if (product.equals(p)){
                return true;
            }
        }
        return false;
    }

    private static void rawTypes() {
        List myList= new ArrayList();
        myList.add(1);
        myList.add("string");
        myList.add(new Student());

        for (Object o : myList){
            if (o instanceof String){
                String str = (String) o;
                System.out.println("String = " + str);
            }
            if (o instanceof Integer){
                Integer integer = (Integer) o;
                System.out.println("String = " + integer);
            }

        }
        String s = (String)  myList.get(0);
    }

}
