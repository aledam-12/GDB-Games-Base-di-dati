package model;
import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.copiaBean;

public interface Prodotti
{
	public ArrayList<copiaBean> leggiTutteCopie (String sort) throws SQLException;
	public copiaBean leggiCopia(int codice) throws SQLException;
}