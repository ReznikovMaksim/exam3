package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static JsonSerializer serializer = new JsonSerializer("Products.json");
    public static void main(String[] args) {
        try{
            Product[] products = serializer.getGoods();
            action(products);
        }catch (IOException ex){
            System.out.println("файл не найден");
        }
    }
    public static void action(Product[] products) throws IOException{
        Scanner sc = new Scanner(System.in);
        showGoods(products);
        try{
            System.out.println("выбери товар по порядковому номеру");
            int index = sc.nextInt();
            actionWithProduct(products,index-1);
        }catch (InputMismatchException ex){
            System.out.println("нужно вводить цифры");
            action(products);
        }
    }
    public static void actionWithProduct(Product[] products, int index) throws IOException{
        Scanner sc = new Scanner(System.in);
        try{
            while (true){
                showDetails(products[index]);
                System.out.println("1 выставить на аукцион");
                System.out.println("2 поднять цену");
                System.out.println("3 Выдать победителю");
                System.out.println("4 Снять с торгов");
                System.out.println("5 Отобразить информацию о товаре снова");
                System.out.println("6 Вернуться к списку товаров");
                System.out.println("\n выберите номер действия");
                int answer = sc.nextInt();
                switch (answer){
                    case 1:
                        products[index].startSale();
                        break;
                    case 2:
                        products[index].raisePrice();
                        break;
                    case 3:
                        products[index].giveToTheWinner();
                        break;
                    case 4:
                        products[index].withdraw();
                    case 5:
                        break;
                    case 6:
                        action(products);
                        return;
                    default:
                        System.out.println("нет такого действия");
                }
                serializer.writeGoods(products);
            }
        }catch (IndexOutOfBoundsException ex){
            System.out.println("нет товара под таким номером");
            action(products);
        }catch (InputMismatchException inEx){
            System.out.println("Нужно вводить цифры");
            actionWithProduct(products,index);
        }
    }
    public static void showDetails(Product product){
        String format = "|%10s|%20s|%10s|%10s|%15s|";
        System.out.printf(format,"ID","name","state","price","code");
        System.out.println();
        System.out.printf(format,product.getId(),product.getName(),product.getState(),product.getCurrentPrice(),product.getHonorary_code());
        System.out.println();
    }
    public static void showGoods(Product[] products){
        String format = " %4s |%10s | %s";
        System.out.println(String.format(format,"#","ID","name"));
        System.out.println("-----------------------------------");
        for(int i = 0; i < products.length;i++){
            System.out.println(String.format(format,i+1,products[i].getId(),products[i].getName()));
        }
    }
}
