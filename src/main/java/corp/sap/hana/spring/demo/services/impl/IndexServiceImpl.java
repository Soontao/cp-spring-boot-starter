package corp.sap.hana.spring.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.cloud.crypto.keystore.api.KeyStoreService;

import corp.sap.hana.spring.demo.dto.AddNewClassBody;
import corp.sap.hana.spring.demo.services.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	KeyStoreService keyStoreService;

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
