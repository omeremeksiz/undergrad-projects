package carRenting;
import java.util.Arrays;
import java.util.Scanner;

public class MAIN {
	public static void getSelection(int[] selections) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you have specific car choice ?\n"+ "Please enter true if you have otherwise enter false.");
		boolean selectionType = scanner.nextBoolean();
		//boolean selectionType = Boolean.parseBoolean(JOptionPane.showInputDialog("Do you have specific car choice ?\n"+ "Please enter true if you have otherwise enter false."));
		System.out.println("Please enter renting time(exact multiples of 1 day):");
		int rentTime = scanner.nextInt();
		double rentPrice = 0;
		double extraPrice = 0;
		String selectedCar;
		
		if(selectionType) {
			while(true) {
				System.out.println("Please enter your car model:");
				System.out.println("Car Models are Listed Bellow\n"+ "-Type A Car Model: Fluence\n"+ 
				"-Type B Car Model: Toyota Corolla\n"+ "-Type C Car Model: Ford Ranger\n"+ "-Type D Car Model: Tesla Model 3");
				scanner.nextLine();
				String carModel = scanner.nextLine();
				if(carModel.equals("Fluence")) {
					TYPEA typeACar = new TYPEA();
					typeACar.getInfo();
					rentPrice = typeACar.rentPriceCalculate(rentTime);
					System.out.println("-Total rent price for given renting time: "+rentPrice);
					System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");//Extra Services Block Start
					String extraSelection=scanner.nextLine();
					if(extraSelection.equals("yes")) {
						extraInfo();
						int[] arr = new int[4];
						System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
						for(int i=0;i<4;i++) 
							arr[i]=scanner.nextInt();
						for(int i=0;i<4;i++) {
							if(arr[i]==1) {
								if(i==0) 
									extraPrice+=typeACar.getInsurance();
								else if(i==1)
									extraPrice+=typeACar.getChildSeat();
								else if(i==2)
									extraPrice+=typeACar.getSnowChains();
								else if(i==3)
									extraPrice+=typeACar.getGps();
							}
						}
						System.out.println("Extra services have been added to your vehicle.");
						rentPrice+=extraPrice;
						extraPrice=0;
					}//Extra Services Block End
				}
				else if (carModel.equals("Toyota Corolla")) {
					TYPEB typeBCar = new TYPEB();
					typeBCar.getInfo();
					rentPrice = typeBCar.rentPriceCalculate(rentTime);
					System.out.println("-Total rent price for given renting time: "+rentPrice);
					System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");
					String extraSelection=scanner.nextLine();
					if(extraSelection.equals("yes")) {
						extraInfo();
						int[] arr = new int[4];
						System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
						for(int i=0;i<4;i++) 
							arr[i]=scanner.nextInt();
						for(int i=0;i<4;i++) {
							if(arr[i]==1) {
								if(i==0) 
									extraPrice+=typeBCar.getInsurance();
								else if(i==1)
									extraPrice+=typeBCar.getChildSeat();
								else if(i==2)
									extraPrice+=typeBCar.getSnowChains();
								else if(i==3)
									extraPrice+=typeBCar.getGps();
							}
						}
						System.out.println("Extra services have been added to your vehicle.");
						rentPrice+=extraPrice;
						extraPrice=0;
					}
				}
				else if (carModel.equals("Ford Ranger")) {
					TYPEC typeCCar = new TYPEC();
					typeCCar.getInfo();
					rentPrice = typeCCar.rentPriceCalculate(rentTime);
					System.out.println("-Total rent price for given renting time: "+rentPrice);
					System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");
					String extraSelection=scanner.nextLine();
					if(extraSelection.equals("yes")) {
						extraInfo();
						int[] arr = new int[4];
						System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
						for(int i=0;i<4;i++) 
							arr[i]=scanner.nextInt();
						for(int i=0;i<4;i++) {
							if(arr[i]==1) {
								if(i==0) 
									extraPrice+=typeCCar.getInsurance();
								else if(i==1)
									extraPrice+=typeCCar.getChildSeat();
								else if(i==2)
									extraPrice+=typeCCar.getSnowChains();
								else if(i==3)
									extraPrice+=typeCCar.getGps();
							}
						}
						System.out.println("Extra services have been added to your vehicle.");
						rentPrice+=extraPrice;
						extraPrice=0;
					}
				}
				else if(carModel.equals("Tesla Model 3")) {
					TYPED typeDCar = new TYPED();
					typeDCar.getInfo();
					rentPrice = typeDCar.rentPriceCalculate(rentTime);
					System.out.println("-Total rent price for given renting time: "+rentPrice);
					System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");
					String extraSelection=scanner.nextLine();
					if(extraSelection.equals("yes")) {
						extraInfo();
						int[] arr = new int[4];
						System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
						for(int i=0;i<4;i++) 
							arr[i]=scanner.nextInt();
						for(int i=0;i<4;i++) {
							if(arr[i]==1) {
								if(i==0) 
									extraPrice+=typeDCar.getInsurance();
								else if(i==1)
									extraPrice+=typeDCar.getChildSeat();
								else if(i==2)
									extraPrice+=typeDCar.getSnowChains();
								else if(i==3)
									extraPrice+=typeDCar.getGps();
							}
						}
						System.out.println("Extra services have been added to your vehicle.");
						rentPrice+=extraPrice;
						extraPrice=0;
					}
				}
				System.out.println("If you accept car features, please enter 1 or enter 0 to choose another car model:");
				int accept = scanner.nextInt();
				if(accept==1) {
					System.out.println("Congratulations, You have successfully selected your vehicle.");
					System.out.println("Total Payment Amount: "+ rentPrice );
					System.out.println("Would you like to know how much this trip cost you in total ?('N' for No 'Y' for Yes)");
					char finalSelection = scanner.next().charAt(0);
					if(finalSelection == 'Y') {
						System.out.println("Please enter your road distance in KM :");
						float distance = scanner.nextFloat();
						float totalBill = totalPayment(carModel, distance, (float)rentPrice);
						System.out.println("Your total bill for this trip is: "+ totalBill);
					}
					System.out.println("Thank you for choosing us, we wish you a good trip.");
					break;
				}
			}
			
		}
		else {
			while(true) {
				System.out.println("ANSWER OUR QUESTIONS AND HELP US TO FIND THE BEST VEHICLE FOR YOU.");
				System.out.println("Select your car transmission type (0 for Manuel, 1 for Automatic):");
				selections[0] = scanner.nextInt();
				if(selections[0]==0) {
					TYPEA typeACar = new TYPEA();
					typeACar.getInfo();
					rentPrice = typeACar.rentPriceCalculate(rentTime);
					System.out.println("-Total rent price for given renting time: "+rentPrice);
					selectedCar = "Fluence";
					System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");//Extra Services Block Start
					scanner.nextLine();
					String extraSelection=scanner.nextLine();
					if(extraSelection.equals("yes")) {
						extraInfo();
						int[] arr = new int[4];
						System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
						for(int i=0;i<4;i++) 
							arr[i]=scanner.nextInt();
						for(int i=0;i<4;i++) {
							if(arr[i]==1) {
								if(i==0) 
									extraPrice+=typeACar.getInsurance();
								else if(i==1)
									extraPrice+=typeACar.getChildSeat();
								else if(i==2)
									extraPrice+=typeACar.getSnowChains();
								else if(i==3)
									extraPrice+=typeACar.getGps();
							}
						}
						System.out.println("Extra services have been added to your vehicle.");
						rentPrice+=extraPrice;
						extraPrice=0;
					}//Extra Services Block End
				}
				else {
					System.out.println("Do you request automatic driving assistance in your car (0 for No, 1 for Yes) ?");
					selections[1]=scanner.nextInt();
					if(selections[1]==1) {
						TYPED typeDCar = new TYPED();
						typeDCar.getInfo();
						rentPrice = typeDCar.rentPriceCalculate(rentTime);
						System.out.println("-Total rent price for given renting time: "+rentPrice);
						selectedCar = "Tesla Model 3";
						System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");//Extra Services Block Start
						scanner.nextLine();
						String extraSelection=scanner.nextLine();
						if(extraSelection.equals("yes")) {
							extraInfo();
							int[] arr = new int[4];
							System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
							for(int i=0;i<4;i++) 
								arr[i]=scanner.nextInt();
							for(int i=0;i<4;i++) {
								if(arr[i]==1) {
									if(i==0) 
										extraPrice+=typeDCar.getInsurance();
									else if(i==1)
										extraPrice+=typeDCar.getChildSeat();
									else if(i==2)
										extraPrice+=typeDCar.getSnowChains();
									else if(i==3)
										extraPrice+=typeDCar.getGps();
								}
							}
							System.out.println("Extra services have been added to your vehicle.");
							rentPrice+=extraPrice;
							extraPrice=0;
						}//Extra Services Block End
					}
					else {
						System.out.println("Do you request cruise control in your car (0 for No, 1 for Yes) ?");
						selections[2]=scanner.nextInt();
						if(selections[2]==1) {
							TYPEC typeCCar = new TYPEC();
							typeCCar.getInfo();
							rentPrice = typeCCar.rentPriceCalculate(rentTime);
							System.out.println("-Total rent price for given renting time: "+rentPrice);
							selectedCar = "Ford Ranger";
							System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");//Extra Services Block Start
							scanner.nextLine();
							String extraSelection=scanner.nextLine();
							if(extraSelection.equals("yes")) {
								extraInfo();
								int[] arr = new int[4];
								System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
								for(int i=0;i<4;i++) 
									arr[i]=scanner.nextInt();
								for(int i=0;i<4;i++) {
									if(arr[i]==1) {
										if(i==0) 
											extraPrice+=typeCCar.getInsurance();
										else if(i==1)
											extraPrice+=typeCCar.getChildSeat();
										else if(i==2)
											extraPrice+=typeCCar.getSnowChains();
										else if(i==3)
											extraPrice+=typeCCar.getGps();
									}
								}
								System.out.println("Extra services have been added to your vehicle.");
								rentPrice+=extraPrice;
								extraPrice=0;
							}//Extra Services Block End
						}
						else {
							TYPEB typeBCar = new TYPEB();
							typeBCar.getInfo();
							rentPrice = typeBCar.rentPriceCalculate(rentTime);
							System.out.println("-Total rent price for given renting time: "+rentPrice);
							selectedCar = "Toyota Corolla";
							System.out.println("Would you like to use extra services to better experience ?(Please enter yes or no)");//Extra Services Block Start
							scanner.nextLine();
							String extraSelection=scanner.nextLine();
							if(extraSelection.equals("yes")) {
								extraInfo();
								int[] arr = new int[4];
								System.out.println("Please enter 1 or 0 according to the order above for the extras you want.");
								for(int i=0;i<4;i++) 
									arr[i]=scanner.nextInt();
								for(int i=0;i<4;i++) {
									if(arr[i]==1) {
										if(i==0) 
											extraPrice+=typeBCar.getInsurance();
										else if(i==1)
											extraPrice+=typeBCar.getChildSeat();
										else if(i==2)
											extraPrice+=typeBCar.getSnowChains();
										else if(i==3)
											extraPrice+=typeBCar.getGps();
									}
								}
								System.out.println("Extra services have been added to your vehicle.");
								rentPrice+=extraPrice;
								extraPrice=0;
							}//Extra Services Block End
						}
					}
				}
				System.out.println("If you accept car features, please enter 1 or enter 0 to choose another car model:");
				int accept = scanner.nextInt();
				if(accept==1) {
					System.out.println("Congratulations, You have successfully selected your vehicle.");
					System.out.println("Total Payment Amount: "+ rentPrice );
					System.out.println("Would you like to know how much this trip cost you in total ?('N' for No 'Y' for Yes)");
					char finalSelection = scanner.next().charAt(0);
					if(finalSelection == 'Y') {
						System.out.println("Please enter your road distance in KM :");
						float distance = scanner.nextFloat();
						float totalBill = totalPayment(selectedCar, distance, (float)rentPrice);
						System.out.println("Your total bill for this trip is: "+ totalBill);
					}
					System.out.println("Thank you for choosing us, we wish you a good trip.");
					break;
				}
				else {
					Arrays.fill(selections,0);
				}
			}
		}
		scanner.close();
	}
	
	public static float totalPayment(String selectedCar, float distance, float rentPrice) {
		float totalPay=0,fuelPrice;
		if(selectedCar.equals("Fluence")) {
			TYPEA typeACar = new TYPEA(selectedCar);
			fuelPrice = typeACar.getFuelPrice(distance);
			totalPay += fuelPrice;
		}
		else if (selectedCar.equals("Toyota Corolla")) {
			TYPEB typeBCar = new TYPEB(selectedCar);
			fuelPrice = typeBCar.getFuelPrice(distance);
			totalPay += fuelPrice;
		}
		else if (selectedCar.equals("Ford Ranger")) {
			TYPEC typeCCar = new TYPEC(selectedCar);
			fuelPrice = typeCCar.getFuelPrice(distance);
			totalPay += fuelPrice;
		}
		else if(selectedCar.equals("Tesla Model 3")) {
			TYPED typeDCar = new TYPED(selectedCar);
			fuelPrice = typeDCar.getFuelPrice(distance);
			totalPay += fuelPrice;
		}
		totalPay += rentPrice;
		return totalPay;
	}
	
	public static void extraInfo() {
		System.out.println("The extra services are listed bellow:");
		System.out.println("-Renting Insurance;");
		System.out.println("\tPrice for Fluence: %5 of rent price.\n"
				+ "\tPrice for Toyota Corolla: %4 of rent price.\n"+"\tPrice for Ford Ranger: %3 of rent price.\n"+"\tPrice for Tesla Model 3: %1 of rent price." );
		System.out.println("-Child Car Seat;");
		System.out.println("\tPrice for Fluence: %2 of rent price.\n"
				+ "\tPrice for Toyota Corolla: %1.75 of rent price.\n"+"\tPrice for Ford Ranger: %1.35 of rent price.\n"+"\tPrice for Tesla Model 3: %0.1 of rent price." );
		System.out.println("-Snow Chains;");
		System.out.println("\tPrice for Fluence: %2.5 of rent price.\n"
				+ "\tPrice for Toyota Corolla: %2.25 of rent price.\n"+"\tPrice for Ford Ranger: %1.95 of rent price.\n"+"\tPrice for Tesla Model 3: %0.1 of rent price." );
		System.out.println("-GPS Navigation;");
		System.out.println("\tPrice for Fluence: %1.5 of rent price.\n"
				+ "\tPrice for Toyota Corolla: %1.25 of rent price.\n"+"\tPrice for Ford Ranger: %0.95 of rent price.\n"+"\tPrice for Tesla Model 3: %0.1 of rent price." );
	}

	public static void main(String[] args) {
		int[] selections = new int[3];
		getSelection(selections);
	}

}
