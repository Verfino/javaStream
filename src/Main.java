import com.sun.prism.shader.DrawEllipse_LinearGradient_PAD_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    enum Brandlist {Fiat, BMW, Opel, Nissan, Mercedes, Renault, Ford;
        public static String randBrand(){
            Random random = new Random();
            return values()[random.nextInt(values().length)].toString();
        }
    }
    enum modelList {sedan, kombi, hatchback, van, kabriolet;
        public static String randModel(){
            Random random = new Random();
            return values()[random.nextInt(values().length)].toString();
        }
    }


    public static void main(String[] args) {
	// write your code here
        //small();
        big();


    }

    public static void small(){
        List<Car> listCar = new ArrayList<>();

        listCar.add(new Car("BMW", "E90", 2007, 106728, 150, 1995, Car.CarColor.blue, "DW8Y476"));
        listCar.add(new Car("KIA", "Sportage", 2012, 167324, 154, 1996, Car.CarColor.black, "DW090SW"));
        listCar.add(new Car("Mercedes", "GLC", 2017, 28934, 211, 1996, Car.CarColor.white, "DW5M505"));
        listCar.add(new Car("Mercedes", "C63 AMG", 2016, 37890, 400, 1994, Car.CarColor.blue, "DW0X0X0"));
        listCar.add(new Car("Opel", "Vectra", 1999, 256740, 101, 1994, Car.CarColor.white, "DW046MJ"));

        System.out.println("Garaż: ");
        listCar.forEach(temp -> System.out.println(temp.show()));
        //filtry
        //marka
        System.out.println("\nFiltr po marce: Mercedes");
        listCar.stream()
                .filter(c -> c.getBrand().equals("Mercedes"))
                .forEach(System.out::println);

        //rocznik > 2010
        System.out.println("\nFiltr po roczniku: 2010");
        listCar.stream()
                .filter(c -> c.getYear() > 2010)
                .forEach(System.out::println);
        //kolor i moc >200
        System.out.println("\nFiltr po kolorze i roczniku: biały, hp >200");
        listCar.stream()
                .filter(c -> c.getHp() > 200 && c.getColor().equals("white"))
                .forEach(System.out::println);

        //mapowanie
        System.out.println("\nMapowanie pojazdu na numer rejestracyjny");
        listCar.stream()
                .map(c -> c.getRegNum())
                .forEach(System.out::println);

        System.out.println("\nMapowanie pojazdów na rok ich produkcji");
        listCar.stream()
                .mapToInt(c -> c.getYear())
                .forEach(System.out::println);

        //sortowanie
        System.out.println("\nSortowanie alfabetyczne po producencie");
        listCar.stream()
                .sorted((c1,c2) -> c1.getBrand().compareTo(c2.getBrand()))
                .forEach(System.out::println);

        System.out.println("\nSortowanie po roczniku");
        listCar.stream()
                .sorted((c1,c2) -> c1.getYear()-(c2.getYear()))
                .forEach(System.out::println);

        //distinct
        System.out.println("\nWartości unikalne dla producenta");
        listCar.stream()
                .map(c -> c.getBrand())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nWartości unikalne dla koloru");
        listCar.stream()
                .map(c -> c.getColor())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        //limit
        System.out.println("\nPierwsze 3 wyniki dla producenta");
        listCar.stream()
                .map(c -> c.getBrand())
                .limit(3)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nPierwsze 3 wyniki dla mocy (sortowanie odwrócone)");
        listCar.stream()
                .map(c -> c.getHp())
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        //skip
        System.out.println("\nRok produkcji najnowszego pojazdu");
        listCar.stream()
                .map(c -> c.getYear())
                .sorted()
                .skip(listCar.size()-1)
                .forEach(System.out::println);

        System.out.println("\nMoc najmocniejszego pojazdu");
        listCar.stream()
                .map(c -> c.getHp())
                .sorted()
                .skip(listCar.size()-1)
                .forEach(System.out::println);

        System.out.println("\nNajmniejszy przebieg pojazdu");
        listCar.stream()
                .map(c -> c.getMileage())
                .sorted(Comparator.reverseOrder())
                .skip(listCar.size()-1)
                .forEach(System.out::println);



    }
    public static String regnum(){
        Random random = new Random();
        String reg = "";
        for(int i=0; i < 6; i++){
            char c = (char)(random.nextInt(26)+'a');
            reg = reg + c;
        }
        reg = reg.toUpperCase();
        return reg;
    }



    public static void big(){
        List<Car> listCar = new ArrayList<>();



        String brand;
        String model;
        String regnum;
        int year;
        int mileage;
        int hp;
        int engine;
        Car.CarColor color;


        for(int i=0; i < 100; i ++){
            brand = Brandlist.randBrand();
            model = modelList.randModel();
            regnum = regnum();
            year = ThreadLocalRandom.current().nextInt(1990,2020 +1);
            mileage = ThreadLocalRandom.current().nextInt(1,300000 +1);
            hp = ThreadLocalRandom.current().nextInt(40,400+1);
            engine = 100 * ThreadLocalRandom.current().nextInt(6,40);
            listCar.add(new Car(brand,model,year,mileage,hp,engine,regnum));

        }

        listCar.add(new Car("BMW", "E90", 2007, 106728, 150, 1995, Car.CarColor.blue, "DW8Y476"));
        listCar.add(new Car("KIA", "Sportage", 2012, 167324, 154, 1996, Car.CarColor.black, "DW090SW"));
        listCar.add(new Car("Mercedes", "GLC", 2017, 28934, 211, 1996, Car.CarColor.white, "DW5M505"));
        listCar.add(new Car("Mercedes", "C63 AMG", 2016, 37890, 400, 1994, Car.CarColor.blue, "DW0X0X0"));
        listCar.add(new Car("Opel", "Vectra", 1999, 256740, 101, 1994, Car.CarColor.white, "DW046MJ"));

        System.out.println("Garaż: ");
        listCar.forEach(temp -> System.out.println(temp.show()));

        //marka
        System.out.println("\nFiltr po marce: Mercedes");
        listCar.stream()
                .filter(c -> c.getBrand().equals("Mercedes"))
                .forEach(System.out::println);

        //rocznik > 2010
        System.out.println("\nFiltr po roczniku: 2010");
        listCar.stream()
                .filter(c -> c.getYear() > 2010)
                .forEach(System.out::println);

        //kolor i moc >200
        System.out.println("\nFiltr po kolorze i roczniku: biały, hp >200");
        listCar.stream()
                .filter(c -> c.getHp() > 200 && c.getColor().equals("white"))
                .forEach(System.out::println);


        //mapowanie
        System.out.println("\nMapowanie pojazdu na numer rejestracyjny");
        listCar.stream()
                .map(c -> c.getRegNum())
                .forEach(System.out::println);

        System.out.println("\nMapowanie pojazdów na rok ich produkcji");
        listCar.stream()
                .mapToInt(c -> c.getYear())
                .forEach(System.out::println);

        //sortowanie
        System.out.println("\nSortowanie alfabetyczne po producencie");
        listCar.stream()
                .sorted((c1,c2) -> c1.getBrand().compareTo(c2.getBrand()))
                .forEach(System.out::println);

        System.out.println("\nSortowanie po roczniku");
        listCar.stream()
                .sorted((c1,c2) -> c1.getYear()-(c2.getYear()))
                .forEach(System.out::println);


        //distinct
        System.out.println("\nWartości unikalne dla producenta");
        listCar.stream()
                .map(c -> c.getBrand())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nWartości unikalne dla koloru");
        listCar.stream()
                .map(c -> c.getColor())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //limit
        System.out.println("\nPierwsze 3 wyniki dla producenta");
        listCar.stream()
                .map(c -> c.getBrand())
                .distinct()
                .limit(3)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nPierwsze 3 wyniki dla mocy (sortowanie odwrócone)");
        listCar.stream()
                .map(c -> c.getHp())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        //skip
        System.out.println("\nRok produkcji najnowszego pojazdu");
        listCar.stream()
                .map(c -> c.getYear())
                .sorted()
                .skip(listCar.size()-1)
                .forEach(System.out::println);

        System.out.println("\nMoc najmocniejszego pojazdu");
        listCar.stream()
                .map(c -> c.getHp())
                .sorted()
                .skip(listCar.size()-1)
                .forEach(System.out::println);

        System.out.println("\nNajmniejszy przebieg pojazdu");
        listCar.stream()
                .map(c -> c.getMileage())
                .sorted(Comparator.reverseOrder())
                .skip(listCar.size()-1)
                .forEach(System.out::println);

         
    }




}
