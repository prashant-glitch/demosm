package REST_Controllers;



import Request.PostformURL;
import processor.MessageProcessor;

import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class RestEndpoint {
     private static final  Logger LOGGER = LogManager.getLogger(RestEndpoint.class);
     @Autowired
     private MessageProcessor messageProcessor;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/send", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public response.Response sendMesssage(PostformURL postformurl)
    {
        LOGGER.info("started New Send Message Request");

        return messageProcessor.msgProcessor(postformurl);
    }
}
