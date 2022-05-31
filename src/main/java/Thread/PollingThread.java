package Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import databases.MessaageData;
import senders.VendorSender;

@Service
public class PollingThread implements Runnable{
    @Autowired
    MessaageData messagedata;
    @Autowired
    VendorSender sender;
    public PollingThread() {
        // run();
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                sender.sendBatch(messagedata.retrieveScheduledMessages());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
