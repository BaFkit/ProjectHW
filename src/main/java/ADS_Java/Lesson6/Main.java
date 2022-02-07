package ADS_Java.Lesson6;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double size = 20.0;

        ArrayList<TreeImpl> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(CreatorTree.constructionTree());
        }
        double t = 0;
        double f = 0;

        for (TreeImpl a: arrayList) {
            a.display();
            if(a.printBalanced()) t++;
            else f++;
            System.out.println("******************************************************************************************************************************************");
        }
        System.out.println(t);
        System.out.println(f);
        System.out.println("Процент  несбалансированных деревьев составляет: " + (int) (f/(size/100)) + "%");
    }
}

