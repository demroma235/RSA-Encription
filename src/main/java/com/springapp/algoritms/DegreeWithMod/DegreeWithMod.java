package com.springapp.algoritms.DegreeWithMod;

import com.springapp.Tools.Tools;

import java.util.ArrayList;

/**
 * Created by Roman on 08.03.2016.
 */

public class DegreeWithMod {
    public Result count(int number, int degree, int mod) {
        //Записываем результаты в объект result
        Result result = new Result();
        //Объект для записи числа степени -> Для двоичного вида
        ArrayList<Boolean> bin = null;
        Tools tools = new Tools();
        bin = tools.decimal_in_binary(degree);
        //Создание массивов и его запись для вычисления выражения
        int bin_count_int[] = new int[bin.size()];
        //Запись первого числа в массив
        bin_count_int[0] = number;
        //Сам алгоритм
        for (int i = 1; i < bin.size(); i++) {
            if (bin.get(i)) {
                bin_count_int[i] = (int) Math.pow(bin_count_int[i - 1], 2) * number % mod;
            } else {
                bin_count_int[i] = (int) Math.pow(bin_count_int[i - 1], 2) % mod;
            }
        }
        result.setCount(bin_count_int[bin.size() - 1]);
        return result;
    }
}
