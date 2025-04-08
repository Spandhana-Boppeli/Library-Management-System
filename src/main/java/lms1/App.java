package lms1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		while(true)
		{
			System.out.println("Select option");
			System.out.println("1. Add book");
			System.out.println("2.Display all book");
			System.out.println("3.Display books by Author");
			System.out.println("4.Display book by title");
			System.out.println("5.update book price by id");
			System.out.println("6.Delete book by id");
			System.out.println("7.Update quantity by id");
			System.out.println("8.Exit");
			System.out.println("9.Search by title");
			
			int key=s.nextInt();
		
			switch(key)
			{
			case 1:
				addBook();
				break;
			case 2:
				displayAllBooks();
				break;
			case 3:
				displayBookByAuthor();
				break;
			case 4:
				displayBookByTitle();
				break;
			case 5:
				updateBookPriceById();
				break;
			case 6:
				deleteBookById();
				break;
			case 7:
				updateQuantityById();
				break;
			case 8:
				System.exit(0);
				break;
			case 9:
				searchByName();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
				
			}
		}
		
	}
	private static void addBook() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			
				PreparedStatement ps=con.prepareStatement("insert into book values(?,?,?,?,?)");
				
				System.out.println("Enter Id");
				ps.setInt(1, s.nextInt());
				
				System.out.println("Enter Title");
				ps.setString(2, s.next());
				
				
				System.out.println("Enter Price");
				ps.setDouble(3, s.nextDouble());
				
				System.out.println("Enter Author Name");
				ps.setString(4, s.next());
				
				System.out.println("Enter Quantity");
				ps.setInt(5, s.nextInt());
				
				
				int row=ps.executeUpdate();
				System.out.println(row +":row inserted");
				
				ps.close();
				con.close();
				
				
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	private static void searchByName() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			PreparedStatement ps=con.prepareStatement("select * from book where title like ?");
			System.out.println("Type Here to Search");
			ps.setString(1, s.next()+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" ");
				System.out.println(rs.getString(2)+" ");
				System.out.println(rs.getDouble(3)+" ");
				System.out.println(rs.getString(4)+" ");
				System.out.println(rs.getInt(5));
				
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	private static void updateQuantityById() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			 
			PreparedStatement ps=con.prepareStatement("update book set quantity=? where id=?");
			System.out.println("enter Quantity");
			ps.setInt(1, s.nextInt());
			System.out.println("enter id");
			ps.setInt(2, s.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row);
			
			ps.close();
			con.close();	
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	private static void deleteBookById() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			
			PreparedStatement ps=con.prepareStatement("delete from book where id=?");
			System.out.println("Enter book By id");
			ps.setInt(1,s.nextInt());
		   int row=ps.executeUpdate();
			System.out.println(row);
			
			ps.close();
			con.close();	
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	private static void updateBookPriceById() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			PreparedStatement ps=con.prepareStatement("update book set Quantity =? where id=?");
			ps.setDouble(1, s.nextDouble());
			System.out.println("Enter price");
			ps.setInt(2, s.nextInt());
			System.out.println("Enter Id");
			int row=ps.executeUpdate();
			System.out.println(row);
			
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static void displayBookByTitle() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			PreparedStatement ps=con.prepareStatement("select *from book where title=?");
			ps.setString(1, s.next());
			System.out.println("Enter Title Name");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" ");
				System.out.println(rs.getString(2)+" ");
				System.out.println(rs.getDouble(3)+" ");
				System.out.println(rs.getString(4+" "));
				System.out.println(rs.getInt(5));
				
			}
			rs.close();
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	private static void displayBookByAuthor() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			PreparedStatement ps=con.prepareStatement("select *from book where author=?");
			ps.setString(1, s.next());
			System.out.println("Enter Author Name");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" ");
				System.out.println(rs.getString(2)+" ");
				System.out.println(rs.getDouble(3)+" ");
				System.out.println(rs.getString(4+" "));
				System.out.println(rs.getInt(5));
				
			}
			rs.close();
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	private static void displayAllBooks() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://locolhost:3306/library","root","root");
			PreparedStatement ps=con.prepareStatement("select * from book");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" ");
				System.out.println(rs.getString(2)+" ");
				System.out.println(rs.getDouble(3)+" ");
				System.out.println(rs.getString(4+" "));
				System.out.println(rs.getInt(5));
				
			}
			rs.close();
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
