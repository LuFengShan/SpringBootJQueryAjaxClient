package com.javasampleapproach.jqueryajax.controller;

import com.javasampleapproach.jqueryajax.message.ResultBean;
import com.javasampleapproach.jqueryajax.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/p2")
public class RestWebController2 {

	@GetMapping(value = "/all2")
	public ResultBean<List<Customer>> getResource() {
		ResultBean<List<Customer>> resultBean = new ResultBean<>(RestWebController.cust);
		resultBean.setMsg("列出所有的人员信息");
		return resultBean;
	}

	@PostMapping(value = "/save2")
	public ResultBean<Customer> postCustomer(@RequestBody Customer customer) {
		ResultBean<Customer> resultBean = new ResultBean<>(customer);
		RestWebController.cust.add(customer);
		resultBean.setMsg("新增加人员");
		return resultBean;
	}
}