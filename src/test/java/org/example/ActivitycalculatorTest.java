package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ActivitycalculatorTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void shouldreturnbadwhenaveragebelow20(){
        //given
        int weeklycardiomin=40;
        int weeklycardiooutsession=1;
        //when
          String rateactivitylevel=Activitycalculator.rateactivitylevel(40,1);
        //then
        assertEquals("bad",rateactivitylevel);
    }
    void shouldreturnaveragewhenaveragebetween20and40(){
        int weeklycardiomin=40;
        int weeklycardiooutsession=4;
        //when
        String rateactivitylevel=Activitycalculator.rateactivitylevel(40,1);
        //then
        assertEquals("average",rateactivitylevel);

    }

    void shouldreturngoodwhenaverageabov40(){
        int weeklycardiomin=40;
        int weeklycardiooutsession=5;
        //when
        String rateactivitylevel=Activitycalculator.rateactivitylevel(40,1);
        //then
        assertEquals("good",rateactivitylevel);

    }
    @Test
    void shouldthrowexceptionwheninputbelowzero(){
        //given
        int weeklycardiomin=-40;
        int weeklycardiooutsession=7;
        //when
      Executable executable = ()->Activitycalculator.rateactivitylevel(-40,7);
        //then
        assertThrows(RuntimeException.class,executable);

    }
}