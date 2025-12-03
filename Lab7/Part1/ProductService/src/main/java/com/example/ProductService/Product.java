package com.example.ProductService;

public class Product {
    private int productNumber;
    private String name;
    private int stockNumber = 0;

    public Product(int productNumber, String name) {
        this.productNumber = productNumber;
        this.name = name;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", stockNumber=" + stockNumber +
                '}';
    }
}
