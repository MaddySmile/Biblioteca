/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosComunes;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MAÑANA - MLDF
 */
public class VistaTabla extends AbstractTableModel{
    ResultSet _rs;
    ResultSetMetaData md; //contiene información sobre la estructura de un ResulSet,especialmente sobre sus nom campos
    int _numColumnas;
    int _numFilas;
    
    public VistaTabla(ResultSet rs){
      this._rs=rs;
      try{
          md=rs.getMetaData();
          _rs.last();
          _numFilas=_rs.getRow();
          _numColumnas=md.getColumnCount();
          
      }
      catch( SQLException ex){
      }
    }
    @Override
    public int getRowCount() {
        return _numFilas;
        
    }

    @Override
    public int getColumnCount() {
        return _numColumnas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          try {
            _rs.absolute(rowIndex+1);
            Object o=_rs.getObject(columnIndex +1);
            return o;
        }
        catch (SQLException ex){
            return ex.toString();
        }
        
    }
    
    
}