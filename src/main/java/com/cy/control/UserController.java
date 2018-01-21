package com.cy.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cy.DAO.UserDAO;
import com.cy.model.User;

@Controller  
@RequestMapping("/user") 
public class UserController {
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request){
		List<User> userlist=userDao.getUserList();
		request.setAttribute("userlist", userlist);
		return "getAll";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,@RequestParam("id")int id){
		userDao.deleteUser(id);
		return getAll(request);
	}
	
	@RequestMapping(params="method=add")
	public String addUser(String name,@RequestParam("tel")String tel,HttpServletRequest request){
		User user=new User();
		user.setName(name);
		user.setTel(tel);
		userDao.addUser(user);
		return getAll(request);
	}
	@RequestMapping(params="method=findUser")
	public String findUser(String name,HttpServletRequest request){
		List<User> userlist=userDao.getUserByName(name);
		request.setAttribute("userlist", userlist);
		return "getAll";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id,HttpServletRequest request){
		List<User> userlist=userDao.getUserById(id);
		request.setAttribute("userlist", userlist);
		return "edit";
	}
	
	//commit7
	public String commit1(){
		System.out.println("commit1");
		return "commit1";
	}
	
	//commit7
	public String commit6(){
		System.out.println("commit6");
		return "commit1";
	}
	
	//commit10
	public String commit10(){
		System.out.println("commit10");
		return "commit10";
	}
	
	@RequestMapping("/update")
	public String update(String name,String tel,int id,HttpServletRequest request){
		User user=new User();
		user.setName(name);
		user.setTel(tel);
		userDao.updateUser(user,id);
		return getAll(request);
	}
	
	
	public static void main(String[] args) {
		System.out.println("commit10");
	}
}
