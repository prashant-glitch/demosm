package processor;

import com.error.Errorfiles;

import response.Response;
import org.springframework.stereotype.Service;

import Request.PostformURL;
import entities.Message;
import response.MessageErrorresponse;

@Service
public class ResponseProcessor {
    public Response responseGenerator(int errorCode, PostformURL request){
        String error = Errorfiles.codeToString(errorCode);
        MessageErrorresponse response = new MessageErrorresponse("N/A", request.getSendTo(), request.getMsg(), request.getTime(), "ERROR", error);
        System.out.println(response);
        return response;
    }
    public Response responseGenerator(int errorCode, Message message){
        String error = Errorfiles.codeToString(errorCode);
        Response response = null;
        if (errorCode <= 10) {
            response = new Response(Integer.toString(message.getMessage_ID()), message.getSend_To(), message.getMsg(), message.getTimestamp().toString(), error);
        }
        return response;
    }
 
    
}
