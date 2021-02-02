package com.matematicaDiscreta.estruturasBasicas;

import java.util.List;

public class Contagem {

    public static Integer potencia(Integer base, Integer expoente){

        Integer result = 1;

        for(Integer i = 0; i<expoente; i++) result = result * base;

        return result;

    }

    public static Integer fatorial(Integer number){
        Integer result = 1;

        for(Integer i = number; i>0;i--) result = result*i;

        return result;
    }

    public static Integer permutacao(Integer number, Integer limiter){
        Integer result = 1;

        for(Integer i = number; i>(number-limiter);i--)
            result = result*i;

        return result;
    }

    public static Double permutacao(Double number, Integer limiter){
        Double result = 1.0;

        for(Double i = number; i>(number-limiter);i--)
            result = result*i;

        return result;
    }

    public static Integer combinatoria(Integer number, Integer limit){

        Integer limitReal = Math.min(limit,number-limit);

        return permutacao(number,limitReal) / fatorial(limitReal);

    }

    public static Double combinatoria(Double number, Integer limit){
        return permutacao(number,limit) / fatorial(limit);
    }

    public static Integer Anagrama(List<Integer> limiters){

        int limiterResult = 1;
        int number = 0;

        for(Integer i: limiters){
            limiterResult = limiterResult * fatorial(i);
            number += i;
        }

        return fatorial(number) / limiterResult;
    }

}
