package se.liu.ida;

import static org.mockito.Mockito.*;
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
		LoginService loginService =  mock(LoginService.class);
		
		when(loginService.getId(anyString())).thenReturn(1234);
		
		when(loginService.login("olero", "valid_password")).thenAnswer(
				invocation -> {
					session = "olero123";
					return true;
				});
		when(loginService.getSession(anyString())).thenAnswer(invocation -> session);

		return loginService;
	}

}
