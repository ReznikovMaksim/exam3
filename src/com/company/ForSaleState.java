package com.company;

public class ForSaleState extends State{
    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("товар уже на торгах");
    }

    @Override
    public void raisePrice(Product product) throws Exception {
        product.setCurrentPrice(product.getCurrentPrice() + 100);
        System.out.println("Цена успешно поднялась");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        if(product.getCurrentPrice() != product.getStartPrice()){
            throw new Exception("цена уже поднялась, нельзя снять с торгов");
        }
        product.setState("in_stock");
        product.setProductState(new InStockState());
        System.out.println("товар возвращен на склад");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        if(product.getCurrentPrice() == 0){
            throw new Exception("нельзя отдавать товар бесплатно");
        }
        product.setState("sold");
        product.setProductState(new SoldState());
        String code = "";
        if(product.getCurrentPrice() >= 1000){
            code = new GoldCode().makeCode(product.getId());
        }else if(product.getCurrentPrice() >= 500 && product.getCurrentPrice() < 1000){
            code = new SilverCode().makeCode(product.getId());
        }else {
            code = new BronzeCode().makeCode(product.getId());
        }
        product.setHonorary_code(code);
        System.out.println("товар продан");
    }
}
