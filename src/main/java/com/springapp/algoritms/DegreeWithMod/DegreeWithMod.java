package com.springapp.algoritms.DegreeWithMod;

import com.springapp.Tools.Tools;

import java.util.ArrayList;

/**
 * Created by Roman on 08.03.2016.
 */

public class DegreeWithMod {
    public Result count(long number, long degree, long mod) {
        //���������� ���������� � ������ result
        Result result = new Result();
        //������ ��� ������ ����� ������� -> ��� ��������� ����
        ArrayList<Boolean> bin = null;
        Tools tools = new Tools();
        bin = tools.decimal_in_binary(degree);
        //�������� �������� � ��� ������ ��� ���������� ���������
        long bin_count_int[] = new long[bin.size()];
        //������ ������� ����� � ������
        bin_count_int[0] = number;
        //��� ��������
        String bin_string = "";
        for (int i=0; i<bin.size(); i++){
            if (bin.get(i)) {
                bin_string += "1";
            }
            else{
                bin_string += "0";
            }
        }
        System.out.println(bin.size());
        System.out.println(bin_string);
        if (bin.size()==1){
            result.setCount(number%mod);
            System.out.println(result.getCount());
        }
        else{
            for (int i = 1; i < bin.size(); i++) {
                if (bin.get(i)) {
                    bin_count_int[i] = (bin_count_int[i - 1]*bin_count_int[i - 1]) * number % mod;
                } else {
                    bin_count_int[i] = (bin_count_int[i - 1]*bin_count_int[i - 1]) % mod;
                    System.out.println(bin_count_int[i - 1]*bin_count_int[i - 1]);
                    System.out.println(bin_count_int[i - 1]*bin_count_int[i - 1] % mod);
                }
                System.out.println(i + " = " + bin_count_int[i] + " ");
            }
            result.setCount(bin_count_int[bin.size() - 1]);
        }
        return result;
    }
}
