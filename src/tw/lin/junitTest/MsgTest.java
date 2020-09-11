package tw.lin.junitTest;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;
import tw.lin.bean.Msg;
import tw.lin.dao.MsgDao;
import tw.lin.factory.Factory;

public class MsgTest {

	@Test
	public void addMsgTest() {
		String message = "安安,你好~";

		MsgDao msgdao = Factory.getMsgFactory();
		Msg fuckingMsg = new Msg();
		fuckingMsg.setMessage(message);
		msgdao.addMsg(fuckingMsg);

	}

	@Test
	public void getAllMsgTest() {

		MsgDao msgdao = Factory.getMsgFactory();
		List<Msg> mlist = msgdao.getAllMsg();

		System.out.println(mlist.toString());

	}

	@Test
	public void JSONArray() {

		MsgDao msgdao = Factory.getMsgFactory();
		List<Msg> mlist = msgdao.getAllMsg();

		JSONArray json = JSONArray.fromObject(mlist);

		System.out.println(json.toString());



	}

	
	//使用 Jackson 完成 json 和 Java Object 互相轉換	
	//https://kucw.github.io/blog/2020/6/java-jackson/	
	
	@Test
	public void jackSON() {

		MsgDao msgdao = Factory.getMsgFactory();
		List<Msg> mlist = msgdao.getAllMsg();

		ObjectMapper om = new ObjectMapper();

		try {
			
			// List<> 轉 json
			String mlistjson = om.writeValueAsString(mlist);
			System.out.println(mlistjson);

			System.out.println("------------");
			
			// json 轉  Object 
			/*
			json轉換異常 , 返回的是Array[{ }]。在將json轉換成物件時，
			使用Object[].class替換Object.class，
			即把json段轉換成這個物件的陣列，而不僅僅是一個物件。
			*/
			//https://www.itread01.com/content/1546892822.html
			
			//Msg msg = om.readValue(mlistjson, Msg.class);
			
			List<Msg> msgList = om.readValue(mlistjson, new TypeReference<List<Msg>>() {});
			
			Iterator<Msg> imsgList=msgList.iterator();
			while(imsgList.hasNext()) {
				System.out.println(imsgList.next());
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void gSON() {

		MsgDao msgdao = Factory.getMsgFactory();
		List<Msg> mlist = msgdao.getAllMsg();

		Gson gson = new Gson();
		String mlistgson = gson.toJson(mlist);
		System.out.println(mlistgson);

		System.out.println("------fromJson------");

		List<Msg> msgList = gson.fromJson(mlistgson, new TypeToken<List<Msg>>() {}.getType());
		
		Iterator<Msg> imsgList=msgList.iterator();
		
		while(imsgList.hasNext()) {
			System.out.println(imsgList.next());
		}

	}

}
