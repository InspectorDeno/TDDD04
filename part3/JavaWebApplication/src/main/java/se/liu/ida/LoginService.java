package se.liu.ida;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	/**
	 *
	 * Verify the credentials of the user against a file with user names/passwords, and assign a session object as a side effect
	 *
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public boolean login(String userName, String pwd) throws Exception;

	/**
	 *
	 * @param userName
	 * @return
	 */
	public int getId(String userName);

	/**
	 * If and only if the user is logged in, then return a non-null session object
	 * @param userName
	 * @return
	 */
	public String getSession(String userName);
}
