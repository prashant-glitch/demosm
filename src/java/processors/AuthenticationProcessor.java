package processors;

import org.junit.Test;

import Request.PostformURL;

public class AuthenticationProcessor {
    @Test
    public void testverifyclient()
    {
        assertEquals(0, new AuthenticationProcessor().verifyclient(new PostformURL(userName : "admin", password :"admin", msg : null, time : null, sendTo : null)));
    }
}
