package com.flozano.issuewithemptybodies;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfiguration.class)
public class SampleTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testGetSomething() throws Exception {
		this.mockMvc.perform(get("/something")).andExpect(status().isOk());
	}

	@Test
	public void testPostSomething() throws Exception {
		this.mockMvc.perform(post("/something").content("abcd1234")).andExpect(
				status().isCreated());
	}

	@Test
	public void testPostNothing() throws Exception {
		this.mockMvc.perform(post("/something").content("")).andExpect(
				status().isCreated());
	}
}
