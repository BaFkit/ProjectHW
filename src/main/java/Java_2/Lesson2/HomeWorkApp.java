package Java_2.Lesson2;

public class HomeWorkApp {

    public void transformInt  (String[][] array) throws MyArraySizeException, MyArrayDataException{
        if (array.length == 4) {
            for (int i = 0; i < 4; i++) {
                 if(array[i].length != 4) throw new MyArraySizeException();
            }
        }else throw new MyArraySizeException();

        System.out.println("Принят массив верного размера");

        int sum = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("В данном массиве: в столбце с индексом - "+ i +", в ячейка с индексом - "+ j + " лежит не число");
                    }

                }
            }
        System.out.println("Сумма всех чисел в массиве: " + sum);
    }

    public static void main(String[] args) {
        HomeWorkApp app = new HomeWorkApp();
        String[][] array = new String[][] {
                {"4", "8", "6", "3"},
                {"6", "7", "1", "9"},
                {"5", "4", "2", "7"},
                {"8", "4", "6", "7"}
        };

        try {
            app.transformInt(array);
        } catch (MyArraySizeException | MyArrayDataException  e) {
            //System.out.println(e);
            e.printStackTrace();
            System.out.println("Расчет не сделан");
        }
    }
}
