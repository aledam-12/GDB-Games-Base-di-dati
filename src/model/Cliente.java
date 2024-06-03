package model;
import model.beans.ClienteBean;
import java.sql.*;

public interface Cliente
{
    public void inserisciCliente(ClienteBean c) throws SQLException;
    public ClienteBean leggiCliente(String e) throws SQLException;
    public boolean isRegistrato (ClienteBean cliente) throws SQLException;
}