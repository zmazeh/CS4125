import java.util.ArrayList;
import java.util.Random;

//Lanes can only have one direction
// They store Cars while they are traveling from their point A to point B
public class Lane {
	ArrayList<Vehicle> fill = new ArrayList<Vehicle>();
	String side;
	Lane() {

	}

	// adds random vehicles to lane of a specified direction
	Lane(String str, int numOfCars) {
		Random generator = new Random();
		if (numOfCars > 4) {
			System.err.println("Too many cars in lane");
		} else if (numOfCars < 1) {
			System.err.println("Invalid input for number of cars in lane: "
					+ numOfCars);
		} else {
			for (int i = 0; i < numOfCars; i++) {
				int randomInt = generator.nextInt(100);
				if (randomInt % 2 == 0) {
					Vehicle a = new SlowCar();
					fill.add(a);
				} else {
					Vehicle b = new FastCar();
					fill.add(b);
				}
			}
		}
	}

}
