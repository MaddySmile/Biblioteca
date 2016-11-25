/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;

/**
 *
 * @author MAÑANA - MLDF
 */
public interface negocios {

    public ResultSet buscarTodo();

    public ResultSet buscar(Object o);

    public void alta(Object o);

    public void bajas(Object o);

    public void modificar(Object o);
}
