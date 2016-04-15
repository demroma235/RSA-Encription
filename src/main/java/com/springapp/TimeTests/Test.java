package com.springapp.TimeTests;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;
import com.springapp.algoritms.Prime.Prime;

import java.util.*;

/**
 * Created by Roman on 09.03.2016.
 */
public class Test {
    public Map<Long, Long> test_for_degree_with_mod_number(){
        final long numberOfMeasurements = 50000;
        final long LOWER_RANGE = 2;
        final long UPPER_RANGE = 999999;
        Random random = new Random();

        long degree = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long mod = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));

        DegreeWithMod degreeWithMod = new DegreeWithMod();
        int i = 0;
        int numberTest = 100;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<Long, Long> result = new HashMap<Long, Long>();
        while (numberTest > 0) {
            long number = LOWER_RANGE +
                    (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
            i = 0;

            timestart = System.currentTimeMillis();
            while (i<numberOfMeasurements) {
                degreeWithMod.count(number, degree, mod);
                i++;
            }
            timefinish = System.currentTimeMillis();
            result.put(number, (timefinish-timestart));
            numberTest--;
        }
        Map<Long, Long> new_result = new TreeMap<Long, Long>(result);
        return new_result;
    }

    public Map<Long, Long> test_for_degree_with_mod_degree(){
        final long numberOfMeasurements = 50000;
        final long LOWER_RANGE = 2;
        final long UPPER_RANGE = 999999;
        Random random = new Random();

        long number = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long mod = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));

        DegreeWithMod degreeWithMod = new DegreeWithMod();
        int i = 0;
        int numberTest = 100;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<Long, Long> result = new HashMap<Long, Long>();
        while (numberTest > 0) {
            long degree = LOWER_RANGE +
                    (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
            i = 0;

            timestart = System.currentTimeMillis();
            while (i<numberOfMeasurements) {
                degreeWithMod.count(number, degree, mod);
                i++;
            }
            timefinish = System.currentTimeMillis();
            result.put(degree, (timefinish-timestart));
            numberTest--;
        }
        Map<Long, Long> new_result = new TreeMap<Long, Long>(result);
        return new_result;
    }

    public Map<Long, Long> test_for_degree_with_mod_mod(){
        final long numberOfMeasurements = 50000;
        final long LOWER_RANGE = 2;
        final long UPPER_RANGE = 999999;
        Random random = new Random();

        long number = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
        long degree = LOWER_RANGE +
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));

        DegreeWithMod degreeWithMod = new DegreeWithMod();
        int i = 0;
        int numberTest = 100;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<Long, Long> result = new HashMap<Long, Long>();
        while (numberTest > 0) {
            long mod = LOWER_RANGE +
                    (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));

            i = 0;

            timestart = System.currentTimeMillis();
            while (i<numberOfMeasurements) {
                degreeWithMod.count(number, degree, mod);
                i++;
            }
            timefinish = System.currentTimeMillis();
            result.put(mod, (timefinish-timestart));
            numberTest--;
        }
        Map<Long, Long> new_result = new TreeMap<Long, Long>(result);
        return new_result;
    }

    public Map<Long, Long> test_for_prime() {
        final long numberOfMeasurements = 50000;
        final long LOWER_RANGE = 2;
        final long UPPER_RANGE = 99999999;
        Random random = new Random();

        Prime prime = new Prime();
        int i = 0;
        int numberTest = 100;
        Long timestart = 0L;
        Long timefinish = 0L;
        Map<Long, Long> result = new HashMap<Long, Long>();
        while (numberTest > 0) {
            long number = LOWER_RANGE +
                    (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
            i = 0;

            timestart = System.currentTimeMillis();
            while (i<numberOfMeasurements) {
                prime.isPrime(number);
                i++;
            }
            timefinish = System.currentTimeMillis();
            result.put(number, (timefinish-timestart));
            numberTest--;
        }
        Map<Long, Long> new_result = new TreeMap<Long, Long>(result);

        return new_result;
    }

}
