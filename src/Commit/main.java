package Commit;
import java.util.Scanner;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("📦 Configuración de cola de pedidos LOCAL:");
        ColaPedidos colaLocal = new ColaPedidos();

        System.out.println("\n🚚 Configuración de cola de pedidos DELIVERY:");
        ColaPedidos colaDelivery = new ColaPedidos();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS - RESTAURANTE ===");
            System.out.println("1. Agregar pedido en local");
            System.out.println("2. Agregar pedido por delivery");
            System.out.println("3. Atender pedido en local");
            System.out.println("4. Atender pedido por delivery");
            System.out.println("5. Mostrar pedidos en local");
            System.out.println("6. Mostrar pedidos por delivery");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); 

            switch (opcion) {
                case 1 -> colaLocal.agregarPedidos(leer, "LOCAL");
                case 2 -> colaDelivery.agregarPedidos(leer, "DELIVERY");
                case 3 -> colaLocal.atenderPedido("LOCAL");
                case 4 -> colaDelivery.atenderPedido("DELIVERY");
                case 5 -> colaLocal.mostrarPedidos("LOCAL");
                case 6 -> colaDelivery.mostrarPedidos("DELIVERY");
                case 7 -> System.out.println("🔒 Cerrando sistema...");
                default -> System.out.println("❌ Opción inválida.");
            }

        } while (opcion != 7);
    }
}


