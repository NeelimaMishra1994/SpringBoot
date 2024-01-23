package ComponentScanning.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		return "practice for 15 mins daily";
	}

}
