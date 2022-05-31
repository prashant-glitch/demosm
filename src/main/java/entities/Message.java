package entities;

import java.sql.Timestamp;

public class Message extends Entity{

    private int Message_ID;
	private int Account_ID;
	private String Msg;
	private Timestamp Timestamp;
	private String Send_To;
	private int Status;
	public int getMessage_ID() {
		return Message_ID;
	}
	public void setMessage_ID(int message_ID) {
		Message_ID = message_ID;
	}
	public int getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		this.Msg = msg;
	}
	public Timestamp getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.Timestamp = timestamp;
	}
	public String getSend_To() {
		return Send_To;
	}
	public void setSend_To(String send_To) {
		Send_To = send_To;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	@Override
	public String toString() {
		return "Message [Account_ID=" + Account_ID + ", Message_ID=" + Message_ID + ", Send_To=" + Send_To + ", Status="
				+ Status + ", msg=" + Msg + ", timestamp=" + Timestamp + "]";
	}

    
    
}
