/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import elementosComunes.Conexion;
import interfaces.negocios;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MAÑANA - MLDF
 */
public class negocioAlumnos implements negocios {

    ResultSet rs;
    Conexion con;

    public negocioAlumnos() {
        con = Conexion.getSingletonInstance();

    }

    @Override
    public ResultSet buscarTodo() {

        String sql = "SELECT * FROM ALUMNOS";
        return con.executeQuery(sql);

    }

    @Override
    public ResultSet buscar(Object o) {
        odtAlumno v = (odtAlumno) o;
        //Buscar por campos.

        String sql = "select * from alumnos where ";
        if (!(v.getNombre()).equals("")) {
            sql = sql + "nombre like '%" + v.getNombre() + "%' and ";
        }
        if (!(v.getRegistro()).equals("")) {
            sql = sql + "registro like '%" + v.getRegistro() + "%' and ";
        }
        if (!(v.getDNI()).equals("")) {
            sql = sql + "dni like '%" + v.getDNI() + "%' and ";
        }
        if (!(v.getApellido1()).equals("")) {
            sql = sql + "apellido1 like '%" + v.getApellido1() + "%' and ";
        }
        if (!(v.getApellido2()).equals("")) {
            sql = sql + "apellido2 like '%" + v.getApellido2() + "%' and '";
        }

        sql = sql.substring(0, sql.length() - 5); //sirve para quitar el "and" 

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

    @Override
    public void alta(Object o) {
        odtAlumno ficha = (odtAlumno) o;

        String consulta
                = "Insert into alumnos(dni, nombre, apellido1, apellido2) values ('" + ficha.getDNI() + "', '" + ficha.getNombre() + "'," + " '" + ficha.getApellido1() + "', '" + ficha.getApellido2() + "')";
        con.consultaUpdate(consulta);
        

    }

    @Override
    public void bajas(Object o) {
        odtAlumno ficha = (odtAlumno) o;
        String sql = "delete from alumnos where registro=" + ficha.getRegistro();
        con.consultaUpdate(sql);
      
    }

    @Override
    public void modificar(Object o) {
        odtAlumno ficha = (odtAlumno) o;

        String sql = "update alumnos set dni='" + ficha.getDNI()
                + "', nombre='" + ficha.getNombre()
                + "', "
                + "apellido1='" + ficha.getApellido1()
                + "', apellido2='" + ficha.getApellido2() + "' "
                + "where registro=" + ficha.getRegistro();
        
        con.consultaUpdate(sql);            
    }

}
