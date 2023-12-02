package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {
    @BeforeAll
    static void beforeall(){
        System.out.println("yes");
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

   void test(){
       assertTrue(BMICalculator.isDietRecommended(89.98,1.72));
   }

    @ParameterizedTest
    @ValueSource(doubles = {10.00,20.00,40.00,89.98})
    void shouldreturnwhentrue(Double coderweight){
        //given or arrange
       double weight=coderweight;
       double height=1.72;
       //when or act
       boolean result=BMICalculator.isDietRecommended(weight,height);
       //then or assert
       assertTrue(result);

   }
    @ParameterizedTest
    @CsvSource(value = {"89.00,1.72","50.00,1.72"})
    void shouldreturnwhentruetrue(Double coderweight,Double coderheight){
        //given or arrange
        double weight=coderweight;
        double height=coderheight;
        //when or act
        boolean result=BMICalculator.isDietRecommended(weight,height);
        //then or assert
        assertTrue(result);

    }
    @Test
    void shouldreturnwhenfalse(){
        //given or arrange
        double weight=50.00;
        double height=1.72;
        //when or act
        boolean result=BMICalculator.isDietRecommended(weight,height);
        //then or assert
        assertFalse(result);

    }
    @Test
    void shouldreturnexception(){
        //given or arrange
       double weight=89.00;
        double height=0.00;
        //when or act
        Executable executable =()-> BMICalculator.isDietRecommended(weight,height);
        //
        //then or assert
//        assertThrows(ArithmeticException.class,()->{
//            BMICalculator.isDietRecommended(weight,height);
//        });
        assertThrows(ArithmeticException.class,executable);

    }

    @Test
    void shouldreturncoderswithworstbmiinms(){
        //given
        List<Coder>coders=new ArrayList<>();
        for (int i=0;i<10000;i++){
            coders.add(new Coder(1.0+i,10.0+i));

        }
        //when
        Executable executable=()->BMICalculator.getBMIScores(coders);
        //then
        assertTimeout(Duration.ofMillis(1),executable);
    }

    @Test
    void shouldreturnworstbmi(){
        //given
        List<Coder>coders=new ArrayList<>();
        coders.add(new Coder(1.90,90));
        coders.add(new Coder(1.91,92));
        coders.add(new Coder(1.92,93));

        //when
          Coder coder=BMICalculator.findCoderWithWorstBMI(coders);

          //then
        assertEquals(1.92,coder.getHeight());

//        assertAll(
//                ()-> assertEquals(1.92,coder.getHeight()),
//        ()->assertEquals(1.92,coder.getHeight())
//        );

    }
    @Test
    void testshouldreturnnull(){
        //given
        List<Coder>coders=new ArrayList<>();


        //when
        Coder coder=BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertNull(coder);
    }
    @Test
    void testshouldreturnarray(){
        //given
        List<Coder>coders=new ArrayList<>();
        coders.add(new Coder(1.90,90));
        coders.add(new Coder(1.91,92));
        coders.add(new Coder(1.92,93));
        double[] expected={18.52,29.59,19.53};
        //when
        double[] arr=BMICalculator.getBMIScores(coders);
        //then
        //assertEquals(3,arr.length);
        assertArrayEquals(expected,arr);
    }
}