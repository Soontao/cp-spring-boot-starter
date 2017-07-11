package corp.sap.haha.spring.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.*;

import corp.sap.hana.spring.demo.Application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
// @SpringBootTest(classes = Application.class, webEnvironment =
// WebEnvironment.MOCK)
@WebMvcTest(Application.class)
public class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void homePage() throws Exception {
		this.mvc.perform(get("/")).andExpect(content().string("hi, hcp"));
	}

}
