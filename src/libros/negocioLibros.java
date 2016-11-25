/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros;

import elementosComunes.Conexion;
import interfaces.negocios;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lorena
 */
public class negocioLibros implements negocios {

    ResultSet rs;
    Conexion con;

    public negocioLibros() {

        con = Conexion.getSingletonInstance();

    }

    @Override
    public ResultSet buscarTodo() {

        String sql = "SELECT * FROM LIBROS";

        return con.executeQuery(sql);

    }

    @Override
    public ResultSet buscar(Object o) {

        odtLibros v = (odtLibros) o;
        String sql = "select * from libros where ";
        if (!(v.getAsignatura()).equals("")) {
            //System.out.println("asignatura");
            sql = sql + "asignatura like '%" + v.getAsignatura() + "%' and ";
        }
        if (!(v.getAutor()).equals("")) {
            //System.out.println("Autor");
            sql = sql + "autor like '%" + v.getAutor() + "%' and ";
        }
        if (!(v.getCodigo()).equals("")) {
            // System.out.println("COD");
            sql = sql + "codigo like '%" + v.getCodigo() + "%' and ";
        }
        if (!(v.getEditorial()).equals("")) {
            // System.out.println("ed");
            sql = sql + "editorial like '%" + v.getEditorial() + "%' and ";
        }
        if (!(v.getEstado()).equals("")) {
            //  System.out.println("estado");
            sql = sql + "estado like '%" + v.getEstado() + "%' and ";
        }
        if (!(v.getTitulo()).equals("")) {
            //  System.out.println("titulo");
            sql = sql + "titulo like '%" + v.getTitulo() + "%' and ";
        }

        sql = sql.substring(0, sql.length() - 5);
        //  System.out.println(sql.substring(0, sql.length() - 4));
        return con.executeQuery(sql);

    }

    public odtLibros getLibros() throws SQLException {
        rs = con.getRs();
        odtLibros libro = new odtLibros();
        libro.setCodigo(rs.getString("codigo"));
        libro.setTitulo(rs.getString("TITULO"));
        libro.setAutor(rs.getString("AUTOR"));
        libro.setEditorial(rs.getString("EDITORIAL"));
        libro.setAsignatura(rs.getString("ASIGNATURA"));
        libro.setEstado(rs.getString("ESTADO"));

        return libro;
    }

    @Override
    public void alta(Object o) {
        odtLibros ficha = (odtLibros) o;
        String consulta = "INSERT INTO libros (Titulo, Autor, Editorial, Asignatura, estado) VALUES ('" + ficha.getTitulo() + "', '" + ficha.getAutor() + "', '" + ficha.getEditorial() + "', '" + ficha.getAsignatura() + "', '" + ficha.getEstado() + "')";
        con.consultaUpdate(consulta);
        

    }

    @Override
    public void bajas(Object o) {
        odtLibros ficha = (odtLibros) o;

        String sql = "delete from libros where codigo=" + ficha.getCodigo();
        con.consultaUpdate(sql);        
    }

    @Override
    public void modificar(Object o) {
        odtLibros ficha = (odtLibros) o;
        String sql = "UPDATE LIBROS SET Titulo='" + ficha.getTitulo() + "', Autor='" + ficha.getAutor() + "', Editorial='" + ficha.getEditorial() + "', Asignatura='" + ficha.getAsignatura() + "', Estado='" + ficha.getEstado() + "' where codigo=" + ficha.getCodigo();
        con.consultaUpdate(sql);
       
    }

}
