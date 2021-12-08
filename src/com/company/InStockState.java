package com.company;

public class InStockState extends State{
    @Override
    public void startSale(Product product) throws Exception {
        product.setProductState(new ForSaleState());
        product.setState("for_sale");
        System.out.println("Товар выставлен на торги");
    }

    @Override
    public void raisePrice(Product product) throws Exception {
        throw new Exception("Нельзя поднимать цену товара на складе");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new Exception("Товар уже на складе");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new Exception("Нельзя отдать товар со склада");
    }
}
