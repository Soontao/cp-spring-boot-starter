package corp.sap.hana.spring.demo.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cloud.crypto.keystore.api.KeyStoreService;

import corp.sap.hana.spring.demo.dto.AddNewClassBody;
import corp.sap.hana.spring.demo.services.IndexService;

@RestController("/v1/api")
public class IndexContoller {

	@Autowired
	IndexService indexService;

	@Autowired
	KeyStoreService keyStoreService;

	@PostMapping("newClass")
	public AddNewClassBody newClass(@RequestBody AddNewClassBody i) throws Exception {
		return indexService.doAddNewClass(i);
	}

	@GetMapping("listKeyStoreNames")
	public Set<String> listKeyStoreNames() {
		return keyStoreService.getKeyStoreNames();
	}

}
