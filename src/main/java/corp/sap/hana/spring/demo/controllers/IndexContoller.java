package corp.sap.hana.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cloud.crypto.keystore.api.KeyStoreService;

import corp.sap.hana.spring.demo.services.IndexService;

@RestController()
@RequestMapping("/api/v1")
public class IndexContoller {

	@Autowired
	IndexService indexService;

	@Autowired
	KeyStoreService keyStoreService;

	@GetMapping("available")
	public Boolean available() {
		return true;
	}

}
