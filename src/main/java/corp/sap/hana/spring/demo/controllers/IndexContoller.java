package corp.sap.hana.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import corp.sap.hana.spring.demo.dto.AddNewClassBody;
import corp.sap.hana.spring.demo.services.IndexService;

@RestController("/v1/api")
public class IndexContoller {

	@Autowired
	IndexService indexService;

	@PostMapping("newClass")
	public AddNewClassBody newClass(@RequestBody AddNewClassBody i) throws Exception {
		return indexService.doAddNewClass(i);
	}

}
