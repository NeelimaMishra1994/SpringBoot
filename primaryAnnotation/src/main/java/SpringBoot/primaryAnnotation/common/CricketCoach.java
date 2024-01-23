package SpringBoot.primaryAnnotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CricketCoach implements Coach {

	@Override
	public String getWorkoutPlan() {
		// TODO Auto-generated method stub
		return "i am cricket coach";
	}

	public CricketCoach() {
		System.out.println("In constructor:"+getClass().getSimpleName());
	}

}
