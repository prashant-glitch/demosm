package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entities.Message;



public class MessageMapper implements  RowMapper<entities.Message>{
    @Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        
		Message message = new Message();
		message.setMessage_ID(rs.getInt(1));
		message.setAccount_ID(rs.getInt(2));
		message.setMsg(rs.getString(3));
		message.setTimestamp(rs.getTimestamp(4));
		message.setSend_To(rs.getString(5));
		message.setStatus(rs.getInt(6));
		return message;
	}
}
