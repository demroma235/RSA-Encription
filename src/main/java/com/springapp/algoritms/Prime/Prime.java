package com.springapp.algoritms.Prime;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;

/**
 * Created by Roman on 13.03.2016.
 */
public class Prime {
    public boolean isPrime(long number){
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        long a = 2;
        if (number==2) {
            return true;
        }
        else{
            return degreeWithMod.count(a, number-1, number) == 1;
        }
    }
}
