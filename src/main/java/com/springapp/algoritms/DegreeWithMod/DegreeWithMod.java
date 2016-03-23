package com.springapp.algoritms.DegreeWithMod;

import com.springapp.Tools.Tools;

import java.util.ArrayList;

/**
 * Created by Roman on 08.03.2016.
 */

public class DegreeWithMod {
    public Result count(long number, long degree, long mod) {
        Result result = new Result();
        Tools tools = new Tools();
        ArrayList<Boolean> bin = tools.decimal_in_binary(degree);
        Long bin_count_int[] = new Long[bin.size()];
        bin_count_int[0] = number;
        String bin_string = "";
        for (Boolean aBin : bin) {
            if (aBin) {
                bin_string += "1";
            } else {
                bin_string += "0";
            }
        }
        if (bin.size()==1){
            result.setCount((long) Math.pow(number, degree)%mod);
        }
        else{
            for (int i = 1; i < bin.size(); i++) {
                if (bin.get(i)) {
                    bin_count_int[i] = (bin_count_int[i - 1]*bin_count_int[i - 1]) * number % mod;
                } else {
                    bin_count_int[i] = (bin_count_int[i - 1]*bin_count_int[i - 1]) % mod;
                }
            }
            result.setCount(bin_count_int[bin.size() - 1]);
        }
        return result;
    }
}
