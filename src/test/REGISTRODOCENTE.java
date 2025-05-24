/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalDate;
import src.Controller.DocenteController;
import src.dao.DocenteDAO;
import src.model.Docente;
import src.util.ConexionBD;

/**
 *
 * @author ASUS
 */
public class REGISTRODOCENTE {
     public static void main(String[] args) {
         
        // Preparar la conexión (tu clase de conexión a la base de datos)
        ConexionBD conexion = new ConexionBD();

        // Instanciar DAO
 
        DocenteDAO docenteDAO = new DocenteDAO(conexion);
        
        DocenteController docenteController = new DocenteController(docenteDAO);

        // Crear un docente de prueba
        Docente docentePrueba = new Docente();
       
        
        docentePrueba.setEspecialidad("Matemáticas"); 
        docentePrueba.setTelefono("987654321");
        docentePrueba.setDireccion("Av. Principal 123");
        docentePrueba.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        docentePrueba.setNombre("Juan");
        docentePrueba.setApellido("Pérez");
        docentePrueba.setContraseña("12345"); // ⚠️ Recuerda manejar contraseñas seguras
        docentePrueba.setCorreo("juanperez@example.com");

        // Probar el método
        boolean exito = docenteController.registrarDocente(docentePrueba);

        if (exito) {
            System.out.println("✅ Docente registrado exitosamente con ID: " + docentePrueba.getDocID());
        } else {
            System.out.println("❌ Error al registrar el docente.");
        }
    }
}
