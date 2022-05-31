package processor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Request.PostformURL;
import databases.MessaageData;
import entities.Message;
import senders.VendorSender;

@Service
public class MessageProcessor {
    Exception exception;

    @Autowired
    ValidationProcessor validator;

    @Autowired
    AuthenticationProcessor authenticator;
    
    @Autowired
    ResponseProcessor responseProcessor;
    
    @Autowired
    MessaageData messageData;
    @Autowired
    VendorSender sender;
    int error_code = -1;

    public Response msgProcessor(PostformURL requestMessage) {
        // test();
        Message message = null;
        try {
            error_code = authenticator.verifyClient(requestMessage);
            System.out.println("Authentication Error Code = " + error_code);
            if (error_code != 0) {
                throw exception;
            }
            System.out.println(requestMessage);
            error_code = validator.isMsgValidate(requestMessage);
            if (error_code != 0) {
                throw exception;
            }
            message = prepareMessage(requestMessage);
            error_code = storeMessage(message);
            if (message.getStatus() == 5) {
                sender.send(message);
                return responseProcessor.responseGenerator(message.getStatus(), message);
            }
        } catch (Exception e) {
            if (error_code < 200) {
                return responseProcessor.responseGenerator(error_code, message);
            } else {
                return responseProcessor.responseGenerator(error_code, requestMessage);
            }
        }
        // manager.store();
        return responseProcessor.responseGenerator(message.getStatus(), message);
    }

    // private void test() {
    // messageDAO.retrieveScheduledMessages().forEach(System.out::println);
    // }
    
    private int storeMessage(Message message) {
        try {
            int r = messageData.insert(message);
            message.setMessage_ID(messageData.retrieveMessageID(message));
            System.out.println("r = " + r);
            if (r == 0) {
                throw exception;
            }
        } catch (Exception e) {
            return 400;
        }
        return 0;
    }

    private Message prepareMessage(PostformURL requestMessage) {
        Message message = new Message();
        message.setAccount_ID(requestMessage.getAccount_ID());
        message.setMsg(requestMessage.getMsg());
        message.setSend_To(requestMessage.getSendTo());
        if (requestMessage.getTime().equals("now")) {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = localDateTime.format(formatter);
            message.setTimestamp(Timestamp.valueOf(LocalDateTime.parse(formatDateTime.replace(" ", "T"))));
            message.setStatus(5);
        } else {
            message.setTimestamp(Timestamp.valueOf(LocalDateTime.parse(requestMessage.getTime().replace(" ", "T"))));
            message.setStatus(0);
        }
        return message;
    }

}
