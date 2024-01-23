package ComponentScanning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ComponentScanning.common.Coach;

@RestController
public class DemoController {
	
	//define a private field for dependency
	
	private Coach myCoach;
	
	//define a constructor for dependency injection
		@Autowired
		public DemoController(@Qualifier("hockeyCoach") Coach theCoach) {
			myCoach=theCoach;	
	}
	
	@GetMapping("/getDailyworkout")
	 public String getDailyworkout() {
		return myCoach.getDailyworkout();
		 
	 }
	
	

}
