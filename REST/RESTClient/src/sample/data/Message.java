package sample.data;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	private String msg;
	private List<MessageListItem> mli;
	
	public Message() {
		mli = new ArrayList<MessageListItem>();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<MessageListItem> getMli() {
		return mli;
	}

	public void setMli(List<MessageListItem> mli) {
		this.mli = mli;
	}
	
	

}
