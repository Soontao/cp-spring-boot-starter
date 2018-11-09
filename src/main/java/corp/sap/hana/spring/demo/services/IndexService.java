package corp.sap.hana.spring.demo.services;

import org.springframework.stereotype.Service;

import corp.sap.hana.spring.demo.dto.AddNewClassBody;

@Service
public class IndexService {

	public AddNewClassBody doAddNewClass(AddNewClassBody body) throws Exception {
		if (body.getClassName().equals("throw")) {
			throw new Exception("business logic error");
		}
		return body;
	}

}
