package corp.sap.haha.spring.demo.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import corp.sap.hana.spring.demo.Application;
import corp.sap.hana.spring.demo.dto.AddNewClassBody;
import corp.sap.hana.spring.demo.services.IndexService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class IndexServiceTest {

	@Autowired
	IndexService service;

	@Test
	public void testDoAddNewClass() throws Exception {

		AddNewClassBody a = new AddNewClassBody();
		a.setClassName(("11"));
		assert service.doAddNewClass(a).equals(a);
	}

	@Test(expected = Exception.class)
	public void testDoAddNewClassThrow() throws Exception {

		AddNewClassBody a = new AddNewClassBody();
		a.setClassName("throw");
		service.doAddNewClass(a).equals(a);

	}

}
