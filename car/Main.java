package car;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }
        void run(){
        ListCar listCar = new ListCar();
            listCar.add(5, "Mazda_3", 2014, 13000, 125624);
            listCar.add(1, "Mazda_3", 2004, 3000, 129124);
            listCar.add(7, "Mazda_3", 2021, 23000, 953124);
            listCar.add(6, "Mazda_3", 2008, 8000, 124924);
            listCar.add(2, "Mazda_2", 2010, 8000, 12334524);
            listCar.add(3, "BMW_565", 2009, 10000, 1223484);
            listCar.add(4, "VAZ_2101", 1965, 500, 12784);
            listCar.add(8, "VAZ_2101", 1975, 3000, 10584);
            listCar.add(9, "Mazda_3", 2014, 13000, 125624);

        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        String model = "";
        int nYear = 0;
        int year = 0;
        int price = 0;
        int id = 0;
        int regNum = 0;
        String fileName = "";

        while (!"0".equals(s)) {
            for (String s1 : Arrays.asList("1. Список автомобілів заданої моделі в порядку зростання року випуску", "2. Список автомобілів заданої моделі, які експлуатуються більше n років", "3. Список автомобілів заданого року випуску, ціна яких більше вказаної", "4. Список автомобілів в порядку спадання ціни. Якщо ціна однакова, то в\n" +
                    "порядку зростання року випуску", "5. Список моделей автомобілів, зареєстрованих у програмі", "6. Для кожної моделі вивести список автомобілів","7. Додати новий автомобіль", "8. Видалити автомобіль по ID","9. Записати дані в файл", "10. Зчитати дані з файла", "0. Вихід", "")) {
                System.out.println(s1);
            }
            s = scan.next();
            System.out.println("");
            if(Objects.equals(s, "1")) {
                System.out.println("Введіть модель");
                model = scan.next();
            }
            if(Objects.equals(s, "2")){
                System.out.println("Введіть модель");
                model = scan.next();
                System.out.println("Введіть кількість років");
                nYear = scan.nextInt();
            }if(Objects.equals(s, "3")){
                System.out.println("Введіть рік автомобіля");
                year = scan.nextInt();
                System.out.println("Введіть ціну");
                price = scan.nextInt();
            }
            if(Objects.equals(s, "7")) {
                System.out.println("Введіть ID");
                id = scan.nextInt();
                System.out.println("Введіть модель");
                model = scan.next();
                System.out.println("Введіть рік");
                year = scan.nextInt();
                System.out.println("Введіть ціну");
                price = scan.nextInt();
                System.out.println("Введіть регістраційний номер");
                regNum = scan.nextInt();
            }
            if(Objects.equals(s, "8")) {
                System.out.println("Введіть ID автомобіля який видалити");
                id = scan.nextInt();
            }
            if(Objects.equals(s, "9")) {
                System.out.println("Введіть назву файла");
                fileName = scan.next();
            }
            if(Objects.equals(s, "10")) {
                System.out.println("Введіть назву файла");
                fileName = scan.next();
            }

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (x) {
                case 1 -> listCar.sortAge(model);
                case 2 -> listCar.getOldCar(model, nYear);
                case 3 -> listCar.getCarOldPrice(year, price);
                case 4 -> listCar.sortPriceToLow();
                case 5 -> listCar.showAll();
                case 6 -> listCar.sortModel();
                case 7 -> listCar.add(id, model, year, price, regNum);
                case 8 -> listCar.remove(id);
                case 9 -> listCar.setFile(fileName);
                case 10 -> listCar.getFile(fileName);
            }
        }
        System.out.println("До побачення!");
    }
}

