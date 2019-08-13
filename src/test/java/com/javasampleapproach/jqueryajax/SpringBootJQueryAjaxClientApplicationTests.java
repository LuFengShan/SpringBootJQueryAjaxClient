package com.javasampleapproach.jqueryajax;

import com.alibaba.fastjson.JSON;
import com.javasampleapproach.jqueryajax.model.Customer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJQueryAjaxClientApplicationTests {
	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation)).build();
	}

	@Test
	public void customerAll() throws Exception {
		this.mockMvc
				.perform(get("/api/customer/all"))
				.andExpect(status().isOk())
				.andDo(document("rest-web-controller-all"));

		this.mockMvc
				.perform(get("/p2/all2"))
				.andExpect(status().isOk())
				.andDo(document("rest-web-controller-all-2"));
	}

	@Test
	public void customerSave() throws Exception {
		Customer customer = new Customer();
		customer.setFirstname("san");
		customer.setLastname("zhang");
		String jsonString = JSON.toJSONString(customer);
		this.mockMvc
				.perform(
						// 路径
						post("/api/customer/save")
								// 传入的格式类型
								.contentType(MediaType.APPLICATION_JSON_VALUE)
								// 传入的值
								.content(jsonString)
				)
				.andExpect(status().isOk())
				.andDo(document("rest-web-controller-save", requestFields(
						fieldWithPath("firstname").description("名字"),
						fieldWithPath("lastname").description("姓"))));

		Customer customer1 = new Customer();
		customer1.setFirstname("yun");
		customer1.setLastname("zhao");
		String jsonString1 = JSON.toJSONString(customer1);
		this.mockMvc
				.perform(
						// 路径
						post("/p2/save2")
								// 传入的格式类型
								.contentType(MediaType.APPLICATION_JSON_VALUE)
								// 传入的值
								.content(jsonString1)
				)
				.andExpect(status().isOk())
				.andDo(document("rest-web-controller-save-2", requestFields(
						fieldWithPath("firstname").description("名字"),
						fieldWithPath("lastname").description("姓"))));
	}
}
