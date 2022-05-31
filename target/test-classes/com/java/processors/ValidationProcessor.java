package processors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Request.PostformURL;

public class ValidationProcessor {
   @Test
   public void testISmessagevalidate()
   {
       assertEquals(0, new ValidatorProcessor().isMessagevalidate(new PostformURL(userName :"admin",password : "admin", msg : "hi", time: "2022-06:05 18:00:00",sendTo: "99999999999")));
   }
    
}
