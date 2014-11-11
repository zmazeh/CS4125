public interface Driver {
	public void setSpeedAbove(int a);//speed above speed limit (if drives below, use negative)
	public int getVehicleMax(); //returns max speed car can allow
	public Vehicle getVehicle(); //returns Vehicle currently driving
	public void setVehicle(); //sets to random vehicle unless is authority driver
	public void setVehicle(Vehicle car); // sets to specified car
	void setPersonality();
}
