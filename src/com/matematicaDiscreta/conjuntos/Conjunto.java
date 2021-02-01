package com.matematicaDiscreta.conjuntos;

import java.util.List;

public class Conjunto {
    int tamanho;
    List<Object> lista;

    Conjunto(){
        this.tamanho = 0;
        this.lista = null;
    }

    void insert(Object element){
        lista.add(element);
        tamanho++;
    }

    void removeAt(Object element) throws Exception {
        if(lista.contains(element)){
            lista.remove(element);
        }else {
            String textError = String.format("Error 404: %s is not found in the list",element.toString());
            throw new Exception(textError);
        }
    }

    static boolean isInclude(List<Object> a, List<Object> b){
//        for(true){}
        return true;
    }
}
