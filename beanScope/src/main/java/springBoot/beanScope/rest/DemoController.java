package springBoot.beanScope.rest;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springBoot.beanScope.common.Coach;

@RestController
public class DemoController {
	
	private Coach mycoach;
	private Coach anotherCoach;

	
	
   @Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach,@Qualifier("cricketCoach")Coach theanotherCoach) {
		mycoach = theCoach;
		anotherCoach = theanotherCoach;
		System.out.println("In constructor:"+ getClass().getSimpleName());
	}

	@GetMapping("/workoutplan")
	public String getWorkoutPlan() {
		return mycoach.getWorkoutPlan();
	}
	@GetMapping("/check")
	public String getcheckplan() {
		return "Comparing beans : myCoach == another coach"+ (mycoach == anotherCoach);
	}
}
