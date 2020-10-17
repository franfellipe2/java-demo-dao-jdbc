package model.dao;

import java.sql.Connection;

import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	public static SellerDao createSellerDao(Connection conn) {
		return new SellerDaoJDBC(conn);
	}
	public static DepartmentDao createDepartmentDao(Connection conn) {
		return new DepartmentDaoJDBC(conn);
	}
}
