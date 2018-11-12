package corp.sap.hana.spring.demo.services;

import corp.sap.hana.spring.demo.dto.AddNewClassBody;

public interface IndexService {

	AddNewClassBody doAddNewClass(AddNewClassBody body) throws Exception;

}