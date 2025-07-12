/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.List;
import src.model.Estudiante;
import src.model.EstudianteCurso;
import src.model.NodoEstudianteCurso;

public class ArbolEstudianteCurso {
    private NodoEstudianteCurso raiz;

    public void insertar(EstudianteCurso estudianteCurso) {
        raiz = insertarRec(raiz, estudianteCurso);
    }

    private NodoEstudianteCurso insertarRec(NodoEstudianteCurso actual, EstudianteCurso estudianteCurso) {
        if (actual == null) {
            return new NodoEstudianteCurso(estudianteCurso);
        }

        if (estudianteCurso.getParticipacionTotal() > actual.estudianteCurso.getParticipacionTotal()) {
            actual.derecha = insertarRec(actual.derecha, estudianteCurso);
        } else {
            actual.izquierda = insertarRec(actual.izquierda, estudianteCurso);
        }

        return actual;
    }

    public void inOrdenDescendente(List<EstudianteCurso> lista) {
        inOrdenDescRec(raiz, lista);
    }

    private void inOrdenDescRec(NodoEstudianteCurso nodo, List<EstudianteCurso> lista) {
        if (nodo != null) {
            inOrdenDescRec(nodo.derecha, lista); // mayor puntaje primero
            lista.add(nodo.estudianteCurso);
            inOrdenDescRec(nodo.izquierda, lista);
        }
    }
    public void inOrdenAscendente(List<EstudianteCurso> lista) {
    inOrdenAscRec(raiz, lista);
}

    private void inOrdenAscRec(NodoEstudianteCurso nodo, List<EstudianteCurso> lista) {
        if (nodo != null) {
            inOrdenAscRec(nodo.izquierda, lista); // menor puntaje primero
            lista.add(nodo.estudianteCurso);
            inOrdenAscRec(nodo.derecha, lista);
        }
    }
}