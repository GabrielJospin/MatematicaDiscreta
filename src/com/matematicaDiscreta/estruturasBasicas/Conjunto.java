package com.matematicaDiscreta.estruturasBasicas;

import java.util.List;

public class Conjunto {
    int tamanho;
    List<Object> lista;

    Conjunto(){
        this.tamanho = 0;
        this.lista = null;
    }

    Conjunto(List<Object> lista){
        this.tamanho = lista.size();
        this.lista = lista;
    }

    void inserir(Object elemento){
        lista.add(elemento);
        tamanho++;
    }

    void removeAt(Object elemento) throws Exception {
        if(this.lista.contains(elemento)){
            this.lista.remove(elemento);
        }else {
            String textError = String.format("Error 404: %s is not found in the list",elemento.toString());
            throw new Exception(textError);
        }
    }

    static boolean estaIncluso(Conjunto ConjuntoPremissa, Conjunto conjuntoResultado){
        if(ConjuntoPremissa.lista.isEmpty()) return true;
        if(conjuntoResultado.lista.isEmpty()) return false;

        return conjuntoResultado.lista.containsAll(ConjuntoPremissa.lista);
    }

    static boolean isEquals(Conjunto conjuntoPremissa, Conjunto conjuntoResultado) {
        return estaIncluso(conjuntoPremissa, conjuntoResultado) &&
                estaIncluso(conjuntoPremissa, conjuntoResultado);
    }

    static Conjunto uniao(Conjunto conjunto1, Conjunto conjunto2){

        conjunto1.lista.addAll(conjunto2.lista);

        return conjunto1;
    }

    static Conjunto interseccao(Conjunto conjunto1, Conjunto conjunto2){

        Conjunto resposta = new Conjunto();

        if(conjunto1.lista.isEmpty() || conjunto2.lista.isEmpty()) return resposta;

        for(Object elemento: conjunto1.lista){
            if(conjunto2.lista.contains(elemento))
                resposta.inserir(elemento);
        }

        return resposta;
    }

    static Conjunto diferenca(Conjunto conjunto1, Conjunto conjunto2){

        Conjunto resposta = new Conjunto();

        if(conjunto1.lista.isEmpty() || conjunto2.lista.isEmpty()) return conjunto1;

        for(Object elemento: conjunto1.lista){
            if(!conjunto2.lista.contains(elemento))
                resposta.inserir(elemento);
        }

        return resposta;
    }


}
