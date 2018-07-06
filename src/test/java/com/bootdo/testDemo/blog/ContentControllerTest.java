package com.bootdo.testDemo.blog;

import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ContentControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	private Subject subjectUnderTest;
	
	protected MockHttpSession mockSession;
	
	@Before
	public void SetupContext(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		//final Authenticate bean = (Authenticate)ctx.getBean("authenticate");
	}
	
	@Test
	public void testRemove() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/blog/bContent/remove").param("id", "121").contentType(MediaType.APPLICATION_JSON_UTF8);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		
		System.out.println("返回内容："+content);
	}
}
