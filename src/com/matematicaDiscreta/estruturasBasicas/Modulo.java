package com.matematicaDiscreta.estruturasBasicas;

import com.sun.istack.internal.NotNull;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;

import java.util.ArrayList;
import java.util.List;

public class Modulo {

    private Integer dividendo;
    private Integer divisor;
    private Integer quociente;
    private Integer resto;


    public Modulo(@NotNull Integer dividendo, @NotNull Integer divisor) throws Exception {

        if(divisor == 0) throw new Exception("divisor can't be 0");

        this.dividendo = dividendo;
        this.divisor = divisor;
        this.quociente = dividendo/divisor;
        this.resto = dividendo%divisor;
    }

    public boolean Divisivel(){
        return this.resto == 0;
    }

    public void PrintAlgoritmo(){
        System.out.printf("%s = %s * %s + %s\n",
                    this.dividendo,
                    this.divisor,
                    this.quociente,
                    this.resto);
    }

    public void PrintMod(){
        System.out.printf("%s = %s (mod %s)\n",
                this.dividendo,
                this.resto,
                this.divisor);
    }

    public boolean equivalente(Modulo comparativo){
        return this.resto == comparativo.resto;
    }

    public Integer inversa() throws Exception {

        for(int i = 1; i<=divisor;i++){
            if((i*dividendo) % divisor == 1) return i;
        }

        String erro = String.format("%s e %s não são primos entre si",
                    dividendo.toString(),
                    divisor.toString());

        throw new Exception(erro);
    }

    @SpecializedFunction
    public static void teoremaChineDoResto(List<Modulo> list) throws Exception {

        Integer moduloFinal = 1;
        List<Integer> modulosParciais = new ArrayList();
        List<Integer> inversas = new ArrayList();

        for(Modulo i: list){
            System.out.printf("x = %s (mod %s) \n", i.resto , i.divisor);
            moduloFinal = moduloFinal * i.divisor;
        }

        for(Modulo i:list){
            modulosParciais.add(moduloFinal/i.divisor);
        }

        for(int i = 0; i<modulosParciais.size();i++){
            System.out.printf("%d) M%d = %d ->",i,i,modulosParciais.get(i));
            System.out.printf("%d * y%d = %d ->",modulosParciais.get(i),i,list.get(i).divisor);
            Modulo mod = new Modulo(modulosParciais.get(i),list.get(i).divisor);
            inversas.add(mod.inversa());
            System.out.printf("y%d = %d\n",i,inversas.get(i));
        }

        Integer parcialResult = 0;

        for(int i = 0; i<modulosParciais.size();i++){
            parcialResult = parcialResult + (modulosParciais.get(i) * inversas.get(i) * list.get(i).resto);
        }

        Integer result = parcialResult % moduloFinal;

        System.out.printf("X = %d (mod %d)",result,moduloFinal);

    }



}
