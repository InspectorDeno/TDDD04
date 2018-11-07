package se.liu.ida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValuesController {

	@Autowired
	private LoginService loginService;

	@Autowired
	ValuesController(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login")
	public String login(String userName, String password) {
		return  "OK";
	}

	@RequestMapping("/getid")
	public int getId(String userName) {
		return  123;
	}

	@RequestMapping("/getsession")
	public String getSession(String userName) {
		return "olero123";
	}

	@RequestMapping("/")
	public String index(String userName) {
		return "Hello, you are user #1";
	}

}