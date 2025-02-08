package org.example.task9_products;

import java.util.HashMap;

public class PriceList {
    HashMap<String, Double> priceList = new HashMap<>();

    public void addNewProduct (Product product){
        this.priceList.put(product.getProductName(), product.getProductPrice());
    }

    public HashMap<String, Double> getPriceList(){
        return priceList;
    }

    public void changePrice(Product product){
        if(this.priceList.containsKey(product.getProductName())){
            System.out.println("Продукт " +product.getProductName()+" уже есть, заменить цену");
            addNewProduct(product);
        }
        else {
            System.out.println("Продукта "+product.getProductName()+" нет в списке");
        }
    }

    public String getPrice(Product product){
        String productPrice = String.valueOf(this.priceList.get(product.getProductName()));
        return productPrice;
    }
}
