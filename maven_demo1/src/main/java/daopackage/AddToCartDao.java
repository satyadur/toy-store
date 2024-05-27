package daopackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import dtopackage.AddToCartDto;
import dtopackage.ToyStoreDto;
import dtopackage.UserDto;

public class AddToCartDao {
	public Connection createTableForAddToCart() throws SQLException, IOException {
		DriverManager.registerDriver(new Driver());
		FileInputStream file = new FileInputStream("dbconfig.properties");
		Properties p = new Properties();
		p.load(file);
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/toystore?createDatabaseIfNotExist=true", p);
		Statement s = con.createStatement();
		s.execute(
				"create table if not exists cart (id int,name varchar(45),quantity bigint,price bigint)");
		return con;
	}
	public int saveCartDetails(int id,String name,long quantity,long price) throws SQLException, IOException {
		Connection con = createTableForAddToCart();
		PreparedStatement ps = con.prepareStatement("insert into cart values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setLong(3, quantity);
		ps.setLong(4, price);
		int r = ps.executeUpdate();
		ps.close();
		con.close();
		return r;
	}
	public ArrayList<AddToCartDto> fetchAllToysInCart() throws SQLException, IOException {
		Connection con = createTableForAddToCart();
		PreparedStatement ps = con.prepareStatement("select * from cart");
		ResultSet s = ps.executeQuery();
		ArrayList<AddToCartDto> d=new ArrayList<AddToCartDto>();
	while(s.next()) {
			AddToCartDto t=new AddToCartDto(s.getInt(1), s.getString(2),s.getLong(3),s.getLong(4));
			d.add(t);
			}
	return d;	
	}
	public long fetchSumOfToysPrice() throws SQLException, IOException {
		Connection con = createTableForAddToCart();
		PreparedStatement ps = con.prepareStatement("select sum(price) from cart");
		ResultSet price = ps.executeQuery();
		long pr;
		if(price.next()) {
			pr=price.getLong(1);
			return pr;
		}else {
			return 0;
		}
	}
	public void deleteAddToCartTable() throws SQLException, IOException {
		Connection con = createTableForAddToCart();
		PreparedStatement ps = con.prepareStatement("drop table cart");
		ps.executeUpdate();
	}
}
