package org.example.FileHandlingWithMultiThreading;

import java.util.Comparator;

public class Curr_Altitude_Fit implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        int a=o1.getCurr_altitude_fit();
        int b=o2.getCurr_altitude_fit();
        if(a<b)
            return -1;
        else if(a>b)
            return 1;
        return 0;
    }
}
