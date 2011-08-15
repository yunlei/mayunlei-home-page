package serviceImpl;

import DAO.UserDAO;
import service.UserService;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;
	@Override
	public void putIp(String ip) {
		// TODO Auto-generated method stub
		userDAO.putIp(ip);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
