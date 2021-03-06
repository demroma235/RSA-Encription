package com.springapp.algoritms.RSA_Encryption;

import com.springapp.algoritms.DegreeWithMod.DegreeWithMod;
import com.springapp.algoritms.Prime.Prime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Roman on 23.03.2016.
 */
@Component
@Scope("session")
public class Data {
    private String name;

    private Long open_key_1;
    private Long open_key_2;
    private Long private_key_1;
    private Long private_key_2;
    private Long module;
    private Long first_prime;
    private Long second_prime;
    private Long function_Euler;
    private Long e;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getE() {
        return e;
    }

    public void setE(Long e) {
        this.e = e;
    }

    public Long getOpen_key_1() {
        return open_key_1;
    }

    public void setOpen_key_1(Long open_key_1) {
        this.open_key_1 = open_key_1;
    }

    public Long getOpen_key_2() {
        return open_key_2;
    }

    public void setOpen_key_2(Long open_key_2) {
        this.open_key_2 = open_key_2;
    }

    public Long getPrivate_key_1() {
        return private_key_1;
    }

    public void setPrivate_key_1(Long private_key_1) {
        this.private_key_1 = private_key_1;
    }

    public Long getPrivate_key_2() {
        return private_key_2;
    }

    public void setPrivate_key_2(Long private_key_2) {
        this.private_key_2 = private_key_2;
    }

    public Long getModule() {
        return module;
    }

    public void setModule(Long module) {
        this.module = module;
    }

    public Long getFirst_prime() {
        return first_prime;
    }

    public void setFirst_prime(Long first_prime) {
        this.first_prime = first_prime;
    }

    public Long getSecond_prime() {
        return second_prime;
    }

    public void setSecond_prime(Long second_prime) {
        this.second_prime = second_prime;
    }

    public Long getFunction_Euler() {
        return function_Euler;
    }

    public void setFunction_Euler(Long function_Euler) {
        this.function_Euler = function_Euler;
    }

    public static Data setData(Long first, Long second){
        Data data = new Data();
        Prime prime = new Prime();
        data.setFirst_prime(first);
        data.setSecond_prime(second);
        data.setModule(data.getFirst_prime()*data.getSecond_prime());
        data.setFunction_Euler((data.getFirst_prime()-1)*(data.getSecond_prime()-1));

        Long e = 0L;
        for (Long i=first+1; i < data.getFunction_Euler(); i++){
            if (prime.isPrime(i)){
                System.out.println("HOH = " + i);
                e = i;
                break;
            }
        }
        System.out.println(e);
        data.setE(e);
        data.setOpen_key_1(data.getE());
        data.setOpen_key_2(data.getModule());
        Long f = 0L;
        System.out.println("START");
        for (Long i=data.getE()+1; i < data.getModule(); i++){
            if (prime.isPrime(i)){
                System.out.println("i = " + i);
                f = (data.getE() * i) % data.getFunction_Euler();
                System.out.println("f = " + f);
                if ((f==1) && (!i.equals(data.getOpen_key_1()))){
                    System.out.println("HOT = " + i);
                    data.setPrivate_key_1(i);
                    break;
                }
            }

        }
        data.setPrivate_key_2(data.getModule());

        return data;
    }
}
