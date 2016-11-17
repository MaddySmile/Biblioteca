/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import Prestamos.vistaPrestamosERROR;
import biblioteca_lorena.vistaAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import libros.vistaLibros;

/**
 *
 * @author MAÑANA - MLDF
 */
public class controladorInicio implements ActionListener {

    frameInicial frm;
    vistaAlumnos alumno;
    vistaLibros libros;
    vistaInformesERROR informes;
    vistaPrestamosERROR prestamos;

    public controladorInicio() {
        frm = new frameInicial(this);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Alumnos") {
            alumno = new vistaAlumnos(frm);
            alumno.setLocationRelativeTo(frm);
            alumno.setVisible(true);
        }
        if (e.getActionCommand() == "Libros") {
            libros = new vistaLibros(frm);
            libros.setLocationRelativeTo(frm);
            libros.setVisible(true);
        }
        if (e.getActionCommand() == "Informes") {
            System.out.println("OOOPS!");
            informes = new vistaInformesERROR(frm, true);
            informes.setLocationRelativeTo(frm);
            informes.setVisible(true);
        }

        if (e.getActionCommand() == "Prestamos") {
            System.out.println("OOPS!!!");
            prestamos = new vistaPrestamosERROR(frm, true);
            prestamos.setLocationRelativeTo(frm);
            prestamos.setVisible(true);
        }

        if (e.getActionCommand() == "Salir") {
            frm.dispose();

        }
    }
}
