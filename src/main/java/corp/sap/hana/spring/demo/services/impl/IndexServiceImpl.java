package corp.sap.hana.spring.demo.services.impl;

import org.springframework.stereotype.Service;

import corp.sap.hana.spring.demo.dto.AddNewClassBody;
import corp.sap.hana.spring.demo.services.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

	/* (non-Javadoc)
	 * @see corp.sap.hana.spring.demo.services.IndexService#doAddNewClass(corp.sap.hana.spring.demo.dto.AddNewClassBody)
	 */
	@Override
	public AddNewClassBody doAddNewClass(AddNewClassBody body) throws Exception {
		if (body.getClassName().equals("throw")) {
			throw new Exception("business logic error");
		}
		return body;
	}

}
