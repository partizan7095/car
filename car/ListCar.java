package car;
import java.io.*;
import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.Stream;

public class ListCar{
    List<Car> list = new ArrayList<>();

    void sortAge(String modelCar){
        Stream<Car> listsort = list.stream()
                .filter(c -> c.getModel().equals(modelCar))
                .sorted(Comparator.comparing(Car::getYear));

        listsort.forEach(System.out::println);
        System.out.println("");
    }
    void getOldCar(String modelCar, int yearExpCar){
        Stream<Car> listsort1 = list.stream()
                .filter(c -> c.getModel().equals(modelCar))
                .filter(c -> c.getYear() < 2021 - yearExpCar)
                .sorted(Comparator.comparing(Car::getId));

        listsort1.forEach(System.out::println);
        System.out.println("");
    }
    void getCarOldPrice(int yearOld, int price){
        Stream<Car> listsort1 = list.stream()
                .filter(c -> c.getPrice() > price)
                .filter(c -> c.getYear() == yearOld)
                .sorted(Comparator.comparing(Car::getId));

        listsort1.forEach(System.out::println);
        System.out.println("");
    }

    void sortPriceToLow(){
        Stream<Car> listsort1 = list.stream()
                .sorted(Comparator.comparing(Car::getYear))
                .sorted(Comparator.comparing(Car::getPrice).reversed());

        listsort1.forEach(System.out::println);
        System.out.println("");
    }
    void sortModel(){
        Stream<Car> listsort1 = list.stream()
                .sorted(Comparator.comparing(Car::getModel));
        listsort1.forEach(System.out::println);
        System.out.println("");
    }

    void add(int id, String model, int year, int price, int regNum){
        list.add(new Car(id, model, year, price, regNum));
    }
    void remove(int id){
        list.removeIf(car -> car.getId() == id);
    }
    void showAll(){
        Stream<Car> listsort1 = list.stream()
                .sorted(Comparator.comparing(Car::getId));
        listsort1.forEach(System.out::println);
        System.out.println("");
    }
    void setFile(String nameFile){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void getFile(String nameFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile))) {
            List<Car> listcar= ((ArrayList<Car>)ois.readObject());
            list.addAll(listcar);
            listcar.removeAll(listcar);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
