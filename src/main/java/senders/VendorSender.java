package senders;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import databases.AccountDetails;
import databases.MessaageData;
import entities.Message;

public class VendorSender {
    @Autowired
    AccountDetails accountDetails;
    @Autowired
    MessaageData messagedata;
    private final RestTemplate template = new RestTemplateBuilder().build();
    public void sendBatch(List<Message> messages){
        for (Message message : messages) {
            send(message);
        }
        return;
    }
    public void send(Message message){
        String url = "https://api.gupshup.io/sm/api/v1/msg";
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String apikey = accountDetails.retrieve(message.getAccount_ID());
        System.out.println(apikey);
  
        String mString = URLEncoder.encode("{\"type\":\"text\",\"text\":\""+message.getMsg()+"\"}", StandardCharsets.UTF_8) ;
        System.out.println("URL ENCODED MSG = " + mString);
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url)).header("Accept", "application/json").header("apikey", apikey).header("Content-Type", "application/x-www-form-urlencoded").method(
            "POST", HttpRequest.BodyPublishers.ofString("message="+mString+"&src.name=DRSTRA&channel=whatsapp&source=917834811114&destination="+message.getSend_To())).build();
            System.out.println("Test = " + "message="+mString+"&src.name=DRSTRA&channel=whatsapp&source=917834811114&destination="+message.getSend_To());
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            if (response.statusCode() == HttpStatus.ACCEPTED.value()) {
                message.setStatus(1);
                int r = messagedata.update(message);
            } else {
                message.setStatus(400);
                messagedata.update(message);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        int r = messagedata.update(message);
    }
    
}
