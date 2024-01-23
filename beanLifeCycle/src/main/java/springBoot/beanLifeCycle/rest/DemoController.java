package springBoot.beanLifeCycle.rest;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springBoot.beanLifeCycle.common.Coach;

@RestController
public class DemoController {
	
	private Coach mycoach;

	
   @Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach) {
		mycoach = theCoach;
		System.out.println("In constructor:"+ getClass().getSimpleName());
	}

	@GetMapping("/workoutplan")
	public String getWorkoutPlan() {
		return mycoach.getWorkoutPlan();
	}
}
