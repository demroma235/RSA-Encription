package com.springapp.Tools;

import java.util.ArrayList;

/**
 * Created by Roman on 09.03.2016.
 */
public class Tools {
    public ArrayList<Boolean> decimal_in_binary(Long number){

        ArrayList<Boolean> bin = new ArrayList<Boolean>();
        if (number == 0){
            bin.add(false);
            return bin;
        }
        Long number_interval = number;
        while (number_interval > 0) {
            if (number_interval % 2 == 0) {
                bin.add(false);
            } else {
                bin.add(true);
            }
            number_interval /= 2;
        }
        boolean flag;
        for (int i = 0; i < bin.size()/2; i++){
            flag = bin.get(i);
            bin.set(i, bin.get(bin.size()-i-1));
            bin.set(bin.size()-i-1, flag);
        }
        return bin;
    }
}
