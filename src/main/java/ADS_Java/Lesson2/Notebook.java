package ADS_Java.Lesson2;

public class Notebook {
    private int price;
    private int ram;
    private Brand brand;

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public Brand getBrand() {
        return brand;
    }

    Notebook(){
        price = MyValue.getNumber(500, 2000, 50);
        ram = MyValue.getNumber(4, 24, 4);
        brand = MyValue.getBrand();
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                '}' + '\n';
    }

}
