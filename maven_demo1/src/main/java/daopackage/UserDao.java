package daopackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;
import dtopackage.UserDto;

public class UserDao {
	public Connection createTableForUser() throws SQLException, IOException {
		DriverManager.registerDriver(new Driver());
		FileInputStream file = new FileInputStream("dbconfig.properties");
		Properties p = new Properties();
		p.load(file);
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/toystore?createDatabaseIfNotExist=true", p);
		Statement s = con.createStatement();
		s.execute(
				"create table if not exists user (id int primary key,name varchar(45),phone bigint,email varchar(45) unique,password varchar(45),wallet bigint)");
		return con;
	}

	public int saveUserDetails(UserDto udto) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
		ps.setInt(1, udto.getId());
		ps.setString(2, udto.getName());
		ps.setLong(3, udto.getPhone());
		ps.setString(4, udto.getMailid());
		ps.setString(5, udto.getPassword());
		ps.setInt(6, udto.getWallet());
		int r = ps.executeUpdate();
		return r;
	}

	public UserDto fetchUser(String email) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("select * from user where email=?");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		if (r.next()) {
			UserDto udto = new UserDto(r.getInt(1), r.getString(2), r.getLong(3), r.getString(4), r.getString(5),
					r.getInt(6));
			return udto;
		} else {
			return null;
		}
	}
	public int DeleteUserAccount(String email) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("delete from user where email=?");
		ps.setString(1, email);
		int res = ps.executeUpdate();
		return res;
	}
	public int updateUserName(String name,String mail) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("update user set name=? where email=?");
		ps.setString(1, name);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}
	public int updateUserPhoneNumber(long phone,String mail) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("update user set phone=? where email=?");
		ps.setLong(1, phone);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}
	public int updateUserMailid(String newemail,String mail) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("update user set email=? where email=?");
		ps.setString(1, newemail);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}
	public int updateUserpassword(String password,String mail) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("update user set password=? where email=?");
		ps.setString(1, password);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}
	public int updateUserWallet(long wallet,String mail) throws SQLException, IOException {
		Connection con = createTableForUser();
		PreparedStatement ps = con.prepareStatement("update user set wallet=? where email=?");
		ps.setLong(1, wallet);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}
//	public ResultSet fetchUsersWallet(String mail) throws SQLException, IOException {
//		Connection con = createTableForUser();
//		PreparedStatement ps = con.prepareStatement("select * from user where email=?");
//		ps.setString(1, mail);
//		ResultSet r = ps.executeQuery();
//		return r;
//	}
}
