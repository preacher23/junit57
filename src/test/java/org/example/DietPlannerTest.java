package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {
private DietPlanner dietPlanner;
    @BeforeEach
    void setUp() {
        this.dietPlanner=new DietPlanner(20,30,50);
    }
    @Test
    void shouldreturncorrectdietplanwhencorrectcoder(){
       //given
        Coder coder=new Coder(1.82,75.0,26,Gender.MALE);
        DietPlan expected=new DietPlan(2202,100,73,275);
        //when
        DietPlan actual=dietPlanner.calculateDiet(coder);
        //then
        assertAll(
                ()->assertEquals(expected.getCarbohydrate(),actual.getCarbohydrate()));

    }
}