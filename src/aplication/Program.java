package aplication;

import java.sql.Connection;

import db.DB;
import model.dao.DaoFactory;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		
		Seller s = DaoFactory.createSellerDao(conn).findById(4);
		System.out.println(s);
		
		DB.closeConnection();
	}

}
