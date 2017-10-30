import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
	
	private static Logger log = LogManager.getLogger(Main.class.getName());
	
	public static void main(String[] args){
		
		log.debug("TEST DEBUG");
		log.info("TEST INFO");
		log.warn("TEST WARN");
		log.error("TEST ERROR");
		
	}

}
