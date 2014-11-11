
public interface Vehicle {
	
	public int getDistanceBehind(); //gets distance of car closest behind it
	public int getDistanceInfront(); //gets distance of car closest infront of it
	public void setPosition(int a); //sets position on road (in this case one lane)
	public int getMaxSpeed();
	public int getPosition();
	void create();
}
