
public class DriverFactory extends AbstractFactory {
	public Vehicle getVehicle(String car){
		return null;
	}
	
	Driver getDriver(String driver){
		if(driver == null)
			return null;
		
		if(driver.equalsIgnoreCase("Authority")){
			return new AuthorityDriver();
		}
		else if(driver.equalsIgnoreCase("Crazy")){
			return new CrazyDriver();
		}
		else if(driver.equalsIgnoreCase("Cautious")){
			return new CautiousDriver();
		}
		
		return null;
			
	}
}
