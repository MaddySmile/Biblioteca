/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import biblioteca_lorena.vistaAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import libros.vistaLibros;

/**
 *
 * @author MAÑANA - MLDF
 */
public class controladorInicio implements ActionListener{
    frameInicial frm ;

    public controladorInicio() {
        frm = new frameInicial(this);
        frm.setVisible(true);
        
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {                                          
      if(e.getActionCommand() == "Alumnos")  {
       new vistaAlumnos(frm).setVisible(true);
      // new ControladorVista();
         
        
           
          //que se abra en plan Jdialog
      }
      if(e.getActionCommand() == "Libros")  {
       new vistaLibros(frm).setVisible(true);
      }
      if(e.getActionCommand() == "Salir")  {
        frm.dispose();
      
      }
    }  
}
