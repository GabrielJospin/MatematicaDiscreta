package com.matematicaDiscreta.estruturasBasicas;

import java.util.ArrayList;
import java.util.List;

public class Primos {

    static List<Integer> primos = new ArrayList();

    public List<Integer> listaDePrimos(Integer limit){

        List<Integer> answer = new ArrayList();

        for(Integer i = 2; i<= limit; i++){
            if(ePrimo(i)) {
                answer.add(i);
                if(!primos.contains(i)) primos.add(i);
            }
        }

        return answer;
    }

    boolean ePrimo(Integer numero){

        int sqrt = (int) ((Math.sqrt(numero)));
        int limit = Math.min(sqrt, primos.size());

        for (int i = 0; i< limit; i++){
           if(numero % primos.get(i) == 0) return false;
        }

        return true;
    }

    public Integer greatCommomDivisor(Integer numberOne, Integer numberTwo){

        if(numberTwo.equals(0)) return numberOne;
        if(numberOne.equals(0)) return numberTwo;
        if(numberOne.equals(1)) return numberOne;
        if(numberTwo.equals(1)) return numberTwo;

        Integer biggestNumber = (numberTwo > numberOne) ? numberTwo : numberOne;
        Integer smallerNumber = (numberTwo < numberOne) ? numberTwo : numberOne;

        return greatCommomDivisor(smallerNumber, biggestNumber%smallerNumber);

    }

    public Integer lessCommonMultiply(Integer numberOne, Integer numberTwo){

        Integer greatCommonDivisor = greatCommomDivisor(numberOne,numberTwo);
        return (numberOne*numberTwo)/greatCommonDivisor;

    }

}
