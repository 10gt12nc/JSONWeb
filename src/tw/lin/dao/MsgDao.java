package tw.lin.dao;

import java.util.List;

import tw.lin.bean.Msg;

public interface MsgDao {

	public void addMsg(Msg Msg);

	public List<Msg> getAllMsg();

}
