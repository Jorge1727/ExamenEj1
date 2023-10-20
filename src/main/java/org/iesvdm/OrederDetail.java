package org.iesvdm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrederDetail
{
    //Atr
    public enum TaxType{GENERAL, REDUCED, SUPERREDUCED}
    public int quantity;
    public TaxType tipoTax;
    public Item item;

    //Cons
    public OrederDetail(int quantity, TaxType tipoTax, Item item) {
        this.quantity = quantity;
        this.tipoTax = tipoTax;
        this.item = item;
    }

    //Met
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TaxType getTipoTax()
    {
        return tipoTax;
    }

    public void setTipoTax(TaxType tipoTax) {
        this.tipoTax = tipoTax;
    }

    public BigDecimal getIva()
    {
        BigDecimal iva = BigDecimal.ZERO;
        switch (tipoTax)
        {
            case GENERAL:
                iva = new BigDecimal("21");
                break;
            case REDUCED:
                iva = new BigDecimal("10");
                break;
            case SUPERREDUCED:
                iva = new BigDecimal("4");
                break;
        }

        return iva;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    /**
     * Calcula el precio total de los productos sin aplicar ningun impuesto todavia
     * @return
     */
    public BigDecimal calcSubTotal()
    {
        BigDecimal total = BigDecimal.ZERO;

        total = item.getPrice().multiply(BigDecimal.valueOf(quantity));

        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Calculo del peso total
     * @return
     */
    public BigDecimal calcWeight()
    {
        BigDecimal total = BigDecimal.ZERO;

        total = item.getWeight().multiply(BigDecimal.valueOf(quantity));

        return total.setScale(3, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        return "OrederDetail{" +
                "quantity=" + quantity +
                ", tipoTax=" + tipoTax +
                ", item=" + item +
                '}';
    }
}
