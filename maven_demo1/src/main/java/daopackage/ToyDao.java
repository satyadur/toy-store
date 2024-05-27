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

import dtopackage.ToyStoreDto;
import dtopackage.UserDto;

public class ToyDao {
	public Connection createTableForToys() throws SQLException, IOException {
		DriverManager.registerDriver(new Driver());
		FileInputStream file = new FileInputStream("dbconfig.properties");
		Properties p = new Properties();
		p.load(file);
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/toystore?createDatabaseIfNotExist=true", p);
		Statement s = con.createStatement();
		s.execute(
				"create table if not exists toys (id int primary key,name varchar(45),price bigint,quantity bigint,email varchar(45))");
		return con;
	}

	public int saveToyDetails(ToyStoreDto tdto) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("insert into toys values (?,?,?,?,?)");
		ps.setInt(1, tdto.getId());
		ps.setString(2, tdto.getToyName());
		ps.setLong(3, tdto.getPrice());
		ps.setLong(4, tdto.getQuantity());
		ps.setString(5, tdto.getEmailToy());
		int r = ps.executeUpdate();
		return r;
	}

	public ArrayList<ToyStoreDto> fetchToyDetails(String email) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("select * from toys where email=?");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		ArrayList<ToyStoreDto> t = new ArrayList<ToyStoreDto>();
		while (r.next()) {
			ToyStoreDto toy = new ToyStoreDto(r.getInt(1), r.getString(2), r.getLong(3), r.getLong(4), r.getString(5));
			t.add(toy);
		}
		return t;
	}

	public int toynameUpdate(String newToyName,int id,String mail) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("update toys set name=? where id=? and email=?");
		ps.setString(1, newToyName);
		ps.setInt(2, id);
		ps.setString(3, mail);
		int r=ps.executeUpdate();
		if(r>0) {
			 return r; 
		 }else {
			 return -1;
		 }
	}

	public int toyPriceUpdateinDB(int price,int id,String mail) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("update toys set price=? where id=? and email=?");
		ps.setLong(1, price);
		ps.setInt(2, id);
		ps.setString(3, mail);
		 int r = ps.executeUpdate();
		 if(r>0) {
			 return r; 
		 }else {
			 return -1;
		 }	
	}
	public int toyQuantityUpdateinDB(long quantity,int id,String mail) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("update toys set quantity=? where id=? and email=?");
		ps.setLong(1, quantity);
		ps.setInt(2, id);
		ps.setString(3, mail);
		 int r = ps.executeUpdate();
		 if(r>0) {
			 return r; 
		 }else {
			 return -1;
		 }	
	}
	public ArrayList<ToyStoreDto> fetchAllToys() throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("select * from toys");
		ResultSet s = ps.executeQuery();
		ArrayList<ToyStoreDto> d=new ArrayList<ToyStoreDto>();
//		ToyStoreDto t;
		while(s.next()) {
			ToyStoreDto t=new ToyStoreDto(s.getInt(1), s.getString(2), s.getLong(3), s.getLong(4), s.getString(5));
			d.add(t);
		}
		s.close();
		con.close();
		return d;
	}
	public int changingQuantityGivenByCoustomer(long quantity,int id) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("update toys set quantity=? where id=?");
		ps.setLong(1, quantity);
		ps.setInt(2, id);
		 int r = ps.executeUpdate();
		 if(r>0) {
			 return r; 
		 }else {
			 return -1;
		 }	
	}
	public ToyStoreDto referenceForChangingWallet(int id) throws SQLException, IOException {
		Connection con = createTableForToys();
		PreparedStatement ps = con.prepareStatement("select * from toys where id=?");
		ps.setInt(1, id);
		ResultSet s = ps.executeQuery();
		if(s.next()) {
			ToyStoreDto t=new ToyStoreDto(s.getInt(1), s.getString(2), s.getLong(3), s.getLong(4), s.getString(5));
			return t;
		}else {
			return null;
		}
	}
}
