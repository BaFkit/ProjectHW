package Java_2.Lesson1;

public class Event {

    public static void main(String[] args) {

    Subject[] subjects = new Subject[] {
        new Cat("Barsic", 2, 1),
        new Robot("C-3PO", 10, 0),
        new Human("Vladimir", 5, 2)
    };

    Hurdle[] hurdles = new Hurdle[] {
          new Treadmill(5),
          new Wall(1)
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
