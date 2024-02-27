package com.umg.arbol;

//Clase que define un nodo
public class Nodo {

    //Atributos de la Estructura-Clase nodo
    int valor;
    Nodo izquieNodo, DereNodo;


    //Constructor que inicializa nodo valor
    public Nodo(int valor) {
        this.valor = valor;
        izquieNodo = DereNodo = null;
    }

    

}
