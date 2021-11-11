package Java_2.Lesson2;

public class MyArrayDataException extends  NumberFormatException {

    public String detailing;
    public MyArrayDataException(String detailing){
        this.detailing = detailing;
    }

    @Override
    public String toString() {
        return detailing;
    }

}
