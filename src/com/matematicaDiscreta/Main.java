package com.matematicaDiscreta;

import com.matematicaDiscreta.estruturasBasicas.Conjunto;
import com.matematicaDiscreta.estruturasBasicas.Modulo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void testeConjuntos(){

        List<Object> lista1 = new ArrayList();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);
        lista1.add(4);
        lista1.add(5);

        List<Object> lista2 = new ArrayList();
        lista2.add(8);
        lista2.add(7);
        lista2.add(6);
        lista2.add(5);
        lista2.add(4);

        List<Object> lista3 = new ArrayList();
        lista3.add("Azul");
        lista3.add("Amarelo");
        lista3.add("Vermelho");
        lista3.add("Branco");
        lista3.add("Verde");

        List<Object> lista4 = new ArrayList();
        for(int i = 0; i<=10;i++){
            lista4.add(i);
        }

        Conjunto conjunto1 = new Conjunto(lista1);
        Conjunto conjunto2 = new Conjunto(lista2);
        Conjunto conjunto3 = new Conjunto(lista3);
        Conjunto conjunto4 = new Conjunto(lista4);


        for(int i = 0; i<5; i++ ){
                System.out.printf("%s\t|%s\t|%s\n",
                        conjunto1.lista.get(i).toString(),
                        conjunto2.lista.get(i).toString(),
                        conjunto3.lista.get(i));
        }

        if(conjunto1.estaInclusoEm(conjunto4)) System.out.println("Conjunto 1 esta incluso em 4");
        if(conjunto2.isEquals(conjunto2)) System.out.println("Conjunto 2 é igual a ele mesmo");

        Conjunto conjunto5 = Conjunto.uniao(conjunto1,conjunto2);
        Conjunto conjunto6 = Conjunto.uniao(conjunto2,conjunto3);
        Conjunto conjunto7 = Conjunto.uniao(conjunto3,conjunto1);

        for(int i = 0; i<8; i++ ){
            System.out.printf("%s\t|%s\t|%s\n",
                    conjunto5.lista.get(i).toString(),
                    conjunto6.lista.get(i).toString(),
                    conjunto7.lista.get(i));
        }

        Conjunto conjunto8 = Conjunto.interseccao(conjunto1,conjunto2);
        System.out.println(conjunto8.lista);

        Conjunto conjunto9 = Conjunto.diferenca(conjunto4,conjunto1);
        System.out.println(conjunto9.lista);

    }

    public static void testeModulo() throws Exception {
        Modulo mod1 = new Modulo(5,2);
        Modulo mod2 = new Modulo(107,5);
        Modulo mod3 = new Modulo(456,53);
        Modulo mod4 = new Modulo(112,111);

        mod1.PrintAlgoritmo();
        mod2.PrintAlgoritmo();
        mod3.PrintAlgoritmo();
        mod4.PrintAlgoritmo();

        mod1.PrintMod();
        mod2.PrintMod();
        mod3.PrintMod();
        mod4.PrintMod();

        if(mod4.Divisivel())System.out.printf("4ª expressão é divisivel\n");
        if(mod1.equivalente(mod2))System.out.printf("1ª expressão é equivalnete a segunda\n");

        System.out.printf("%s é inversa de",mod1.inversa().toString());
        mod1.PrintMod();

        System.out.printf("%s é inversa de",mod2.inversa().toString());
        mod2.PrintMod();

        System.out.printf("%s é inversa de",mod3.inversa().toString());
        mod3.PrintMod();

        System.out.printf("%s é inversa de",mod4.inversa().toString());
        mod4.PrintMod();

        List<Modulo> lista = new ArrayList();
        lista.add(mod1);
        lista.add(mod2);
        lista.add(mod3);
        lista.add(mod4);

        Modulo.teoremaChineDoResto(lista);

    }

    public static void testeMasayukiDoModulo() throws Exception{

        System.out.printf("\nTESTES DO MASAYUKI\n Exercicio 1: \n");

        List<Modulo> exercise1 = new ArrayList();
        exercise1.add(new Modulo(1,5));
        exercise1.add(new Modulo(2,8));
        exercise1.add(new Modulo(3,7));
        Modulo.teoremaChineDoResto(exercise1);

        System.out.printf("\nExercicio 2:\n");

        List<Modulo> exercise2 = new ArrayList();
        exercise2.add(new Modulo(1,3));
        exercise2.add(new Modulo(2,4));
        exercise2.add(new Modulo(3,5));
        Modulo.teoremaChineDoResto(exercise2);

        System.out.printf("\nExercicio 3:\n");

        List<Modulo> exercise3 = new ArrayList();
        exercise3.add(new Modulo(4,7));
        exercise3.add(new Modulo(5,8));
        exercise3.add(new Modulo(6,9));
        Modulo.teoremaChineDoResto(exercise3);

        System.out.printf("\n");

    }

    public static void main(String[] args) {

        //testeConjuntos();

        try {
            testeMasayukiDoModulo();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
