package SpringBoot.primaryAnnotation.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	public TennisCoach() {
		System.out.println("In constructor:"+getClass().getSimpleName());
	}

	@Override
	public String getWorkoutPlan() {
		// TODO Auto-generated method stub
		return "I am tennnis coach";
	}

}
