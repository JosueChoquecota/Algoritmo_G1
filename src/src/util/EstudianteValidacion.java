
package src.util;


public class EstudianteValidacion {
    
    public static boolean validarDNI(String dni) {
    return dni != null && dni.trim().matches("\\d{8}");
}
}
