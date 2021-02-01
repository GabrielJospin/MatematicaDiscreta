package com.matematicaDiscreta;

import com.matematicaDiscreta.estruturasBasicas.Conjunto;
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

    public static void main(String[] args) {

        testeConjuntos();

    }
}
