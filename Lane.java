
public class FastCar implements Vehicle{
	int MaxSpeed = 200;
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
		System.out.println("fast car created.");
	}
}
