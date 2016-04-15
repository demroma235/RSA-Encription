package com.springapp.algoritms.RSA_Encryption;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman on 23.03.2016.
 */
public class Encryption {

    private Map<Long, Character> alphabet = new HashMap<Long, Character>();
    public Encryption() {
        String alphabet_string =
                "абвгдеёжзийклмнопрстуфхцчшщъьыэюя"
                + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЬЫЭЮЯ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "!@$%^&*()_+"
                + "\"№;:?-=\\|/., {}[]'";
        char[] alphabet_char_array = alphabet_string.toCharArray();
        Long i = 2L;
        for (char alp: alphabet_char_array){
            alphabet.put(i, alp);
            i++;
        }
//        alphabet.put(2L, 'а');
//        alphabet.put(3L, 'б');
//        alphabet.put(4L, 'в');
//        alphabet.put(5L, 'г');
//        alphabet.put(6L, 'д');
//        alphabet.put(7L, 'е');
//        alphabet.put(8L, 'ё');
//        alphabet.put(9L, 'ж');
//        alphabet.put(10L, 'з');
//        alphabet.put(11L, 'и');
//        alphabet.put(12L, 'й');
//        alphabet.put(13L, 'к');
//        alphabet.put(14L, 'л');
//        alphabet.put(15L, 'м');
//        alphabet.put(16L, 'н');
//        alphabet.put(17L, 'о');
//        alphabet.put(18L, 'п');
//        alphabet.put(19L, 'р');
//        alphabet.put(20L, 'с');
//        alphabet.put(21L, 'т');
//        alphabet.put(22L,'у');
//        alphabet.put(23L, 'ф');
//        alphabet.put(24L, 'х');
//        alphabet.put(25L, 'ц');
//        alphabet.put(26L, 'ч');
//        alphabet.put(27L, 'ш');
//        alphabet.put(28L, 'щ');
//        alphabet.put(29L, 'ъ');
//        alphabet.put(30L, 'ь');
//        alphabet.put(31L, 'ы');
//        alphabet.put(32L, 'э');
//        alphabet.put(33L, 'ю');
//        alphabet.put(34L, 'я');
//        alphabet.put(35L, 'А');
//        alphabet.put(36L, 'Б');
//        alphabet.put(37L, 'В');
//        alphabet.put(38L, 'Г');
//        alphabet.put(39L, 'Д');
//        alphabet.put(40L, 'Е');
//        alphabet.put(41L, 'Ё');
//        alphabet.put(42L, 'Ж');
//        alphabet.put(43L, 'З');
//        alphabet.put(44L, 'И');
//        alphabet.put(45L, 'Й');
//        alphabet.put(46L, 'К');
//        alphabet.put(47L, 'Л');
//        alphabet.put(48L, 'М');
//        alphabet.put(49L, 'Н');
//        alphabet.put(50L, 'О');
//        alphabet.put(51L, 'П');
//        alphabet.put(52L, 'Р');
//        alphabet.put(53L, 'С');
//        alphabet.put(54L, 'Т');
//        alphabet.put(55L, 'У');
//        alphabet.put(56L, 'Ф');
//        alphabet.put(57L, 'Х');
//        alphabet.put(58L, 'Ц');
//        alphabet.put(59L, 'Ч');
//        alphabet.put(60L, 'Ш');
//        alphabet.put(61L, 'Щ');
//        alphabet.put(62L, 'Ъ');
//        alphabet.put(63L, 'Ь');
//        alphabet.put(64L, 'Ы');
//        alphabet.put(65L, 'Э');
//        alphabet.put(66L, 'Ю');
//        alphabet.put(67L, 'Я');
//        alphabet.put(68L, ',');
//        alphabet.put(69L, '.');
//        alphabet.put(70L, '!');
//        alphabet.put(71L, '?');
//        alphabet.put(72L, ':');
//        alphabet.put(73L, '-');
//        alphabet.put(74L, ';');
//        alphabet.put(75L, '_');
//        alphabet.put(76L, 'a');
//        alphabet.put(77L, 'b');
//        alphabet.put(78L, 'c');
//        alphabet.put(79L, 'd');
//        alphabet.put(80L, 'e');
//        alphabet.put(81L, 'f');
//        alphabet.put(82L, 'g');
//        alphabet.put(83L, 'h');
//        alphabet.put(84L, 'i');
//        alphabet.put(85L, 'j');
//        alphabet.put(86L, 'k');
//        alphabet.put(87L, 'l');
//        alphabet.put(88L, 'm');
//        alphabet.put(89L, 'n');
//        alphabet.put(90L, 'o');
//        alphabet.put(91L, 'p');
//        alphabet.put(92L, 'q');
//        alphabet.put(93L, 'r');
//        alphabet.put(94L, 's');
//        alphabet.put(95L, 't');
//        alphabet.put(96L, 'u');
//        alphabet.put(97L, 'v');
//        alphabet.put(98L, 'w');
//        alphabet.put(99L, 'x');
//        alphabet.put(100L, 'y');
//        alphabet.put(101L, 'z');
//        alphabet.put(102L, 'A');
//        alphabet.put(103L, 'B');
//        alphabet.put(104L, 'C');
//        alphabet.put(105L, 'D');
//        alphabet.put(106L, 'E');
//        alphabet.put(107L, 'F');
//        alphabet.put(108L, 'G');
//        alphabet.put(109L, 'H');
//        alphabet.put(110L, 'I');
//        alphabet.put(111L, 'J');
//        alphabet.put(112L, 'K');
//        alphabet.put(113L, 'L');
//        alphabet.put(114L, 'M');
//        alphabet.put(115L, 'N');
//        alphabet.put(116L, 'O');
//        alphabet.put(117L, 'P');
//        alphabet.put(118L, 'Q');
//        alphabet.put(119L, 'R');
//        alphabet.put(120L, 'S');
//        alphabet.put(121L, 'T');
//        alphabet.put(122L, 'U');
//        alphabet.put(123L, 'V');
//        alphabet.put(124L, 'W');
//        alphabet.put(125L, 'X');
//        alphabet.put(126L, 'Y');
//        alphabet.put(127L, 'Z');
//        alphabet.put(128L, '=');
//        alphabet.put(129L, '+');
//        alphabet.put(130L, '@');
//        alphabet.put(131L, '\'');
//        alphabet.put(132L, '№');
//        alphabet.put(133L, '#');
//        alphabet.put(134L, '$');
//        alphabet.put(135L, '%');
//        alphabet.put(136L, '^');
//        alphabet.put(137L, '&');
//        alphabet.put(138L, '(');
//        alphabet.put(139L, ')');
//        alphabet.put(140L, '|');
//        alphabet.put(141L, '\\');
//        alphabet.put(142L, '/');
//        alphabet.put(143L, '*');
//        alphabet.put(144L, ' ');
    }

    public String toEncrypt(String text, Long degree, Long mod){
        char[] text_array = text.toCharArray();
        ArrayList<Character> text_list = new ArrayList<Character>();
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Long key;
        Long value;
        String new_string = "";
        for (int i=0; i<text_array.length; i++){
            key = getKeyInValue(text_array[i]);
            value = degreeWithMod.count(key, degree, mod);
            while (value>alphabet.size()+1){
                value = degreeWithMod.count(value, degree, mod);
                System.out.println("Value1 = " + value);
            }
            new_string += alphabet.get(value);
        }
        return new_string;
    }

    public String toEncryptV2(String text, Long degree, Long mod){
        char [] text_array_char = text.toCharArray();
        long [] text_array_long = new long[text_array_char.length];
        ArrayList<String> text_list = new ArrayList<String>();
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Long key;
        Long value;
        String new_string = "";
        Long terKey;
        for (int i=0; i<text_array_char.length; i++){
            key = getKeyInValue(text_array_char[i]);
            text_array_long[i] = key;
        }
        for (int i = 0; i < text_array_long.length; i++){
            System.out.println("a[" + i + "] = " + text_array_long[i]);
        }
        for (int i = 1; i<text_array_long.length; i++){
            terKey = (text_array_long[i-1] + text_array_long[i] % mod);
            if (terKey > alphabet.size()+1) {
                terKey -= (alphabet.size() + 1);
            }
            text_array_long[i] = terKey;
        }
        for (int i = 0; i < text_array_long.length; i++){
            System.out.println("1[" + i + "] = " + text_array_long[i]);
        }
        for (int i = 0; i < text_array_long.length; i++){
            value = degreeWithMod.count(text_array_long[i], degree, mod);
            while (value>alphabet.size()+1){
                value = degreeWithMod.count(value, degree, mod);
                System.out.println("Value2 = " + value + " Key = " + text_array_long[i]);
            }
            new_string += alphabet.get(value);
        }
        return new_string;
    }

    public String toDeEncryptV2(String text, Long degree, Long mod){
        char [] text_array_char = text.toCharArray();
        long [] text_array_long = new long[text_array_char.length];
        ArrayList<String> text_list = new ArrayList<String>();
        DegreeWithMod degreeWithMod = new DegreeWithMod();
        Long key;
        Long value;
        String new_string = "";
        for (int i=0; i<text_array_char.length; i++){
            key = getKeyInValue(text_array_char[i]);
            text_array_long[i] = key;
        }
        for (int i = 0; i < text_array_long.length; i++){
            System.out.println("b[" + i + "] = " + text_array_long[i]);
        }

        for (int i = 0; i < text_array_long.length; i++){
            value = degreeWithMod.count(text_array_long[i], degree, mod);
            while (value>alphabet.size()+1){
                value = degreeWithMod.count(value, degree, mod);
                System.out.println("Value3 = " + value);
            }
            text_array_long[i] = value;
        }

        for (int i = 0; i < text_array_long.length; i++){
            System.out.println("c[" + i + "] = " + text_array_long[i]);
        }
        for (int i=text_array_long.length-1; i>0; i--){
            if (text_array_long[i] < text_array_long[i-1]){
                text_array_long[i] = (text_array_long[i] - text_array_long[i-1] + alphabet.size() + 1) % mod;
            }
            else {
                text_array_long[i] = (text_array_long[i] - text_array_long[i-1]) % mod;
            }

        }

        for (int i = 0; i < text_array_long.length; i++){
            System.out.println("d[" + i + "] = " + text_array_long[i]);
            new_string += alphabet.get(text_array_long[i]);
        }
        System.out.println("Finish");
        return new_string;
    }
    private Long getKeyInValue(char simbol){
        System.out.println("Алфавит = " + alphabet.size());
        for (Long i = 2L; i < alphabet.size()+2; i++){
            if (simbol == alphabet.get(i)){
                System.out.println("Число - " + i + "Символ - " + simbol);
                return i;
            }
        }
        return 2L;
    }
}
