class Vehicle 
{
    private String make;
    private String model;
    private int year;

	public Vehicle()
	{
        this.make = "";
        this.model = "";
        this.year = 0;
    }
	
    public Vehicle(String make, String model, int year) 
	{
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake()  
	{
		return make; 
	}
    public String getModel() 
	{
		return model;
	}
    public int getYear()     
	{
		return year; 
	}

    public void setMake(String make)   
	{
		this.make = make;
	}
    public void setModel(String model)
	{
		this.model = model;
	}
    public void setYear(int year)      
	{
		this.year = year; 
	}

    public void display() {
        System.out.println("Make  : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year  : " + year);
    }
}

class Car extends Vehicle 
{
    private int numDoors;

    public Car(String make, String model, int year, int numDoors) 
	{
        super(make, model, year);
        this.numDoors = numDoors;
    }

    public int getNumDoors()           
	{
		return numDoors;
	}
    public void setNumDoors(int numDoors) 
	{
		this.numDoors = numDoors;
	}

    @Override
    public void display() {
        System.out.println("--- Car Details ---");
        super.display();
        System.out.println("Doors : " + numDoors);
    }
}

class Motorcycle extends Vehicle
 {
    private boolean hasSelfstart;

	public Motorcycle()
	{
        super("","",0);
        this.hasSelfstart = false;
    }
	
    public Motorcycle(String make, String model, int year, boolean hasSelfstart)
	{
        super(make, model, year);
        this.hasSelfstart = hasSelfstart;
    }

    public boolean gethasSelfstart()              
	{
		return hasSelfstart;
	}
    public void sethasSelfstart(boolean hasSelfstart)
	{
		this.hasSelfstart = hasSelfstart;
	}

    @Override
    public void display() 
	{
        System.out.println("--- Motorcycle Details ---");
        super.display();
        System.out.println("Self Start : " + (hasSelfstart ? "Yes" : "No"));
    }
}

public class MainVehicle 
{
    public static void main(String[] args)
	{
        Car car1 = new Car("Toyota", "Camry", 2022, 4);
        car1.display();

        System.out.println();

        Motorcycle motor1 = new Motorcycle();
        motor1.setMake("Honda");
        motor1.setModel("CBR500");
        motor1.setYear(2021);
        motor1.sethasSelfstart(true);
        motor1.display();
    }
}