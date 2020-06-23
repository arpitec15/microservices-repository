package com.employee.springboot.web.controller;   
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.springboot.web.model.*;
import com.employee.springboot.web.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller  
@RequestMapping("/")
public class EmpController {  
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
    @Autowired  
    EmpDao dao;//will inject dao from xml file  
    public static String name;
    
//    Arpit Modification
    
    @GetMapping({"/", "/index"})
    public String index(Model model)  {
        model.addAttribute("user_Id", name);
        logger.debug("index page...");
        return "index";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		

		name = dao.loginUser(user);
//		String name = "Arpit";

		if (name != null) {

			mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
			mv.setViewName("welcome");
			logger.debug("Successfully logged in");
			logger.info("Successfully logged in");
			

		} else {

			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("login");
			logger.debug("Invalid user id");
			logger.info("Invalid user id");
		}

		return mv;

	}

    
    @RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);

		int counter = dao.registerUser(user);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
			logger.debug("User registration successful");
			logger.info("User registration successful");
		} else {
			mv.addObject("msg", "Error- check the console log.");
			logger.warn("User registration unsuccessful");
			logger.info("Registration unsuccessful");
		}

		mv.setViewName("registration");

		return mv;

	}
    
    
//    Arpit modification ends
    
    
    
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Emp());
    	return "empform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Emp emp){  
        dao.save(emp, name);  
        return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){
    	System.out.println("Name is " + name);
        List<Emp> list=dao.getEmployees(name);  
        m.addAttribute("list",list);
        return "viewemp";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editemp/{ticket_id}")  
    public String edit(@PathVariable int ticket_id, Model m){  
        Emp emp=dao.getEmpById(ticket_id);  
        m.addAttribute("command",emp);
        return "empeditform";  
    }  
    
//    arpit
//    @RequestMapping(value="/editemp/{id}")  
//    public String edit(@PathVariable int id, Model m){  
//        Emp emp=dao.getEmpById(id);  
//        m.addAttribute("command",emp);
//        return "empeditform";  
//    }  

//    arpit
    
//    COMMENTING
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
        return "redirect:/viewemp";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{ticket_id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int ticket_id){  
        dao.delete(ticket_id);  
        return "redirect:/viewemp";  
    }   
    
    @RequestMapping("/registration")  
    public String register(Model m){  
//        List<Emp> list=dao.getEmployees();  
//        m.addAttribute("list",list);
        return "registration";  
    }  
    
    @RequestMapping("/login")  
    public String login(Model m){  
//        List<Emp> list=dao.getEmployees();  
//        m.addAttribute("list",list);
        return "login";  
    } 
}  