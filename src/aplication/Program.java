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

		// TESTE 1 ===========================================
		Seller s = DaoFactory.createSellerDao(conn).findById(4);
		System.out.println(s);

		// TESTE 2 ===========================================
		//List<Seller> sellers = DaoFactory.createSellerDao(conn).findByDeparmentId(2);
		List<Seller> sellers = DaoFactory.createSellerDao(conn).findByDeparment(new Department(2, null));
		for (Seller se : sellers) {
			System.out.println(String.format("%s[%d,%s, %s, %.2f] - em: (%s(%d))", /**/
					se.getName(), /**/
					se.getId(), /**/
					se.getEmail(), /**/
					se.getBirthDate(), /**/
					se.getBaseSalary(), /**/
					se.getDepartment().getName(), /**/
					se.getDepartment().getId()));
		}

		DB.closeConnection();
	}

}
