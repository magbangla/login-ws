package info.martialagbangla.realestate.login.ws.shared;


import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

import org.springframework.stereotype.Component;


@Component
public class WsLogger {
	public static final Logger logger = LogManager.getLogger(WsLogger.class); 
	
}
