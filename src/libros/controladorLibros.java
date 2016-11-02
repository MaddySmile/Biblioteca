/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros;

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
 * @author Lorena
 */
public class controladorLibros extends MouseAdapter implements ActionListener {

    negocioLibros neg;
    ResultSet rs;
    vistaLibros v;
    private VistaTabla vtabla = null;

    public controladorLibros(vistaLibros d) {
        neg = new negocioLibros();
        v = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Inicio") {
            try {
                rs = neg.buscarLibros();
                rs.next();

                odtLibros libro = new odtLibros();
               
                libro = neg.getLibros();
                
                v.getTxtCodigo().setText(libro.getCodigo());
                v.getTxtTitulo().setText(libro.getTitulo());
                v.getTxtAutor().setText(libro.getAutor());
                v.getTxtEditorial().setText(libro.getEditorial());
                v.getTxtAsignatura().setText(libro.getAsignatura());
                v.getTxtEstado().setText(libro.getEstado());
                
                vtabla = new VistaTabla(rs);
                v.getTabLibros().setModel(vtabla);

            } catch (SQLException ex) {
                Logger.getLogger(vistaLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand() == "Refresh") {
               try {
                rs = neg.buscarLibros();
                rs.next();

                odtLibros libro = new odtLibros();
               
                libro = neg.getLibros();
                
                v.getTxtCodigo().setText(libro.getCodigo());
                v.getTxtTitulo().setText(libro.getTitulo());
                v.getTxtAutor().setText(libro.getAutor());
                v.getTxtEditorial().setText(libro.getEditorial());
                v.getTxtAsignatura().setText(libro.getAsignatura());
                v.getTxtEstado().setText(libro.getEstado());
                
                vtabla = new VistaTabla(rs);
                v.getTabLibros().setModel(vtabla);

            } catch (SQLException ex) {
                Logger.getLogger(vistaLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   
   }
        
        else if (e.getActionCommand() == "Alta") {
            
            odtLibros libro = new odtLibros();
            
            libro.setTitulo(v.getTxtTitulo().getText());
            libro.setAutor(v.getTxtAutor().getText());
            libro.setEditorial(v.getTxtEditorial().getText());
            libro.setAsignatura(v.getTxtAsignatura().getText());
            libro.setEstado(v.getTxtEstado().getText());

           neg.altaLibro(libro);

          
        }

        else if (e.getActionCommand() == "Bajas") {
            odtLibros libro = new odtLibros();
            libro.setCodigo(v.getTxtCodigo().getText());
            
            neg.bajasLibros(libro);

        } 
        else if (e.getActionCommand() == "Modificar") {
            odtLibros libro = new odtLibros();
            
            libro.setTitulo(v.getTxtTitulo().getText());
            libro.setAutor(v.getTxtAutor().getText());
            libro.setEditorial(v.getTxtEditorial().getText());
            libro.setAsignatura(v.getTxtAsignatura().getText());
            libro.setEstado(v.getTxtEstado().getText());
            libro.setCodigo(v.getTxtCodigo().getText());
            
            neg.modificar(libro);
        }
        
          if (e.getActionCommand() == "Buscar") {
           
            try {
                odtLibros ficha = new odtLibros();
                ficha.setAsignatura(v.getTxtAsignatura().getText());
                ficha.setAutor(v.getTxtAutor().getText());
                ficha.setCodigo(v.getTxtCodigo().getText());
                ficha.setEditorial(v.getTxtEditorial().getText());
                ficha.setEstado(v.getTxtEstado().getText());
                ficha.setTitulo(v.getTxtTitulo().getText());

                rs = neg.buscar(ficha);
                rs.next();
                vtabla = new VistaTabla(rs);
                v.getTabLibros().setModel(vtabla);
            } catch (SQLException ex) {
                Logger.getLogger(controladorLibros.class.getName()).log(Level.SEVERE, null, ex);
            }

           

        }
        
        if(e.getActionCommand()=="Limpiar"){
            v.getTxtAsignatura().setText("");
            v.getTxtAutor().setText("");
            v.getTxtCodigo().setText("");
            v.getTxtEditorial().setText("");
            v.getTxtEstado().setText("");
            v.getTxtTitulo().setText("");

            
        }

        if (e.getActionCommand() == "<< Volver") {
            v.dispose();

        }
    }

    

   
  
    @Override
     public void mouseClicked(java.awt.event.MouseEvent evt) {
         MostrarDatos(v.getTabLibros().getSelectedRow());
 
    }

    private void MostrarDatos(int fila) {
        v.getTxtCodigo().setText(String.valueOf(v.getTabLibros().getValueAt(fila, 0)));
        v.getTxtTitulo().setText(String.valueOf(v.getTabLibros().getValueAt(fila, 1)));
        v.getTxtAutor().setText(String.valueOf(v.getTabLibros().getValueAt(fila, 2)));
        v.getTxtEditorial().setText(String.valueOf(v.getTabLibros().getValueAt(fila, 3)));
        v.getTxtAsignatura().setText(String.valueOf(v.getTabLibros().getValueAt(fila, 4)));
        v.getTxtEstado().setText(String.valueOf(v.getTabLibros().getValueAt(fila, 5)));
    }
        
}
