package com.a2zcinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.a2zcinema.entity.User;
import com.a2zcinema.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServiceTO;
	
    @RequestMapping("createUser")
    public ModelAndView createEmployee(@ModelAttribute User user) {
        return new ModelAndView("register");
    }
    
    @RequestMapping("editUser")
    public ModelAndView editUser(@RequestParam long id, @ModelAttribute User user) {
    	user = userServiceTO.getUser(id);
        return new ModelAndView("register", "userObject", user);
    }
    
    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        if(user.getId() == 0){ 
        	userServiceTO.createUser(user);
        } else {
        	userServiceTO.updateUser(user);
        }
        return new ModelAndView("redirect:getAllUsers");
    }
    
    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam long id) {
    	userServiceTO.deleteUser(id);
        return new ModelAndView("redirect:getAllUsers");
    }
    
    @RequestMapping(value="getAllUsers", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        List<User> userList = userServiceTO.getAllUsers();
        return new ModelAndView("users", "userList", userList);
    }
    
    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam("searchName") String searchName) {  
    	List<User> userList = userServiceTO.getAllUsers(searchName);
        return new ModelAndView("users", "userList", userList);    	
    }
 
}