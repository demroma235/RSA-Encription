package com.springapp.TimeTests;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;
import com.springapp.algoritms.Prime.Prime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Roman on 09.03.2016.
 */
public class Test {
    public Map<String, Long> test_for_degree_with_mod(){
        final long numberOfMeasurements = 50000;
        final long LOWER_RANGE = 2;
        final long UPPER_RANGE = 999999;
        Random random = new Random();

        long number0 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long degree0 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long mod0 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long number1 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long degree1 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long mod1 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long number2 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long degree2 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long mod2 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long number3 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long degree3 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long mod3 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        int i = 0;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<String, Long> result = new HashMap<String, Long>();
        timestart = System.currentTimeMillis();
        while (i<numberOfMeasurements) {
            degreeWithMod.count(number0, degree0, mod0);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number0 + ", " + degree0 + ", " + mod0, (timefinish-timestart));
        System.out.println("Test 0 - Done!");
        System.out.println(number0 + " : " + (timefinish - timestart));
        System.out.println("=======");
        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            degreeWithMod.count(number1, degree1, mod1);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number1 + ", " + degree1 + ", " + mod1, (timefinish-timestart));
        System.out.println("Test 1 - Done!");
        System.out.println(number1 + " : " + (timefinish - timestart));
        System.out.println("=======");
        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            degreeWithMod.count(number2, degree2, mod2);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number2 + ", " + degree2 + ", " + mod2, (timefinish-timestart));
        System.out.println("Test 2 - Done!");
        System.out.println(number2 + " : " + (timefinish - timestart));
        System.out.println("=======");
        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            degreeWithMod.count(number3, degree3, mod3);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number3 + ", " + degree3 + ", " + mod3, (timefinish-timestart));
        System.out.println("Test 3 - Done!");
        System.out.println(number3 + " : " + (timefinish - timestart));
        System.out.println("=======");
        return result;
    }

    public Map<Long, Long> test_for_prime() {
        final long numberOfMeasurements = 50000;
        final long LOWER_RANGE = 2;
        final long UPPER_RANGE = 999999999;
        Random random = new Random();

        long number0 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long number1 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long number2 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long number3 = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        Prime prime = new Prime();
        int i = 0;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<Long, Long> result = new HashMap<Long, Long>();
        timestart = System.currentTimeMillis();
        while (i<numberOfMeasurements) {
            prime.isPrime(number0);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number0, (timefinish-timestart));
        System.out.println("Test 0 - Done!");
        System.out.println(number0 + " : " + (timefinish - timestart));
        System.out.println("=======");
        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            prime.isPrime(number1);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number1, (timefinish-timestart));
        System.out.println("Test 1 - Done!");
        System.out.println(number1 + " : " + (timefinish - timestart));
        System.out.println("=======");
        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            prime.isPrime(number2);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number2, (timefinish-timestart));
        System.out.println("Test 2 - Done!");
        System.out.println(number2 + " : " + (timefinish - timestart));
        System.out.println("=======");
        timestart = System.currentTimeMillis();
        i = 0;
        while (i<numberOfMeasurements) {
            prime.isPrime(number3);
            i++;
        }
        timefinish = System.currentTimeMillis();
        result.put(number3, (timefinish-timestart));
        System.out.println("Test 3 - Done!");
        System.out.println(number3 + " : " + (timefinish - timestart));
        System.out.println("=======");
        return result;
    }
}
