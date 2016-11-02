/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_lorena;

import elementosComunes.VistaTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAÑANA - MLDF
 */
public class ControladorVista extends MouseAdapter implements ActionListener {

    negocio neg;
    ResultSet rs;
    vistaAlumnos v;
    private VistaTabla vtabla = null;

    public ControladorVista(vistaAlumnos d) {

        neg = new negocio();
        v = d;

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Inicio") {
            try {
                rs = neg.buscarAlumnos();
                rs.next();

                odtAlumno alumno = new odtAlumno();

                alumno = neg.getAlumno();
                v.getTxtName().setText(alumno.getNombre());
                v.getTxtApellido1().setText(alumno.getApellido1());
                v.getTxtApellido2().setText(alumno.getApellido2());
                v.getTxtDNI().setText(alumno.getDNI());
                v.getTxtRegistro().setText(alumno.getRegistro());

                vtabla = new VistaTabla(rs);
                v.getTabResultados().setModel(vtabla);

            } catch (SQLException ex) {
                Logger.getLogger(vistaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getActionCommand() == "Refresh") {
            try {
                rs = neg.buscarAlumnos();
                rs.next();

                odtAlumno alumno = new odtAlumno();

                alumno = neg.getAlumno();
                v.getTxtName().setText(alumno.getNombre());
                v.getTxtApellido1().setText(alumno.getApellido1());
                v.getTxtApellido2().setText(alumno.getApellido2());
                v.getTxtDNI().setText(alumno.getDNI());
                v.getTxtRegistro().setText(alumno.getRegistro());

                vtabla = new VistaTabla(rs);
                v.getTabResultados().setModel(vtabla);

            } catch (SQLException ex) {
                Logger.getLogger(vistaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getActionCommand() == "Alta") {
            odtAlumno ficha = new odtAlumno();

            ficha.setDNI(v.getTxtDNI().getText());
            ficha.setNombre(v.getTxtName().getText());
            ficha.setApellido1(v.getTxtApellido1().getText());
            ficha.setApellido2(v.getTxtApellido2().getText());

            neg.altaAlumno(ficha);
        }

        if (e.getActionCommand() == "Bajas") {
            odtAlumno ficha = new odtAlumno();

            ficha.setRegistro(v.getTxtRegistro().getText());

            neg.bajas(ficha);

        }
        if (e.getActionCommand() == "Modificar") {
            odtAlumno ficha = new odtAlumno();
            ficha.setDNI(v.getTxtDNI().getText());
            ficha.setNombre(v.getTxtName().getText());
            ficha.setApellido1(v.getTxtApellido1().getText());
            ficha.setApellido2(v.getTxtApellido2().getText());
            ficha.setRegistro(v.getTxtRegistro().getText());

            neg.modificar(ficha);
        }
        if (e.getActionCommand() == "Buscar") {
            try {
                odtAlumno ficha = new odtAlumno();
                ficha.setDNI(v.getTxtDNI().getText());
                ficha.setNombre(v.getTxtName().getText());
                ficha.setApellido1(v.getTxtApellido1().getText());
                ficha.setApellido2(v.getTxtApellido2().getText());
                ficha.setRegistro(v.getTxtRegistro().getText());

                rs = neg.buscar(ficha);
                rs.next();
                vtabla = new VistaTabla(rs);
                v.getTabResultados().setModel(vtabla);

            } catch (SQLException ex) {
                Logger.getLogger(ControladorVista.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        if(e.getActionCommand()=="Limpiar"){
        
            v.getTxtRegistro().setText("");
            v.getTxtDNI().setText("");
            v.getTxtName().setText("");
            v.getTxtApellido1().setText("");
            v.getTxtApellido2().setText("");
            
        }

        if (e.getActionCommand() == "<< Volver") {
            v.dispose();

        }

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        Mostrar_datos(v.getTabResultados().getSelectedRow());
    }

    private void Mostrar_datos(int fila) {

        v.getTxtDNI().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 1)));
        v.getTxtRegistro().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 0)));
        v.getTxtName().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 2)));
        v.getTxtApellido1().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 3)));
        v.getTxtApellido2().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 4)));

    }
}
