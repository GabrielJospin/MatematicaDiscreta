package com.matematicaDiscreta.estruturasBasicas;

import java.util.ArrayList;
import java.util.List;

public class Primos {

    List<Integer> primos = new ArrayList();

    public List<Integer> listaDePrimos(Integer limit){

        List<Integer> answer = new ArrayList();

        for(Integer i = 2; i<= limit; i++){
            if(ePrimo(i)) answer.add(i);
        }

        for (Integer i : answer){
            if(!primos.contains(i)) primos.add(i);
        }

        return answer;
    }

    boolean ePrimo(Integer numero){

        int limit = (int) ((Math.sqrt(numero)));

        for (int i = 0; i< limit; i++){
           if(numero % primos.get(i) == 0) return false;
        }

        return true;
    }

    Integer greatComumDivisor(Integer numberOne, Integer numberTwo){

        if(numberTwo.equals(0)) return numberOne;
        if(numberOne.equals(0)) return numberTwo;
        if(numberOne.equals(1)) return numberOne;
        if(numberTwo.equals(1)) return numberTwo;

        Integer biggestNumber = (numberTwo > numberOne) ? numberTwo : numberOne;
        Integer smallerNumber = (numberTwo < numberOne) ? numberTwo : numberOne;

        return greatComumDivisor(smallerNumber, biggestNumber%smallerNumber);

    }

    Integer lessCommonMultiply(Integer numberOne, Integer numberTwo){

        Integer greatCommonDivisor = greatComumDivisor(numberOne,numberTwo);
        return (numberOne*numberTwo)/greatCommonDivisor;

    }

}
