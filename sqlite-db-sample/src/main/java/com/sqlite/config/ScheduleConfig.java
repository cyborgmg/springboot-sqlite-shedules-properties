package com.sqlite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.sqlite.entities.UserLogin;
import com.sqlite.repository.UserLoginRepository;

@Configuration
@PropertySource("file:${path.shedule.properties}")
@EnableScheduling
public class ScheduleConfig {
	
	//@Value( "${scheduled.fixeddelay}" )
	//private String fixeddelay;
	
	@Autowired
	private UserLoginRepository userLoginRepository; 
	
	private Integer i=0;
	
	/*@Scheduled(fixedDelayString = "${scheduled.fixeddelay}")
	public void scheduleFixedDelayTask() {
	    System.out.println(" ======================= Fixed delay " + this.fixeddelay );
	}*/
	
	@Scheduled(fixedDelayString = "${scheduled.save}")
	public void scheduleSaveUser() {
		i++;
		userLoginRepository.save(new UserLogin(i, "firstName"+i, "lastName"+i, "userName"+i, "password"+i, "email"+i, "mobile"+i));
	}
	
	@Scheduled(fixedDelayString = "${scheduled.list}")
	public void scheduleListUser() {
		
		userLoginRepository.findAll().forEach(u -> System.out.println(u.toString()) );
	}
	
	@Scheduled(fixedDelayString = "${scheduled.delete}")
	public void scheduleDeleteUser() {
		
		if(userLoginRepository.findAll().size()>20){
			userLoginRepository.deleteAll();
		}// 3744
	}

}
