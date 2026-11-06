public class Car {
    private String brand;
    private String model;
    private int year;
    private double price;

    public Car(String brand, String model, int year, double price) {
        update(brand, model, year, price);
    }

    public void update(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return brand + " " + model +
                " | Рік: " + year +
                " | Ціна: " + price + " $";
    }
}
