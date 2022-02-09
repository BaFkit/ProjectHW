package ADS_Java.Lesson6;

import java.util.Random;

public class CreatorTree <E> {

    private static final Random random = new Random();

    public static TreeImpl<Integer> constructionTree() {

        TreeImpl<Integer> tree = new TreeImpl<>();

        while (tree.depthL < 4 && tree.depthR < 4){
            tree.add(random.nextInt(50)- 25);
        }
        return tree;
        }

    }

