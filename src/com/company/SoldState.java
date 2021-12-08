package com.company;

public class SoldState extends State{
    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("Товар уже продан, ничего с ним сделать нельзя");
    }

    @Override
    public void raisePrice(Product product) throws Exception {
        throw new Exception("Товар уже продан, ничего с ним сделать нельзя");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new Exception("Товар уже продан, ничего с ним сделать нельзя");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new Exception("Товар уже продан, ничего с ним сделать нельзя");
    }
}
