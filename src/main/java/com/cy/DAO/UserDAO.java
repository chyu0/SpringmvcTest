package com.cy.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cy.model.User;

public class UserDAO extends JdbcDaoSupport {
	public List<User> getUserList(){
		List<User> userlist=new ArrayList<User>();
		String sql="select * from user";
		userlist=getJdbcTemplate().query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int index) throws SQLException {		
					 	User user=new User();
			            user.setId(rs.getInt("id"));
			            user.setName(rs.getString("name"));
			            user.setTel(rs.getString("tel"));
			            return user;
			}	
		});
		return userlist;
	}
	
	public List<User> getUserByName(String name){
		List<User> userlist=new ArrayList<User>();
		String sql="select * from user where name like ?";
		userlist=getJdbcTemplate().query(sql, new Object[]{"%"+name+"%"},new RowMapper<User>(){

			public User mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
	            user.setTel(rs.getString("tel"));
	            return user;
			}
			
		});
		return userlist;
	}
	
	public void commit8(){
		System.out.println("commit8");
	}
	
	public void addUser(User user){
		String sql="insert into user(name,tel) values(?,?)";
		getJdbcTemplate().update(sql, new Object[]{user.getName(),user.getTel()});
		
	}
	
	public void deleteUser(int id){
		String sql="delete from user where id=?";
		getJdbcTemplate().update(sql,id);
	}
	
	public void updateUser(final User user,final int id){
		String sql="update user set name=?,tel=? where id=?";
		getJdbcTemplate().update(sql,new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, user.getName());
				ps.setString(2, user.getTel());
				ps.setInt(3, id);
			}}
);
	}
	
	public List<User> getUserById(int id){
		String sql="select * from user where id=?";
		return getJdbcTemplate().query(sql, new Object[]{id},new RowMapper<User>(){

			public User mapRow(ResultSet rs, int index) throws SQLException {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setTel(rs.getString("tel"));
				return user;
			}

		});
	}
	
	
	public static void main(String[] args) {
		System.out.println("commit2");
	}
}
