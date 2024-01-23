package SpringBoot.primaryAnnotation.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class HockeyCoach implements Coach {
	
	public HockeyCoach() {
		System.out.println("In constructor:"+getClass().getSimpleName());
	}


	@Override
	public String getWorkoutPlan() {
		// TODO Auto-generated method stub
		return "I am hockey Coach";
	}

}
