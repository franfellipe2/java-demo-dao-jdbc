package aplication;

import java.sql.Connection;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();

		System.out.println("TESTE 1 \n============================================================");
		Seller s = DaoFactory.createSellerDao(conn).findById(4);
		System.out.println(s);
		System.out.println();

		System.out.println("TESTE 2 \n============================================================");
		//List<Seller> sellers = DaoFactory.createSellerDao(conn).findByDeparmentId(2);
		List<Seller> sellers = DaoFactory.createSellerDao(conn).findByDeparment(new Department(2, null));
		for (Seller se : sellers) {
			System.out.println(se);
		}
		System.out.println();

		System.out.println("TESTE 3 \n============================================================");
		List<Seller> sellers2 = DaoFactory.createSellerDao(conn).findAll();
		for (Seller se : sellers2) {
			System.out.println(se);
		}
		System.out.println();
		
		DB.closeConnection();
	}

}
