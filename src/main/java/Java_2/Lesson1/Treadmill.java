package Java_2.Lesson1;

import java.util.ArrayList;

public class Treadmill implements Hurdle{

    private int length;

    public Treadmill(int length){
        this.length = length;
    }

    @Override
    public void passingHurdle(Subject subject) {
        if (subject.getMaxLength() >= length){
            subject.run();
            System.out.println(subject.getName() + " успешно пробежал дорожку длиной - "+length+"км\n");
        }else {
            subject.run();
            boolean success = false;
            subject.setAdmittance(success);
            System.out.println(subject.getName() + " не смог пробежать дорожку длиной - "+length+"км\n" + subject.getName()+ " выбывает\n");
        }
    }
}


