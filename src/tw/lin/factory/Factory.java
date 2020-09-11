package tw.lin.factory;

import tw.lin.dao.MsgDao;
import tw.lin.daoimpl.MsgDaoImpl;

public class Factory {

	public static MsgDao getMsgFactory() {
		return new MsgDaoImpl();
	}

}
