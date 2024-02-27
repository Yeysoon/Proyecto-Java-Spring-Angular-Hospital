package com.umg.arbol;

public final class App {

    
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */

     //Metodo principal
    public static void main(String[] args) {


        System.out.println("\tArboles Binarios");

        //Ingreso de valores al arbol binario por medio de crear una instancia de la clase ArbolBinario

        ArbolBinario arbolBinario = new ArbolBinario();
        arbolBinario.insertarValor(50);
        arbolBinario.insertarValor(30);
        arbolBinario.insertarValor(70);
        arbolBinario.insertarValor(20);
        arbolBinario.insertarValor(40);
        arbolBinario.insertarValor(60);
        arbolBinario.insertarValor(90);
        

        /*
         * Mostrar valores segun el tipo de recorrido del arbol
         
                     Ejemplo de Arbol
                           50
                         /     \
                       30       70
                      / \       / \
                     20  40   60   90
         */
        
        System.out.println("\nRecorrido preOrden: ");
        arbolBinario.preOrden(arbolBinario.raiz);
        System.out.println("\n\nRecorrido inOrden: ");
        arbolBinario.inOrden(arbolBinario.raiz);
        System.out.println("\n\nRecorrido postOrden: ");
        arbolBinario.postOrden(arbolBinario.raiz);
        
    }
}
