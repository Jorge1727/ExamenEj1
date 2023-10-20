package org.iesvdm;

import java.math.BigDecimal;

public class Item
{
    //Atr
    public String description;
    private BigDecimal weight;
    private BigDecimal price;

    //Cons
    public Item(String description, BigDecimal weight, BigDecimal price) {
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

    //Met
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    /*public static void main(String[] args) {
        Item i1 = new Item("fff", BigDecimal.valueOf(21), BigDecimal.valueOf(2.21));
        System.out.println(i1.price);
    }*/
}
