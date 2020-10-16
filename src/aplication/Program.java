package aplication;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		SellerDao sellerDao = DaoFactory.createSellerDao(conn);

		System.out.println("TESTE 1 Seller findById\n============================================================");
		Seller s = sellerDao.findById(4);
		System.out.println(s);
		System.out.println();

		System.out
				.println("TESTE 2  Sellers by Deparment \n============================================================");
		// List<Seller> sellers =
		// DaoFactory.createSellerDao(conn).findByDeparmentId(2);
		List<Seller> sellers = sellerDao.findByDeparment(new Department(2, null));
		for (Seller se : sellers) {
			System.out.println(se);
		}
		System.out.println();

		System.out.println("TESTE 3 All sellers \n============================================================");
		List<Seller> sellers2 = sellerDao.findAll();
		for (Seller se : sellers2) {
			System.out.println(se);
		}
		System.out.println();

		System.out.println("TESTE 4 Inser seller \n============================================================");
		Seller newSeller = new Seller(null, "Rose", "rose@gamil.com", new Date(), 3500.00, new Department(4, null));
		//sellerDao.insert(newSeller);		
		System.out.println(newSeller);
		
		
		System.out.println("TESTE 5 seller upate \n============================================================");
		Seller upSeller = sellerDao.findById(1);
		upSeller.setName("Jose");
		sellerDao.update(upSeller);
		System.out.println("Complete update!");
		
		System.out.println("TESTE 5 delete seller \n============================================================");
		sellerDao.deleteById(9);
		System.out.println("Complete delete!");

		DB.closeConnection();
	}

}
