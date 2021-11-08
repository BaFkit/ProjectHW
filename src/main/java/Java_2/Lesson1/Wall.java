package Java_2.Lesson1;

public class Wall implements Hurdle{

    private int height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public void passingHurdle(Subject subject) {
        if (subject.getMaxHeight() >= height){
            subject.jump();
            System.out.println(subject.getName() + " успешно перепрыгнул стену высотой - "+height+"м\n");
        }else {
            subject.jump();
            boolean success = false;
            subject.setAdmittance(success);
            System.out.println(subject.getName() + " не смог перепрыгнуть стену высотой - "+height+"м\n" + subject.getName()+ " выбывает\n");
        }

    }
}
