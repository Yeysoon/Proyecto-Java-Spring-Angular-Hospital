package com.umg.arbol;

public class ArbolBinario {

    Nodo raiz;

    // Constructor para iniciarlizar raiz valor nulo
    public ArbolBinario() {
        this.raiz = null;
    }

    // Metodo para insertar valor en el arbol binario
    public void insertarValor(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquieNodo = insertarRec(nodo.izquieNodo, valor);
        } else if (valor > nodo.valor) {
            nodo.DereNodo = insertarRec(nodo.DereNodo, valor);
        }
        return nodo;
    }

    // Metodos para recorridos preorden, inorden, postorden

    // Metodo preOrden
    public void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + ", ");
            preOrden(nodo.izquieNodo);
            preOrden(nodo.DereNodo);
        }
    }

    // Metodo inOrden
    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquieNodo);
            System.out.print(nodo.valor + ", ");
            inOrden(nodo.DereNodo);
        }
    }

    // Metodo postOrden
    public void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquieNodo);
            postOrden(nodo.DereNodo);
            System.out.print(nodo.valor + ", ");
        }
    }

}
