package model;
import java.sql.SQLException;
import java.util.ArrayList;

import model.beans.CopiaBean;

public interface Prodotti
{
	public ArrayList<CopiaBean> leggiTutteCopie (String sort) throws SQLException;
	public CopiaBean leggiCopia(int codice) throws SQLException;
}