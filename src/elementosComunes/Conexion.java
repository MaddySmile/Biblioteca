/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosComunes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAÑANA - MLDF
 */
public class Conexion {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private static Conexion conexion;

    private Conexion() {
        conectar();
    }

    public static Conexion getSingletonInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        } else {
            System.out.println("No se puede conectar porque ya está creada una conexión");
        }

        return conexion;
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            // st = con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cerrarConexion() {

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSet executeQuery(String sql) {
        Statement stmt;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int consultaUpdate(String cons) {
        try {
            Statement stmt;
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return stmt.executeUpdate(cons);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

}
