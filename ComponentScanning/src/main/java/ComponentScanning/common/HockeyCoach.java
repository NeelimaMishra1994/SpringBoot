package ComponentScanning.common;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		return "Hello i am hockry coach";
	}

}
