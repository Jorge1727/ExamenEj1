package org.iesvdm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.math.BigDecimal;
import java.util.Date;

public class OrderTest
{
    //Items
    private Item item1 = new Item("Western Digital Unidad interna de estado sólido SSD WD SN580 NVMe azul de 1 TB", BigDecimal.valueOf(0.395), BigDecimal.valueOf(52.99));
    private Item item2 = new Item("Apple MacBook Pro M1 Pro", BigDecimal.valueOf(1.300), BigDecimal.valueOf(1758.95));

    //Detail Order
    OrederDetail detalleOrder1 = new OrederDetail(3, OrederDetail.TaxType.GENERAL, item1);
    OrederDetail detalleOrder2 = new OrederDetail(2, OrederDetail.TaxType.REDUCED, item2);

    //Orden
    Order orden = new Order(new Date("02/05/2023"));


    @Test
    @DisplayName("Metodos del order")
    public void orderTest()
    {
        //Añadimos los detailsOrder a la orden
        orden.addOrderDetail(detalleOrder1);
        orden.addOrderDetail(detalleOrder2);

        //Comprobamos si esta bien
        Assertions.assertEquals(BigDecimal.valueOf(385.17), orden.calcVAT());
        Assertions.assertEquals(BigDecimal.valueOf(3676.87), orden.calcNetTotal());
        Assertions.assertEquals(BigDecimal.valueOf(4447.21), orden.calcGrossTotal());


    }


}
