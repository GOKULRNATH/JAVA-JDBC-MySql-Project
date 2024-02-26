package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerImplementation implements CustomerInterface {

	Scanner sc =new Scanner(System.in);
	@Override
	public void custlogin() {
		// TODO Auto-generated method stub
		
		
		//login
		
		//JDBC Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloombloom","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select name,password from customer");
			ResultSet resultSet=preparedStatement.executeQuery();
			
			System.out.println("Enter user name : ");
			String username=sc.next();
			System.out.println("Enter user password : ");
			String password=sc.next();
			boolean count = true;
			while(resultSet.next()) {
				String uname=resultSet.getString(1);
				String pass=resultSet.getString(2);
				if(username.equals(uname) && password.equals(pass)) {				
						//Menu
					    System.out.println("Welcome to transactions....\n");
						int amount=0;
						boolean exit=true;
						while(exit) {
						System.out.println("1 Amount deposite\n2 Amount withdraw\n3 Check Balance\n4 Exit\n");
						System.out.println("Enter your choice ?");
						int choice=sc.nextInt();		
							switch(choice) {
							case 1:
								System.out.println("Enter the amount to deposit");
								int deposit=sc.nextInt();
								if(0< deposit) {
									amount=amount+deposit;
									System.out.println("Amount deposited successfuly");
									System.out.println("The balance amount is "+amount+"\n");
								}
								else
									System.out.println("Enter amount greater than zero");
								break;
							case 2:
								System.out.println("Enter the amount to Withdraw");
								int withdraw=sc.nextInt();
								if(0<withdraw) {
									amount=amount-withdraw;
									System.out.println("Amount withdraw successfuly");
									System.out.println("The balance amount is "+amount+"\n");
								}
								else
									System.out.println("Enter amount greater than zero");
								break;
							case 3:
								System.out.println("The balance amount is "+amount+"\n");
								break;
							case 4:
								System.out.println("Thank you visit again"+"\n");
								exit=false;
								break;
							default:
								System.out.println("invalid entry or error"+"\n");
								
							 }
							
						}
				}
				else {
					count=false;
				}

			}
			if(count==false)
				System.out.println("Please enter correct username and password."+"\n");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}


	@Override
	public void custregister() {

		System.out.println("...Welcome To Registration...\n");
		System.out.println("Enter your Customer id no : ");
		int id =sc.nextInt();
		System.out.println("Enter your Customer name : ");
		String name =sc.next();
		System.out.println("Enter your Customer Password : ");
		String password =sc.next();
		System.out.println("Enter your age");
		int age=sc.nextInt();
		System.out.println("Enter your Phone no : ");
		int phone=sc.nextInt();
		System.out.println("Enter your Address : ");
		String address=sc.next();
		System.out.println("Enter your Place : ");
		String place=sc.next();
		
		//JDBC Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloombloom","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,password);
			preparedStatement.setInt(4, age);
			preparedStatement.setInt(5, phone);
			preparedStatement.setString(6,address);
			preparedStatement.setString(7, place);
			
			preparedStatement.execute();
			System.out.println("Registration Success.....!\n");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
