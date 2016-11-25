/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

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
public class controladorAlumnos extends MouseAdapter implements ActionListener {

    negocioAlumnos neg;
    ResultSet rs;
    vistaAlumnos v;
    private VistaTabla vtabla = null;
    odtAlumno ficha;

    public controladorAlumnos(vistaAlumnos d) {

        neg = new negocioAlumnos();
        ficha = new odtAlumno();
        v = d;
        iniciarConexion();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Alta") {

            ficha.setDNI(v.getTxtDNI().getText());
            ficha.setNombre(v.getTxtName().getText());
            ficha.setApellido1(v.getTxtApellido1().getText());
            ficha.setApellido2(v.getTxtApellido2().getText());

            neg.alta(ficha);
            iniciarConexion();
        }

        if (e.getActionCommand() == "Bajas") {

            ficha.setRegistro(v.getTxtRegistro().getText());

            neg.bajas(ficha);
            iniciarConexion();

        }
        if (e.getActionCommand() == "Modificar") {
            setCamposComunes();
            neg.modificar(ficha);
            iniciarConexion();

        }
        if (e.getActionCommand() == "Buscar") {
            try {
                setCamposComunes();
                rs = neg.buscar(ficha);
                rs.next();
                vtabla = new VistaTabla(rs);
                v.getTabResultados().setModel(vtabla);

            } catch (SQLException ex) {
                Logger.getLogger(controladorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getActionCommand() == "Limpiar") {
            iniciarConexion();

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

    public void setCamposComunes() {

        ficha.setDNI(v.getTxtDNI().getText());
        ficha.setNombre(v.getTxtName().getText());
        ficha.setApellido1(v.getTxtApellido1().getText());
        ficha.setApellido2(v.getTxtApellido2().getText());
        ficha.setRegistro(v.getTxtRegistro().getText());
    }

    public void iniciarConexion() {
        try {
            rs = neg.buscarTodo();
            rs.next();

            ficha = neg.getAlumno();
            v.getTxtName().setText(ficha.getNombre());
            v.getTxtApellido1().setText(ficha.getApellido1());
            v.getTxtApellido2().setText(ficha.getApellido2());
            v.getTxtDNI().setText(ficha.getDNI());
            v.getTxtRegistro().setText(ficha.getRegistro());

            vtabla = new VistaTabla(rs);
            v.getTabResultados().setModel(vtabla);

        } catch (SQLException ex) {
            Logger.getLogger(vistaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Mostrar_datos(int fila) {

        v.getTxtDNI().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 1)));
        v.getTxtRegistro().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 0)));
        v.getTxtName().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 2)));
        v.getTxtApellido1().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 3)));
        v.getTxtApellido2().setText(String.valueOf(v.getTabResultados().getValueAt(fila, 4)));

    }
}
