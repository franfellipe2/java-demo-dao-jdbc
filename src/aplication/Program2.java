package aplication;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		DepartmentDao dao = DaoFactory.createDepartmentDao(conn);

		System.out.println("TESTE 1 inserir departamento \n======================================================");
		Department dep = new Department(null, "livros");
		dao.insert(dep);
		System.out.println("Done! Insert: " + dep);
		System.out.println();

		System.out.println("TESTE 2 deletar departamento \n======================================================");
		dao.deleteById(dep.getId());
		System.out.println("Done! deleteById: " + dep);
		System.out.println();

		System.out.println("TESTE 3 buscar por id \n======================================================");
		Department getDep = dao.findById(20);
		System.out.println("Done! findById: " + getDep);
		System.out.println();

		System.out.println("TESTE 4 atualizar      \n======================================================");
		getDep.setName("Brinquedos");
		dao.update(getDep);
		System.out.println("Done! Update: " + getDep);
		System.out.println();

		System.out.println("TESTE 5 Listar todos     \n======================================================");
		List<Department> list = dao.findAll();
		list.forEach(System.out::println);
		System.out.println();

		DB.closeConnection();
	}

}
