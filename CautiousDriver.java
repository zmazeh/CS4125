
public class CautiousDriver implements Driver {
	int SpeedAbove = -10; //drives 10 below limit
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
		System.out.println("Personality = Cautious");
	}
}
