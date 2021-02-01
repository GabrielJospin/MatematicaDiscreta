package com.matematicaDiscreta.estruturasBasicas;

import java.util.List;

public class Conjunto {
    int tamanho;
    List<Object> lista;

    Conjunto(){
        this.tamanho = 0;
        this.lista = null;
    }

    void inserir(Object elemento){
        lista.add(elemento);
        tamanho++;
    }

    void removeAt(Object elemento) throws Exception {
        if(lista.contains(elemento)){
            lista.remove(elemento);
        }else {
            String textError = String.format("Error 404: %s is not found in the list",elemento.toString());
            throw new Exception(textError);
        }
    }

    static boolean estaIncluso(List<Object> a, List<Object> b){

        return true;
    }
}
