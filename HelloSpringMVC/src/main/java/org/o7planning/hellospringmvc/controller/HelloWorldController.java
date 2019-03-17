package org.o7planning.hellospringmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.o7planning.hellospringmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class HelloWorldController {
	
	//su dung bean Person trong Controller
	@Autowired
	@Qualifier("person")
	private Person person;
	//khi go duong dan vao URL: thi no la phuong thuc GET
	@RequestMapping(value= {"/hello","/say/hello","/hello1"}, method= RequestMethod.GET)
    public String hello(Model model) {
        //model.addAttribute("greeting", "Hello Spring MVC");
		//truyen 1 doi tuong 
        model.addAttribute("person",person);
        return "helloworld";
        
    }
	
	//tao requestMapping voi nhieu duong dan khac nhau cung tra ve 1 gia tri
    //cac phuong co gia tri value chi duoc su dung cho phuong thuc GET
	
	//cách khác đe requestMap
	@RequestMapping("/helloDay2")
	public ModelAndView sayHello(HttpServletRequest request) {
		request.setAttribute("person", person);
		return new ModelAndView("helloworld");
		
	}
	//Tât ca duong dan ben trong class duoc bat dau /admin
	
   
}
