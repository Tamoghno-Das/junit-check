package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {
    private static ArrayList<String> list;
    @BeforeAll
    public static void setup()
    {
        list = new ArrayList<>(2);
    }
    @Test
    @Order(3)
    public void a()
    {
        IO.println("I am A");
        list.add("Trisha");
    }
    @Test
    @Order(1)
    public void b()
    {

        IO.println("I am B");
        assertNotNull(list);
    }
    @Test
    @Order(4)
    public void c()
    {
        IO.println("I am C");
        assertEquals(2,list.size());
        list.forEach(IO::println);

    }
    @Test
    @Order(2)
    public void d()
    {
        IO.println("I am D");
        list.add("Rupsa");
    }
    @AfterAll
    public static void reset()
    {
        list=null;
        assertNull(list);
    }
}
