/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import src.dao.ParticipacionDAO;
import src.model.Participacion;
import src.util.ConexionBD;

import java.util.List;
import java.util.Scanner;
import servicio.ParticipacionesService;
import src.Controller.ParticipacionController;

public class MainListarParticipacionesPorEstudiante {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // COMPONENTES <----
        ConexionBD conexion = new ConexionBD();
        ParticipacionDAO dao = new ParticipacionDAO(conexion);
        ParticipacionesService service = new ParticipacionesService(dao);
        ParticipacionController controller = new ParticipacionController(service);

        System.out.print("Ingrese el ID del estudiante: ");
        int estID = Integer.parseInt(sc.nextLine());

        List<Participacion> lista = controller.listarParticipacionesPorEstudiante(estID);

        System.out.println("=== Participaciones encontradas ===");
        for (Participacion p : lista) {
            System.out.println("ID: " + p.getPartID()
                    + "\n | Tipo: " + p.getTipo()
                    + "\n | Puntaje: " + p.getPuntaje()
                    + "\n | Observación: " + p.getObservacion()
                    + "\n | Fecha: " + p.getFecha()
                    + "\n | Sesión ID: " + p.getSesion().getSesID());
        }

        if (lista.isEmpty()) {
            System.out.println("No se encontraron participaciones para el estudiante.");
        }
    }
}
