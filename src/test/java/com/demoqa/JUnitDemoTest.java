package com.demoqa;

import org.junit.jupiter.api.*;

public class JUnitDemoTest {

    // перед всеми тестами
    @BeforeAll
    static void setUp() {
        System.out.println("### @Before all!");
    }

    //после всех тестов
    @AfterAll
    static void tearDown() {
        System.out.println("### @AfterAll!");
    }

    //предусловие перед каждым тестом
    @BeforeEach
    void beforeEachTest() {
        System.out.println("###     @BeforeEach");
    }

    //предусловие после каждого теста
    @AfterEach
    void afterEachTest() {
        System.out.println("###     @AfterEach");
    }

    @Test
    void simpleTestFirst() {
        System.out.println("###         @simpleTestFirst");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTestSecond() {
        System.out.println("###         @simpleTestSecond");
        Assertions.assertTrue(3 > 2);
    }

}
