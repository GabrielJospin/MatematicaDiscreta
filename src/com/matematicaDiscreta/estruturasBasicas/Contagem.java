package com.matematicaDiscreta.estruturasBasicas;

import java.util.List;

public class Contagem {

    static Integer potencia(Integer base, Integer expoente){

        Integer result = 1;

        for(Integer i = 0; i<expoente; i++) result = result * base;

        return result;

    }

    static Integer fatorial(Integer number){
        Integer result = 1;

        for(Integer i = number; i>0;i--) result = result*i;

        return result;
    }

    static Integer permutacao(Integer number, Integer limiter){
        Integer result = 1;

        for(Integer i = number; i>(limiter-number);i--) result = result*i;

        return result;
    }

    static Double permutacao(Double number, Integer limiter){
        Double result = 1.0;

        for(Double i = number; i>(limiter-number);i--) result = result*i;

        return result;
    }

    static Integer combinatoria(Integer number, Integer limit){

        Integer limitReal = Math.min(limit,number-limit);

        return permutacao(number,limitReal) / fatorial(limitReal);

    }

    static Integer Anagrama(Integer number, List<Integer> limiters){

        int limiterResult = 1;

        for(Integer i: limiters) limiterResult = limiterResult * fatorial(i);

        return fatorial(number) / limiterResult;
    }

}
