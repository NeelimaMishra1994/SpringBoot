package springBoot.setterInjection.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springBoot.setterInjection.common.Coach;

@RestController
public class DemoController {
    //define a property
	private Coach mycoach;

	
	@Autowired
	public void setMycoach(Coach mycoach) {
		this.mycoach = mycoach;
	}
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return mycoach.getDailyWorkout();
		
	}
}
