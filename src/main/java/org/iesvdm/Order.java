package org.iesvdm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
{
    //Atributos
    public enum Status {PAYMENT, COMPLETE, PENDING}
    private Date date;
    private Status orderStatus;

    private List<OrederDetail> detallesOrder;


    //Const
    public Order(Date date) {
        this.date = date;
        this.orderStatus = Status.PAYMENT;
        this.detallesOrder = new ArrayList<>();
    }

    //Met

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrederDetail> getDetallesOrder() {
        return detallesOrder;
    }

    public void setDetallesOrder(List<OrederDetail> detallesOrder) {
        this.detallesOrder = detallesOrder;
    }

    public void addOrderDetail(OrederDetail detalleOrder)
    {
        this.detallesOrder.add(detalleOrder);
    }

    public void removeOrderDetail(OrederDetail detalleOrder)
    {
        this.detallesOrder.remove(detalleOrder);
    }

    /**
     * Calcula el valor total neto
     * @return
     */
    public BigDecimal calcNetTotal()
    {
        BigDecimal total = BigDecimal.ZERO;

        for (OrederDetail item : detallesOrder)
        {
            BigDecimal detailOrderTotalPrice = item.calcSubTotal();
            total = total.add(detailOrderTotalPrice);
        }

        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Calcula total con el iva
     * @return
     */
    public BigDecimal calcGrossTotal()
    {
        BigDecimal total = BigDecimal.ZERO;

        for (OrederDetail item : detallesOrder)
        {
            BigDecimal detailOrderTotalPrice = item.calcSubTotal().add(calcVAT());
            total = total.add(detailOrderTotalPrice);
        }

        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Calculo del iva total
     * @return
     */
    public BigDecimal calcVAT()
    {
        BigDecimal total = BigDecimal.ZERO;

        for (OrederDetail item : detallesOrder)
        {
            BigDecimal iva = item.getIva().multiply(new BigDecimal("0.01"));
            BigDecimal detailOrderTotalPrice = item.calcSubTotal().multiply(iva);
            total = total.add(detailOrderTotalPrice);
        }

        return total.setScale(2, RoundingMode.HALF_EVEN);

    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", orderStatus=" + orderStatus +
                ", detallesOrder=" + detallesOrder +
                '}';
    }
}
