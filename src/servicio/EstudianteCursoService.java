/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import src.model.EstudianteCurso;

/**
 *
 * @author ASUS
 */
public class EstudianteCursoService {
    public List<EstudianteCurso> ordenarPorNotaDeso(List<EstudianteCurso> estudiantesCurso) {
        ArbolEstudianteCurso arbol = new ArbolEstudianteCurso();

        for (EstudianteCurso ec : estudiantesCurso) {
            arbol.insertar(ec);
        }

        List<EstudianteCurso> ordenados = new ArrayList<>();
        arbol.inOrdenDescendente(ordenados);
        return ordenados;
    }
    public List<EstudianteCurso> ordenarPorNotaAsc(List<EstudianteCurso> estudiantesCurso) {
        ArbolEstudianteCurso arbol = new ArbolEstudianteCurso();

        for (EstudianteCurso ec : estudiantesCurso) {
            arbol.insertar(ec); // inserta por puntaje
        }

        List<EstudianteCurso> ordenados = new ArrayList<>();
        arbol.inOrdenAscendente(ordenados);
        return ordenados;
    }

}
