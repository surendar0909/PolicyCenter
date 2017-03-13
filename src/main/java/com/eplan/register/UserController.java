package com.eplan.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
		
private UserService userService;

@Autowired
UserValidator u_validator;

@Autowired
public void setUserservice(UserService userService) {
	this.userService=userService;
}

@InitBinder
protected void initbinder(WebDataBinder binder) {
	binder.setValidator(u_validator);
}

@RequestMapping(value="/", method= RequestMethod.GET)
public String submit(Model model) {
	return "index";
}

@RequestMapping(value = "/users/list", method = RequestMethod.GET)
public String showAllUsers(ModelMap model) {
	List<UserModel> userlist=userService.listAllUsers();
	model.addAttribute("allusers", userlist);
	return "user/userview";

}

@RequestMapping(value = "/users/register", method = RequestMethod.GET)
public String showRegister(Model model) {
	model.addAttribute("user", new UserModel());
	return "user/register";

}


@RequestMapping(value="/users/adduser", method= RequestMethod.POST)
public String adduser(@ModelAttribute("user") @Validated UserModel user, BindingResult result, Model model) {
	if (result.hasErrors()) {
        return "user/register";
    }
	System.out.println(user.getUsername());
	userService.saveOrUpdate(user);
	 List<UserModel> all=userService.listAllUsers();
	 model.addAttribute("alluser", all);
	return "user/userview";
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public String updateUser(@PathVariable("id") Long id, Model model) {
	UserModel user = userService.findUserById(id);
	model.addAttribute("user", user);
	System.out.println(user.getFirstname());
	return "user/register";

}

@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
public String deleteUser(@PathVariable("id") Long id, Model model) {
	userService.deleteUser(id);
	List<UserModel> all=userService.listAllUsers();
	 model.addAttribute("alluser", all);
	return "user/userview";
}

}
