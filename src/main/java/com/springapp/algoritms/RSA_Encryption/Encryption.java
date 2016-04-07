package com.springapp.algoritms.RSA_Encryption;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman on 23.03.2016.
 */
public class Encryption {

    private Map<Long, String> alphabet = new HashMap<Long, String>();
    public Encryption() {
        alphabet.put(2L, "а");
        alphabet.put(3L, "б");
        alphabet.put(4L, "в");
        alphabet.put(5L, "г");
        alphabet.put(6L, "д");
        alphabet.put(7L, "е");
        alphabet.put(8L, "ё");
        alphabet.put(9L, "ж");
        alphabet.put(10L, "з");
        alphabet.put(11L, "и");
        alphabet.put(12L, "й");
        alphabet.put(13L, "к");
        alphabet.put(14L, "л");
        alphabet.put(15L, "м");
        alphabet.put(16L, "н");
        alphabet.put(17L, "о");
        alphabet.put(18L, "п");
        alphabet.put(19L, "р");
        alphabet.put(20L, "с");
        alphabet.put(21L, "т");
        alphabet.put(22L,"у");
        alphabet.put(23L, "ф");
        alphabet.put(24L, "х");
        alphabet.put(25L, "ц");
        alphabet.put(26L, "ч");
        alphabet.put(27L, "ш");
        alphabet.put(28L, "щ");
        alphabet.put(29L, "ъ");
        alphabet.put(30L, "ь");
        alphabet.put(31L, "ы");
        alphabet.put(32L, "э");
        alphabet.put(33L, "ю");
        alphabet.put(34L, "я");
        alphabet.put(35L, "А");
        alphabet.put(36L, "Б");
        alphabet.put(37L, "В");
        alphabet.put(38L, "Г");
        alphabet.put(39L, "Д");
        alphabet.put(40L, "Е");
        alphabet.put(41L, "Ё");
        alphabet.put(42L, "Ж");
        alphabet.put(43L, "З");
        alphabet.put(44L, "И");
        alphabet.put(45L, "Й");
        alphabet.put(46L, "К");
        alphabet.put(47L, "Л");
        alphabet.put(48L, "М");
        alphabet.put(49L, "Н");
        alphabet.put(50L, "О");
        alphabet.put(51L, "П");
        alphabet.put(52L, "Р");
        alphabet.put(53L, "С");
        alphabet.put(54L, "Т");
        alphabet.put(55L, "У");
        alphabet.put(56L, "Ф");
        alphabet.put(57L, "Х");
        alphabet.put(58L, "Ц");
        alphabet.put(59L, "Ч");
        alphabet.put(60L, "Ш");
        alphabet.put(61L, "Щ");
        alphabet.put(62L, "Ъ");
        alphabet.put(63L, "Ь");
        alphabet.put(64L, "Ы");
        alphabet.put(65L, "Э");
        alphabet.put(66L, "Ю");
        alphabet.put(67L, "Я");
        alphabet.put(68L, ",");
        alphabet.put(69L, ".");
        alphabet.put(70L, "!");
        alphabet.put(71L, "?");
        alphabet.put(72L, ":");
        alphabet.put(73L, "-");
        alphabet.put(74L, ";");
        alphabet.put(75L, "_");
        alphabet.put(76L, " ");
    }

    public String toEncrypt(String text, Long degree, Long mod){
        String[] text_array = text.split("");
        ArrayList<String> text_list = new ArrayList<String>();
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Long key;
        Long value;
        String new_string = "";
        for (int i=0; i<text_array.length; i++){
            key = getKeyInValue(text_array[i]);
            value = degreeWithMod.count(key, degree, mod);
            while (value>alphabet.size()+1){
                value = degreeWithMod.count(value, degree, mod);
                System.out.println("Value = " + value);
            }
            new_string += alphabet.get(value);
        }
        return new_string;
    }
    private Long getKeyInValue(String simbol){
        System.out.println("Алфавит = " + alphabet.size());
        for (Long i = 2L; i < alphabet.size()+2; i++){
            if (simbol.equals(alphabet.get(i))){
                System.out.println("Число - " + i);
                return i;
            }
        }
        return 2L;
    }
}
