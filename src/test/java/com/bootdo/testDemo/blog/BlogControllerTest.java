package com.bootdo.testDemo.blog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BlogControllerTest {

	private MockMvc mock;

	@Autowired
	private WebApplicationContext wac;

	// 此方法在每个方法执行前都会执行一次。
	@Before 
	public void SetupContext() {
		// 初始化MockMvc对象
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testOpenLIst() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("type", "article");
		params.add("limit", "10");
		params.add("offset", "0");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/blog/open/list").params(params)
				.contentType(MediaType.APPLICATION_JSON_UTF8).header("session", "");

		MvcResult mvcResult = mock.perform(requestBuilder).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		
		System.out.println("返回状态："+status);
		System.out.println("返回结果："+content);
	}
	
}
