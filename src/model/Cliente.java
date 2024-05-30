package model;
import model.beans.clienteBean;
import java.sql.*;

public interface Cliente
{
    public void inserisciCliente(clienteBean c) throws SQLException;
    public clienteBean leggiCliente(String e) throws SQLException;
    public boolean isRegistrato (clienteBean cliente) throws SQLException;
}