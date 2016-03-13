package com.springapp.TimeTests;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman on 09.03.2016.
 */
public class Test {
    public Map<Integer, Long> test_for_degree_with_mod(Long number, Long degree, Long mod){
        final int numberOfMeasurements = 50;
        int t0 = 100000;
        int t1 = 400000;
        int t2 = 700000;
        int t3 = 1000000;
        int t;
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        int i = 0;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<Integer, Long> result = new HashMap<Integer, Long>();
        timestart = System.currentTimeMillis();
        while (i<numberOfMeasurements) {
            t = t0;
            while (t > 0) {
                degreeWithMod.count(number, degree, mod);
                t--;
            }

            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(t0, (timefinish-timestart)/numberOfMeasurements);

        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            t = t1;
            while (t > 0) {
                degreeWithMod.count(number, degree, mod);
                t--;
            }

            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(t1, (timefinish-timestart)/numberOfMeasurements);

        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            t = t2;
            while (t > 0) {
                degreeWithMod.count(number, degree, mod);
                t--;
            }

            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(t2, (timefinish-timestart)/numberOfMeasurements);

        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            t = t3;
            while (t > 0) {
                degreeWithMod.count(number, degree, mod);
                t--;
            }

            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(t3, (timefinish-timestart)/numberOfMeasurements);

        return result;
    }
}
