package springBoot.beanLifeCycle.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
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
