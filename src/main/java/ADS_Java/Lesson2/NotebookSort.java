package ADS_Java.Lesson2;

public class NotebookSort {

    public static void sort(Notebook[] notebooks) {

        for (int i = 0; i < notebooks.length; i++) {
            int min = i;

            for (int j = min + 1; j < notebooks.length; j++) {
                if (notebooks[j].getPrice() < notebooks[min].getPrice()) {
                    min = j;
                }
                if (notebooks[j].getPrice() == notebooks[min].getPrice()) {
                   if (notebooks[j].getRam() < notebooks[min].getRam()){
                       min = j;
                   }
                    if (notebooks[j].getRam() == notebooks[min].getRam()){
                        if(notebooks[j].getBrand().priority < notebooks[min].getBrand().priority){
                            min = j;
                        }
                    }
                }
            }
            Notebook temp = notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
        }
    }
}
