/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commit;

import java.util.Scanner;

public class ColaPedidos {
    private String[] pedidos;
    private int frente;
    private int fin;
    private int capacidad;

    public ColaPedidos() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese la capacidad máxima de la cola: ");
        this.capacidad = leer.nextInt();
        leer.nextLine();

        pedidos = new String[capacidad];
        frente = 0;
        fin = -1;
    }

    public boolean estaVacia() {
        return frente > fin;
    }

    public boolean estaLlena() {
        return fin == capacidad - 1;
    }

    public void agregarPedidos(Scanner leer, String tipo) {
        System.out.print("Ingrese pedido en " + tipo + ": ");
        String pedido = leer.nextLine();
        if (agregar(pedido)) {
            System.out.println("Pedido agregado en cola " + tipo.toLowerCase() + ".");
        } else {
            System.out.println("Cola " + tipo.toLowerCase() + " llena.");
        }
    }

    public void atenderPedido(String tipo) {
        String atendido = eliminar();
        if (atendido != null) {
            System.out.println("Pedido atendido en " + tipo.toLowerCase() + ": " + atendido);
        } else {
            System.out.println("No hay pedidos en cola " + tipo.toLowerCase() + ".");
        }
    }

    public void mostrarPedidos(String tipo) {
        System.out.println("Pedidos en " + tipo + ":");
        if (estaVacia()) {
            System.out.println("   - No hay pedidos.");
        } else {
            for (int i = frente; i <= fin; i++) {
                System.out.println("   - " + pedidos[i]);
            }
        }
    }
    private boolean agregar(String pedido) {
        if (!estaLlena()) {
            fin++;
            pedidos[fin] = pedido;
            return true;
        }
        return false;
    }
    private String eliminar() {
        if (!estaVacia()) {
            String eliminado = pedidos[frente];
            frente++;
            return eliminado;
        }
        return null;
    }
}

