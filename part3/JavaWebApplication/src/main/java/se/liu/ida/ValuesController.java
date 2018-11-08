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
		
		if(loginService.login(userName, password)) {
			return  "OK";
		}
		return "NO";
	}

	@RequestMapping("/getid")
	public int getId(String userName) {
		return  loginService.getId(userName);
	}

	@RequestMapping("/getsession")
	public String getSession(String userName) {
		return loginService.getSession(userName);
	}

	@RequestMapping("/")
	public String index(String userName) {
		return "Hello, you are user #1";
	}

}