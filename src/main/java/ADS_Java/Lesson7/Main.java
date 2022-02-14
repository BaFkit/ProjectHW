package ADS_Java.Lesson7;

public class Main {
    public static void main(String[] args) {
        testGraph();
//        testDfs();
//        testBfs();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(7);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 100);
        graph.addEdge("Тула", "Воронеж", 500);
        graph.addEdge("Москва", "Рязань", 300);
        graph.addEdge("Рязань", "Воронеж", 200);
        graph.addEdge("Тула", "Рязань", 100);

        //graph.display();
        graph.bestWay();
    }

}

