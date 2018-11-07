package se.liu.ida;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfiguration {

	protected String session = null;

	@Bean
	@Primary
	public LoginService loginService() {
		LoginService loginService =  Mockito.mock(LoginService.class);

		/** Add mocked behavior */

		return loginService;
	}

}
