package Java_2.Lesson1;

public class Event {

    public static void main(String[] args) {

    Subject[] subjects = new Subject[] {
        new Cat("Barsic", 2, 1),
        new Robot("C-3PO", 10, 2),
        new Human("Vladimir", 15, 3)
    };

    Hurdle[] hurdles = new Hurdle[] {
          new Treadmill(2),
          new Wall(1),
          new Treadmill(5),
          new Wall(2),
          new Wall(3),
          new Treadmill(11)
    };

        for (Hurdle a: hurdles) {
            for (Subject b: subjects) {
                if(b.getAdmittance()){
                    a.passingHurdle(b);
                }
            }
        }
    }
}
