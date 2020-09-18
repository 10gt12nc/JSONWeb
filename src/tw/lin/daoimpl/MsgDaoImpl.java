package tw.lin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import tw.lin.bean.Msg;
import tw.lin.dao.MsgDao;
import tw.lin.utils.DBConnectionUtils;

public class MsgDaoImpl implements MsgDao {

	@Override
	public void addMsg(Msg Msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String addSQL = "insert into msg(message) value(?) ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(addSQL);
			ps.setString(1, Msg.getMessage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

	}

	@Override
	public List<Msg> getAllMsg() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Msg> mlist = new ArrayList<>();
		try {
			String sql = "select id, message from msg  order by id desc ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String message = rs.getString(2);
				Msg messagez = new Msg(id, message);
				mlist.add(messagez);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
		return mlist;
	}


}
