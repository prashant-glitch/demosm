package processor;

import java.time.LocalDateTime;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import org.springframework.stereotype.Service;

import Request.PostformURL;

@Service
public class ValidationProcessor {
    PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
	private Exception Exception;
	public int isMsgValidate(PostformURL message) {
		if (message.getMsg().isEmpty()) {
			return 413;
		}
		if (!message.getTime().isEmpty()) {
			if (message.getTime().equals("now")) {
			}
			else if (!isTimeValid(message.getTime())) {
				return 414;
			}
		} else {
			return 414;
		}
		if (!phoneNumberUtil.isPossibleNumber(message.getSendTo(),"IN")) {
			return 415;
		}
		return 0;
	}
	private boolean isTimeValid(String time) {
		try {
			LocalDateTime scheduledTime = LocalDateTime.parse(time.replace(" ", "T"));
			if (scheduledTime.isBefore(LocalDateTime.now())) {
				throw Exception;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}  
}
