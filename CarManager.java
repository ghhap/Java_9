import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class CarManager {
    private Car[] cars;

    public CarManager() {
        cars = new Car[]{
                new Car("Toyota", "Camry", 2020, 25000),
                new Car("BMW", "X5", 2022, 65000),
                new Car("Audi", "A4", 2019, 28000),
                new Car("Mercedes", "C200", 2021, 45000),
                new Car("Honda", "Civic", 2018, 18000),
                new Car("Ford", "Focus", 2017, 12000),
                new Car("Volkswagen", "Passat", 2020, 23000),
                new Car("Hyundai", "Elantra", 2023, 22000),
                new Car("Kia", "Sportage", 2022, 30000),
                new Car("Tesla", "Model 3", 2023, 40000)
        };
    }

    public void showAll() {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(i + ". " + cars[i]);
        }
    }

    public void editCar(int index, String brand, String model, int year, double price) {
        if (index >= 0 && index < cars.length) {
            cars[index].update(brand, model, year, price);
            System.out.println("Автомобіль змінено!");
        } else {
            System.out.println("Неправильний індекс!");
        }
    }

    public void showExpensiveCars(double minPrice) {
        boolean found = false;
        for (Car car : cars) {
            if (car.getPrice() > minPrice) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Автомобілів за цією умовою не знайдено.");
        }
    }

    public void sortAscending() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getPrice));
        System.out.println("Сортування за зростанням ціни:");
        showAll();
    }

    public void sortDescending() {
        Arrays.sort(cars, Comparator.comparingDouble(Car::getPrice).reversed());
        System.out.println("Сортування за спаданням ціни:");
        showAll();
    }

    // Нове: сортування за текстовим полем (марка).
    public void sortBrandAscending() {
        Arrays.sort(cars, Comparator.comparing(Car::getBrand, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Сортування марок за зростанням (А-Я):");
        showAll();
    }

    public void sortBrandDescending() {
        Arrays.sort(cars, Comparator.comparing(Car::getBrand, String.CASE_INSENSITIVE_ORDER).reversed());
        System.out.println("Сортування марок за спаданням (Я-А):");
        showAll();
    }

    // Нове: регулярний вираз ^T.* означає «починається з T».
    public void showBrandsStartingWithT() {
        Pattern pattern = Pattern.compile("^T.*", Pattern.CASE_INSENSITIVE);
        boolean found = false;
        System.out.println("Автомобілі, марка яких починається з T:");
        for (Car car : cars) {
            if (pattern.matcher(car.getBrand()).matches()) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Відповідних автомобілів не знайдено.");
        }
    }

    // Нове: пошук найменшого та найбільшого числового поля (ціна).
    public void showMinMaxPrice() {
        if (cars.length == 0) {
            System.out.println("Список автомобілів порожній.");
            return;
        }

        Car cheapest = cars[0];
        Car mostExpensive = cars[0];
        for (Car car : cars) {
            if (car.getPrice() < cheapest.getPrice()) {
                cheapest = car;
            }
            if (car.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = car;
            }
        }

        System.out.printf("Найменшу ціну %.2f $ має %s %s.%n",
                cheapest.getPrice(), cheapest.getBrand(), cheapest.getModel());
        System.out.printf("Найбільшу ціну %.2f $ має %s %s.%n",
                mostExpensive.getPrice(), mostExpensive.getBrand(), mostExpensive.getModel());
    }
}
