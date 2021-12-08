package com.company;

public class Product {
    private String id;
    private double startPrice;
    private String name;
    private String honorary_code;
    private String state;
    private transient State productState;
    private double currentPrice;

    public Product(String id, double startPrice, String name, String honorary_code, String state) {
        this.id = id;
        this.startPrice = startPrice;
        this.name = name;
        this.honorary_code = honorary_code;
        this.state = state;
        currentPrice = startPrice;
        fillState();
    }
    public void fillState(){
        if(state.equals("sold")){
            productState = new SoldState();
        }else if(state.equals("for_sale")){
            productState = new ForSaleState();
        }else {
            productState = new InStockState();
        }
    }
    public void startSale(){
        try {
            productState.startSale(this);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void raisePrice(){
        try {
            productState.raisePrice(this);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void withdraw(){
        try {
            productState.withdraw(this);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void giveToTheWinner(){
        try {
            productState.giveToTheWinner(this);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public double getStartPrice() {
        return startPrice;
    }

    public void setHonorary_code(String honorary_code) {
        this.honorary_code = honorary_code;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProductState(State productState) {
        this.productState = productState;
    }

    public void setCurrentPrice(double price) {
        this.currentPrice = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHonorary_code() {
        return honorary_code;
    }

    public String getState() {
        return state;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
