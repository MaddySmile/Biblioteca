/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros;

import elementosComunes.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lorena
 */
public class negocioLibros {

    ResultSet rs;
    Conexion con;

    public negocioLibros() {

        con = Conexion.getSingletonInstance();

    }

    public ResultSet buscarLibros() {

        String sql = "SELECT * FROM LIBROS";

        return con.executeQuery(sql);

    }

    public ResultSet buscar(odtLibros v) {
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

    public String getCodigo() throws SQLException {
        rs = con.getRs();
        return rs.getString("CODIGO");
    }

    public String getTitulo() throws SQLException {
        rs = con.getRs();
        return rs.getString("TITULO");
    }

    public String getAutor() throws SQLException {
        rs = con.getRs();
        return rs.getString("AUTOR");
    }

    public String getEditorial() throws SQLException {
        rs = con.getRs();
        return rs.getString("EDITORIAL");
    }

    public String getAsignatura() throws SQLException {
        rs = con.getRs();
        return rs.getString("ASIGNATURA");
    }

    public String getEstado() throws SQLException {
        rs = con.getRs();
        return rs.getString("ESTADO");
    }

    public void altaLibro(odtLibros ficha) {
        //adsfasdfasdfasdf <3

        String consulta = "INSERT INTO libros (Titulo, Autor, Editorial, Asignatura, estado) VALUES ('" + ficha.getTitulo() + "', '" + ficha.getAutor() + "', '" + ficha.getEditorial() + "', '" + ficha.getAsignatura() + "', '" + ficha.getEstado() + "')";

        if (con.consultaUpdate(consulta) > 0) {
            JOptionPane.showMessageDialog(null, "Alta Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error en su alta ");

        }

    }

    public void bajasLibros(odtLibros ficha) {//Is OK
        String sql = "delete from libros where codigo=" + ficha.getCodigo();

        if (con.consultaUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Baja Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }

    }

    public void modificar(odtLibros s) {
        String sql = "UPDATE LIBROS SET Titulo='" + s.getTitulo() + "', Autor='" + s.getAutor() + "', Editorial='" + s.getEditorial() + "', Asignatura='" + s.getAsignatura() + "', Estado='" + s.getEstado() + "' where codigo=" + s.getCodigo();

        if (con.consultaUpdate(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }

    }

}
