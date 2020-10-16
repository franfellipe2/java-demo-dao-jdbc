package aplication;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department dp = new Department(1, "Eletronicos");
		Seller seller = new Seller(21, 2, "Bob", "bob@gmail.com", new Date(), 2000.00, dp);
		System.out.println(seller);
	}

}
