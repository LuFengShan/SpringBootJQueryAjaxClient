package com.javasampleapproach.jqueryajax.controller;

import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

	public static List<Customer> cust = new ArrayList<>();

	static {
		cust.add(new Customer("gx", "s"));
		cust.add(new Customer("hd", "w"));
		cust.add(new Customer("py", "w"));
	}

	@GetMapping(value = "/all")
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Customer customer) {
		cust.add(customer);

		// 创建响应对象
		Response response = new Response("Done", customer);
		return response;
	}
}