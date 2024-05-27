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

import dtopackage.AdminDto;

public class AdminDao {
	public Connection createTableofAdmin() throws SQLException, IOException {
		DriverManager.registerDriver(new Driver());
		FileInputStream file = new FileInputStream("dbconfig.properties");
		Properties p = new Properties();
		p.load(file);
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/toystore?createDatabaseIfNotExist=true", p);
		Statement s = con.createStatement();
		s.execute(
				"create table if not exists admin (id int primary key,name varchar(45),email varchar(45) unique,password varchar(45))");
		return con;
	}

	public int saveAdminDetails(AdminDto admindto) throws SQLException, IOException {
		Connection con = createTableofAdmin();
		PreparedStatement ps = con.prepareStatement("insert into admin values (?,?,?,?)");
		ps.setInt(1, admindto.getId());
		ps.setString(2, admindto.getName());
		ps.setString(3, admindto.getEmail());
		ps.setString(4, admindto.getPassword());
		int r = ps.executeUpdate();
		return r;
	}

	public AdminDto fetchAdmin(String email) throws SQLException, IOException {
		Connection con = createTableofAdmin();
		PreparedStatement ps = con.prepareStatement("select * from admin where email=?");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		if (r.next()) {
			AdminDto adto = new AdminDto(r.getInt(1), r.getString(2), r.getString(3), r.getString(4));
			return adto;
		} else {
			return null;
		}
	}

	public int updateAdminName(String name, String mail) throws SQLException, IOException {
		Connection con = createTableofAdmin();
		PreparedStatement ps = con.prepareStatement("update admin set name=? where email=?");
		ps.setString(1, name);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}

	public int updateAdminEmail(String newmail, String mail) throws SQLException, IOException {
		Connection con = createTableofAdmin();
		PreparedStatement ps = con.prepareStatement("update admin set email=? where email=?");
		ps.setString(1, newmail);
		ps.setString(2, mail);
		int res = ps.executeUpdate();
		return res;
	}

	public int updateAdminPasswordDao(String password, String email) throws SQLException, IOException {
		Connection con = createTableofAdmin();
		PreparedStatement ps = con.prepareStatement("update admin set password=? where email=?");
		ps.setString(1, password);
		ps.setString(2, email);
		int res = ps.executeUpdate();
		return res;
	}

	public int deleteAdmindb(String mail) throws SQLException, IOException {
		Connection con = createTableofAdmin();
		PreparedStatement ps = con.prepareStatement("delete from admin where email=?");
		ps.setString(1, mail);
		int res = ps.executeUpdate();
		return res;
	}
}
