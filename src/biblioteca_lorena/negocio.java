 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca_lorena;

import elementosComunes.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MAÑANA - MLDF
 */
public class negocio {

    ResultSet rs;
    Conexion con;

    public negocio() {
        con = Conexion.getSingletonInstance();

    }

    public ResultSet buscarAlumnos() {
        //Consulta para mostrar todos los alumnnos.
        String sql = "SELECT * FROM ALUMNOS";
        return con.executeQuery(sql);

    }
    
     public ResultSet buscar(odtAlumno v) {
     
         //Buscar por campos.
         
         String sql = "select * from alumnos where ";
          if(!(v.getNombre()).equals("")  ){
              sql = sql + "nombre like '%"+v.getNombre() +"%' and ";
          }
          if(!(v.getRegistro()).equals("")){
              sql = sql + "registro like '%"+v.getRegistro()+"%' and ";
          }
          if(!(v.getDNI()).equals("")){
              sql = sql + "dni like '%"+v.getDNI()+"%' and ";
          }
          if(!(v.getApellido1()).equals("")){
              sql = sql + "apellido1 like '%"+v.getApellido1()+"%' and ";
          }
          if(!(v.getApellido2()).equals("")){
              sql = sql + "apellido2 like '%"+v.getApellido2()+"%' and '";
          }
        
              sql = sql.substring(0,sql.length()-5); //sirve para quitar el "and" 
             
              return con.executeQuery(sql);
    }

    public odtAlumno getAlumno() throws SQLException {
        rs = con.getRs();
        odtAlumno alumno = new odtAlumno();
        alumno.setNombre(rs.getString("nombre"));
        alumno.setApellido1(rs.getString("APELLIDO1"));
        alumno.setApellido2(rs.getString("APELLIDO2"));
        alumno.setDNI(rs.getString("DNI"));
        alumno.setRegistro(rs.getString("REGISTRO"));

        return alumno;      
    }

    public String getNombre() throws SQLException {
        rs = con.getRs();
        return rs.getString("NOMBRE");
    }

    public String getApellido1() throws SQLException {
        rs = con.getRs();
        return rs.getString("APELLIDO1");
    }

    public String getApellido2() throws SQLException {
        rs = con.getRs();
        return rs.getString("APELLIDO2");
    }

    public String getDNI() throws SQLException {
        rs = con.getRs();
        return rs.getString("DNI");
    }

    public String getRegistro() throws SQLException {
        rs = con.getRs();
        return rs.getString("REGISTRO");
    }

    public void altaAlumno(odtAlumno ficha) {
        String consulta =
   "Insert into alumnos(dni, nombre, apellido1, apellido2) values ('"+ficha.getDNI()+"', '"+ficha.getNombre()+"',"+ " '"+ficha.getApellido1()+"', '"+ficha.getApellido2()+"')";
      
            if(con.consultaUpdate(consulta) > 0){
         JOptionPane.showMessageDialog(null, "Alta Correcta");
     } else {
         JOptionPane.showMessageDialog(null, "Ha Habido un error en su correcta.");          
     }
         
    }
    
    public void bajas(odtAlumno ficha){
          String sql="delete from alumnos where registro=" + ficha.getRegistro(); 
     if(con.consultaUpdate(sql) > 0){
         JOptionPane.showMessageDialog(null, "Baja Correcta");
     } else {
         JOptionPane.showMessageDialog(null, "Ha Habido un Error");
     }
 
    }
    
    public void modificar(odtAlumno ficha){
          String sql = "update alumnos set dni='" + ficha.getDNI() +
                  "', nombre='" + ficha.getNombre() +
                  "', "
                   + "apellido1='" + ficha.getApellido1() + 
                  "', apellido2='" + ficha.getApellido2() + "' "
                          + "where registro=" + ficha.getRegistro();
        if (con.consultaUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
       
    }
    public void cerrar(){
        con.cerrarConexion();
    }
    
    
    
}
