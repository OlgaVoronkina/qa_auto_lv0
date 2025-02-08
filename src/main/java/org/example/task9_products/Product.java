package org.example.task9_products;
/**
 * Создайте класс Product с полями для наименования и цены товара.
 * В классе PriceList используйте HashMap<String,Double> для хранения списка товаров, где ключом является название товара, а значением - его цена
 * Реализуйте методы для добавления нового товара в список с его ценой, изменения цены товара и получения цены товара по его наименованию
 */
public class Product {
    private String productName;
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
