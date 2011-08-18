package DAOImpl;

import common.BaseDAO;

public class UserDAOImpl implements DAO.UserDAO {

	BaseDAO baseDAO;

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public void putIp(String ip) {
		// TODO Auto-generated method stub
		baseDAO.insert("Visitor.insertIp", ip);
	}

}
