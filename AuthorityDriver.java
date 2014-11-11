
public class AuthorityDriver implements Driver {
	int SpeedAbove = 0; //drives exactly the speed limit by default
	Vehicle auto;
	public void setSpeedAbove(int a){
		SpeedAbove = a;
	}
	public int getVehicleMax(){
		return auto.getMaxSpeed();
	}
	public Vehicle getVehicle(){
		return auto;
	}
	public void setVehicle(){
		//TODO
	}
	public void setVehicle(Vehicle car){
		auto = car;
	}
	
		
	public void setPersonality(){
		System.out.println("Personality = Authority");
	}
}
