package Java_2.Lesson2;

public class MyArraySizeException extends RuntimeException {

    @Override
    public String toString() {
        return "Получен массив не верного размера";
    }
}
