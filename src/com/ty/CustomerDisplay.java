package com.ty;

import java.util.Scanner;

public class CustomerDisplay {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Abstration
		CustomerInterface si= new CustomerImplementation();

		System.out.println("....Welcome customer...\n");
		while(true) {
			System.out.println("1 Coustomer Login\n2 Coustomer Registration\n3 Exit\n");
			System.out.println("Enter your choice..?");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				si.custlogin();
				break;
			case 2:
				si.custregister();
				break;
			case 3:
				System.out.println("Thank you visit again");
				System.exit(0);
			default:
				System.out.println("invalid entry or error");
		   }
		}
	}
}
