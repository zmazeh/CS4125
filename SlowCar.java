
public class SlowCar implements Vehicle {
	
	int MaxSpeed = 80;
	int CurrentPos;
	
	public int getDistanceBehind(){
		//TODO
		return 0;
	}
	public int getDistanceInfront(){
		//TODO
		return 0;
	}
	public void setPosition(int a){
		CurrentPos = a;
	}
	
	public int getPosition(){
		return CurrentPos;
	}
	
	public int getMaxSpeed(){
		return MaxSpeed;
	}
		public void create(){
		System.out.println("Slow Car created");	
	}
}
