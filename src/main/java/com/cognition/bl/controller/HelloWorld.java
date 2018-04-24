package com.cognition.bl.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognition.bl.dao.EmpRepository;
import com.cognition.bl.domain.Emp;

@Controller
@EnableAutoConfiguration
public class HelloWorld {
	
	@Autowired
	EmpRepository empRepository;

	   @RequestMapping("/hello/{orderNo}")
	    @ResponseBody
	    String home(@PathVariable("orderNo")String orderNo) {
		  List<Emp> list = empRepository.queryName2(orderNo);
	        return "Hello ,spring boot!"+orderNo+"  "+list.size();
	    }
}
