package Java_1.Lesson7;

public class MainClass {
    public static void main(String[] args) {

        Cat[] cats = new Cat[]{
            new Cat("Barsik", 15),
            new Cat("Roma", 0),
            new Cat("Tomas", 40),
            new Cat("Fedor", 10),
        };
        Plate plate = new Plate(50);

        for (Cat a: cats){
            a.eat(plate);
            // Код для 6-го задания:
    //****************************************************************************************************
            if(a.getAppetite() > plate.getFood()){
                plate.addFood(a.getAppetite());
                System.out.println(a.getName() + " увидел, что добавили еды и решил вернуться к тарелке");
                a.eat(plate);
            }
    //****************************************************************************************************
            plate.info();
            System.out.println();
        }
        for (Cat a: cats){
            a.getSatiety();
        }

    }
}
