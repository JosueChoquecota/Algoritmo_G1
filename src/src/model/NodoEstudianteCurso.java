/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

/**
 *
 * @author ASUS
 */
public class NodoEstudianteCurso {
    public EstudianteCurso estudianteCurso;
    public NodoEstudianteCurso izquierda;
    public NodoEstudianteCurso derecha;

    public NodoEstudianteCurso(EstudianteCurso estudianteCurso) {
        this.estudianteCurso = estudianteCurso;
        this.izquierda = null;
        this.derecha = null;
    }
}
