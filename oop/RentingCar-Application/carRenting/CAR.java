package carRenting;

public abstract class CAR {
	//Constructors.
	public CAR() {}
	public CAR(char carType) {System.out.println(carType+" Type Car Features are Listed Bellow:\n");}
	
	//Abstract Methods.
	public abstract void getModel();
	public abstract void getFeatures();
	
	//Non Abstract Methods.
	public void getInfo() {System.out.println("General Information About Company.");}
	public void getCommon() {System.out.println("-Air Conditioner.\n"+ "-Multimedia Player.\n"+ "-Hill Start Assist.");}
	
	//Encapsulation Usage.
	private double rentPrice;
	// Getter.
	public double getRentPrice() {return rentPrice;} 
	// Setter.
	public void setRentPrice(double p) {
	  this.rentPrice = p;
	  System.out.println("-Rent Price per Day: "+p);
	}
	
	//Overriding Usage.
	public double rentPriceCalculate(int day) {return rentPrice*day;}
	
	public float fuelLiter;
	public float getFuelPrice(float distance) {
		return distance*fuelLiter;
	}
	
}

interface ExServices{
	public abstract double getInsurance();//Renting Insurance
	public abstract double getChildSeat();//Child Car Seats
	public abstract double getSnowChains();//Snow Chains
	public abstract double getGps();//GPS Navigation
}

class TYPEA extends CAR implements ExServices{
	//Car Features.
	/*boolean automatic=false,eco=false,offRoad=false,snow=false,sport=false,cruiseControl=false,autoDrive=false;
	String fuelType="Diesel";
	String carModel="Fluence";
	int seatCapacity=5,traction=8;*/
	
	//Constructor that Include Parent Class Constructor.
	public TYPEA( ) {super('A');}
	//Overloading Usage.
	public TYPEA(String selectedCar) {System.out.println("Total Bill is Calculating...");}
	
	//Methods.
	public void getModel() {System.out.println("-Car Model: Fluence");}
	
	public void getFeatures() {
		double perLiter = 6.25;
		System.out.println("-Manuel Transmission.");
		System.out.println("-Fuel Type: Diesel.");
		System.out.println("-Seating Capacity: 5.");
		System.out.println("-Traction Type: 4x2.");
		System.out.println("-Burned Fuel Liter per 100 KM: "+ perLiter +" Liter.");
	}
	
	@Override
	public void getInfo() {
		getModel();
		getCommon();
		getFeatures();
		setRentPrice(412.99);//TL Price per Day.
	}
	
	@Override
	public double rentPriceCalculate(int day) {return super.rentPriceCalculate(day);}
	
	@Override
	public float getFuelPrice(float distance) {
		this.fuelLiter=1.375f;//TL Price per 1 KM.
		return super.getFuelPrice(distance);
	}
	@Override
	public double getInsurance() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*5/100);
		return extra;
	}
	@Override
	public double getChildSeat() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*2/100);
		return extra;
	}
	@Override
	public double getSnowChains() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*1.5/100);
		return extra;
	}
	@Override
	public double getGps() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*2.5/100);
		return extra;
	}
	
}

class TYPEB extends CAR implements ExServices {
	/*boolean automatic=true,eco=true,offRoad=false,snow=false,sport=false,cruiseControl=false,autoDrive=false;
	String fuelType="Petrol";
	String carModel="Toyota Corolla";
	int seatCapacity=5,traction=8;*/
	
	public TYPEB() {super('B');}
	public TYPEB(String selectedCar) {System.out.println("Total Bill is Calculating...");}
	
	public void getModel() {System.out.println("-Car Model: Toyota Corolla.");}
	
	public void getFeatures() {
		double perLiter = 8.50;
		System.out.println("-Automatic Transmission.\n"+ "-Eco Mod.");
		System.out.println("-Fuel Type: Petrol.");
		System.out.println("-Seating Capacity: 5.");
		System.out.println("-Traction Type: 4x2.");
		System.out.println("-Burned Fuel Liter per 100 KM: "+ perLiter +" Liter.");
	}
	
	@Override
	public void getInfo() {
		getModel();
		getCommon();
		getFeatures();
		setRentPrice(611.99);//TL Price per Day.
	}
	
	@Override
	public double rentPriceCalculate(int day) {return super.rentPriceCalculate(day);}
	
	@Override
	public float getFuelPrice(float distance) {
		this.fuelLiter=1.615f;//TL Price per 1 KM.
		return super.getFuelPrice(distance);
	}
	
	@Override
	public double getInsurance() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*4/100);
		return extra;
	}
	@Override
	public double getChildSeat() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*1.75/100);
		return extra;
	}
	@Override
	public double getSnowChains() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*1.25/100);
		return extra;
	}
	@Override
	public double getGps() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*2.25/100);
		return extra;
	}
	
}

class TYPEC extends CAR implements ExServices{
	/*boolean automatic=true,eco=false,offRoad=true,snow=true,sport=false,cruiseControl=true,autoDrive=false;
	String fuelType="Petrol";
	String carModel="Ford Ranger";
	int seatCapacity=5,traction=16;*/
	
	public TYPEC() {super('C');}
	public TYPEC(String selectedCar) {System.out.println("Total Bill is Calculating...");}
	
	public void getModel() {System.out.println("-Car Model: Ford Ranger.");}
	
	public void getFeatures() {
		double perLiter = 13.75;
		System.out.println("-Automatic Transmission.\n"+ "-Off Road Mod.\n"+ "-Snow Mod.\n"+ "-Cruise Control.");
		System.out.println("-Fuel Type: Petrol.");
		System.out.println("-Seating Capacity: 5.");
		System.out.println("-Traction Type: 4x4.");
		System.out.println("-Burned Fuel Liter per 100 KM: "+ perLiter +" Liter.");
	}
	
	@Override
	public void getInfo() {
		getModel();
		getCommon();
		getFeatures();
		setRentPrice(791.99);//TL Price per Day.
	}
	
	@Override
	public double rentPriceCalculate(int day) {return super.rentPriceCalculate(day);}
	
	@Override
	public float getFuelPrice(float distance) {
		this.fuelLiter=2.6125f;//TL Price per 1 KM.
		return super.getFuelPrice(distance);
	}
	
	@Override
	public double getInsurance() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*3/100);
		return extra;
	}
	@Override
	public double getChildSeat() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*1.35/100);
		return extra;
	}
	@Override
	public double getSnowChains() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*0.95/100);
		return extra;
	}
	@Override
	public double getGps() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*1.95/100);
		return extra;
	}
}

class TYPED extends CAR implements ExServices{
	/*boolean automatic=true,eco=false,offRoad=false,snow=false,sport=true,cruiseControl=true,autoDrive=true;
	String fuelType="Electric";
	String carModel="Tesla Model 3";
	int seatCapacity=2,traction=16;*/
	
	public TYPED() {super('D');}
	public TYPED(String selectedCar) {System.out.println("Total Bill is Calculating...");}
	
	public void getModel() {System.out.println("-Car Model: Tesla Model 3.");}
	
	public void getFeatures() {
		System.out.println("-Automatic Transmission.\n"+ "-Sport Mod.\n"+ "-Autonomous Drive.\n"+ "-Cruise Control.");
		System.out.println("-Fuel Type: Electric.");
		System.out.println("-Seating Capacity: 2.");
		System.out.println("-Traction Type: 4x4.");
		System.out.println("-Burned Energy per 100 KM: "+ 20100 +" Watt.");
	}
	
	@Override
	public void getInfo() {
		getModel();
		getCommon();
		getFeatures();
		setRentPrice(1338.99);//TL Price per Day.
	}
	
	@Override
	public double rentPriceCalculate(int day) {return super.rentPriceCalculate(day);}
	
	public float fuelWatt=0.26934f;//Price per 1 KM.
	public float getWattPrice(float distance) {return distance*fuelWatt;}
	
	@Override
	public double getInsurance() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*1/100);
		return extra;
	}
	@Override
	public double getChildSeat() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*0.1/100);
		return extra;
	}
	@Override
	public double getSnowChains() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*0.1/100);
		return extra;
	}
	@Override
	public double getGps() {
		double rent=getRentPrice();
		double extra=0;
		extra=(rent*0.1/100);
		return extra;
	}
}
