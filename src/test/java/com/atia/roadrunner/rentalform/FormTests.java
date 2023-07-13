package com.atia.roadrunner.rentalform;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atia.roadrunner.rentalform.Model.Form;

public class FormTests {
    
    private Form form;


    @BeforeEach
    public void setUp(){
        form = new Form();
    };

    @Test
    void testingId(){
        long id= 4L;
        form.setId(id);
        assertEquals(id, form.getId());
    }


    @Test
    void testingName(){
        String name ="Atia Khan";
        form.setName(name);
        assertEquals(name, form.getName());
    }
    @Test 
    void testingNumber(){
        String number = "323565214";
        form.setNumber(number);
        assertEquals(number, form.getNumber());
    }

    @Test
    void testingAddress(){
        String address = "abc street A";
        form.setAddress(address);
        assertEquals(address, form.getAddress());
    }

    @Test
    void testingDriverLicense(){
        String license = "12354EEE";
        form.setDriverLicense(license);
        assertEquals(license, form.getDriverLicense());

    }

    @Test
    void testingtotalPrice(){
        double totalPrice= 1235.00;
        form.setTotalPrice(totalPrice);
        assertEquals(totalPrice, form.getTotalPrice());
    }

     @Test
    void testingOrderPrice(){
        double orderPrice= 2564652.00;
        form.setOrderPrice(orderPrice);
        assertEquals(orderPrice, form.getOrderPrice());
    }

  





}
