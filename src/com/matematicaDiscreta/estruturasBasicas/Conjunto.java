package com.matematicaDiscreta.estruturasBasicas;

import java.util.ArrayList;
import java.util.List;

public class Conjunto {
    int tamanho;
    public List<Object> lista;

    public Conjunto(){
        this.tamanho = 0;
        this.lista = new ArrayList();
    }

    public Conjunto(List<Object> lista){
        this.tamanho = lista.size();
        this.lista = lista;
    }

    public void inserir(Object elemento){
        lista.add(elemento);
        tamanho++;
    }

    public void removeAt(Object elemento) throws Exception {
        if(this.lista.contains(elemento)){
            this.lista.remove(elemento);
        }else {
            String textError = String.format("Error 404: %s is not found in the list",elemento.toString());
            throw new Exception(textError);
        }
    }

    public boolean estaInclusoEm(Conjunto conjuntoUniverso){
        if(this.lista.isEmpty()) return true;
        if(conjuntoUniverso.lista.isEmpty()) return false;

        return conjuntoUniverso.lista.containsAll(this.lista);
    }

    public boolean isEquals(Conjunto conjuntoResultado) {
        return this.estaInclusoEm(conjuntoResultado) &&
                conjuntoResultado.estaInclusoEm(this);
    }

    public static Conjunto uniao(Conjunto conjunto1, Conjunto conjunto2){

        Conjunto resposta = new Conjunto();

        for(Object i: conjunto1.lista){
            if(!resposta.lista.contains(i))resposta.inserir(i);
        }

        for(Object i: conjunto2.lista){
            if(!resposta.lista.contains(i))resposta.inserir(i);
        }

        return resposta;
    }

    public static Conjunto interseccao(Conjunto conjunto1, Conjunto conjunto2){

        Conjunto resposta = new Conjunto();

        if(conjunto1.lista.isEmpty() || conjunto2.lista.isEmpty()) return resposta;

        for(Object elemento: conjunto1.lista){
            if(elemento != null && conjunto2.lista.contains(elemento) && !resposta.lista.contains(elemento))
                resposta.inserir(elemento);
        }

        return resposta;
    }

    public static Conjunto diferenca(Conjunto conjunto1, Conjunto conjunto2){

        Conjunto resposta = new Conjunto();

        if(conjunto1.lista.isEmpty() || conjunto2.lista.isEmpty()) return conjunto1;

        for(Object elemento: conjunto1.lista){
            if(!conjunto2.lista.contains(elemento))
                resposta.inserir(elemento);
        }

        return resposta;
    }


}
