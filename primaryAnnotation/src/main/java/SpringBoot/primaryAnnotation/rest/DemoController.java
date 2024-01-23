package SpringBoot.primaryAnnotation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot.primaryAnnotation.common.Coach;
@RestController
public class DemoController {
	
	private Coach mycoach;

	@Autowired
	public void setMycoach(@Qualifier("tennisCoach")Coach mycoach) {
		this.mycoach = mycoach;
	}

	@GetMapping("/workoutplan")
	public String getWorkoutPlan() {
		return mycoach.getWorkoutPlan();
	}
	
}
