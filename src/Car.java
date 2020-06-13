import java.util.Random;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private int hp;
    private int engine;
    private String regNum;
    private CarColor color;

    public enum CarColor {red, blue, green, black, white, silver;
        public static Car.CarColor randColor() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public Car() {
    }

    public Car(String brand, String model, int year, int mileage, int hp, int engine, CarColor color, String regNum) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.hp = hp;
        this.engine = engine;
        this.color = color;
        this.regNum = regNum;
    }
    public Car(String brand, String model, int year, int mileage, int hp, int engine, String regNum) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.hp = hp;
        this.engine = engine;
        this.regNum = regNum;
        this.color = CarColor.randColor();
    }

    public String toString() {
        return String.format("%1$15s",this.brand) + " " + String.format("%1$15s",this.model) + " " +this.regNum;
    }
    public String show(){
        return String.format("%1$15s",this.brand) + " " + String.format("%1$15s",this.model) + " " + String.format("%1$4s",this.getHp()) +" " +  this.regNum + " " +this.year + " " +String.format("%1$8s",this.mileage) + " " +String.format("%1$6s",this.color.toString()) + " " +this.engine;
    }

    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public String getRegNum(){
        return this.regNum;
    }

    public int getYear(){
        return this.year;
    }
    public String getColor(){
        return this.color.toString();
    }
    public int getHp(){
        return this.hp;
    }
    public int getMileage(){
        return  this.mileage;
    }




}

