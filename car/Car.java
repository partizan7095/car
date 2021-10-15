package car;

import java.io.Serializable;

public class Car implements Transport, Serializable {
    int id;
    String model;
    int year;
    int price;
    int regNum;

    public Car(int id, String model, int year, int price, int regNum) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.regNum = regNum;
    }



    @Override
    public int getId() {

        return id;
    }



    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public int getRegNum() {
        return regNum;
    }

    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", regNum=" + regNum +
                '}';
    }
}
