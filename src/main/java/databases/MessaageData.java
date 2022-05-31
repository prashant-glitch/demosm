package databases;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import RowMapper.MessageMapper;
import entities.Entity;

@Component
public class MessaageData implements DBManager {
    @Autowired
    JdbcTemplate template;

    @Override
    public int insert(Entity entity)
    {
        String querry = "insert into Message (Account_ID, MSG, scheduled_time, send_to,status)value(?,?,?,?,?)";
        int res = template.update(querry,((Message)entity).getAccount_ID(),((Message)entity).getMsg(),((Message)entity).getTimestamp(),((Message)entity).getSend_To(),((Message)entity).getStatus());
        return res;
    }

    @Override
    public int update(Entity entity)
    {
        String querry = "update Message set status = ? where Message_ID= ?";
        int res = template.update(querry,((Message)entity).getStatus(), ((Message)entity).getMessage_ID());
        return res;
    }

    @Override
    public int delete(Entity entity) {
        return 0;
    }
    public List<Message> retrieveScheduledMessages() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = localDateTime.format(formatter);
        System.out.println(formatDateTime);
        String querry = "select * from Message where Scheduled_Time <= '" + Timestamp.valueOf(LocalDateTime.parse(formatDateTime.replace(" ", "T"))).toString().replace(".0", "") +  "' and status = 0";
        RowMapper<Message> mapper = new MessageMapper();
        List<Message> messages = template.query(querry, mapper);
        return messages;
    }
    public int retrieveMessageID(Entity entity){
        String query = "select * from Messages where Scheduled_Time = '" + ((Message) entity).getTimestamp() + "' and Account_ID = " + ((Message) entity).getAccount_ID();
        RowMapper<Message> mapper = new MessageMapper();
        Message message = template.queryForObject(query, mapper);
        return message.getAccount_ID();
    }

}
