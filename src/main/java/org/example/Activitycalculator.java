package org.example;

public class Activitycalculator {
    private static final int workoutsession=45;
    public static String rateactivitylevel(int weeklycardiomin,int weeklycardiooutsession){
        if (weeklycardiomin<0||weeklycardiooutsession<0){
            throw new RuntimeException("input below zero");
        }
        int totalminutes=weeklycardiomin+weeklycardiooutsession*workoutsession;
        double avgdailyactvitymins=totalminutes/7.0;
        if (avgdailyactvitymins<20){
            return "bad";
        }else if (avgdailyactvitymins<40){
            return "average";
        }

        return "good";
    }
}
