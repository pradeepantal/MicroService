package com.microservice.demo.web;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.microservice.demo.ContactServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContactServiceApplication.class)
@WebAppConfiguration
public class ContactServiceIntegrationTest {

	
	private MockMvc mockMvc;

	private HttpMessageConverter<?> mappingJackson2HttpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	
	@Test
	public void shouldGetContactsByUserId() throws Exception {
		mockMvc.perform(get("/brunowei/contacts")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].userId", is("brunowei")))
				.andExpect(jsonPath("$[0].firstName", is("Dave")))
				.andExpect(jsonPath("$[0].lastName", is("Syer")))
				.andExpect(jsonPath("$[0].email", is("dave@email.com")))

				.andExpect(jsonPath("$[1].userId", is("brunowei")))
				.andExpect(jsonPath("$[1].firstName", is("Phil")))
				.andExpect(jsonPath("$[1].lastName", is("Webb")))
				.andExpect(jsonPath("$[1].email", is("phil@email.com")))

				.andExpect(jsonPath("$[2].userId", is("brunowei")))
				.andExpect(jsonPath("$[2].firstName", is("Juergen")))
				.andExpect(jsonPath("$[2].lastName", is("Hoeller")))
				.andExpect(jsonPath("$[2].email", is("juergen@email.com")))

				.andExpect(jsonPath("$[3].userId", is("brunowei")))
				.andExpect(jsonPath("$[3].firstName", is("Bruno")))
				.andExpect(jsonPath("$[3].lastName", is("Wei")))
				.andExpect(jsonPath("$[3].email", is("bruno@email.com")));
	}

}
