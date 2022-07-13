package ads.Lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final int infinity = 9999999;
    private int countOfVertices;
    private int countOfVertexVisit;
    private List<Way> shortestWays;
    private int currentVertex;
    private int startToCurrent;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        countOfVertices = 0;
        countOfVertexVisit = 0;
        for (int i = 0; i < maxVertexCount; i++) {
            for (int j = 0; j < maxVertexCount; j++) {
                adjMatrix[i][j] = infinity;
                shortestWays = new ArrayList<>();
            }
        }
    }

    @Override
    public void bestWay() {
        int startTree = 0;
        vertexList.get(startTree).setVisited(true);
        countOfVertexVisit = 1;
        for (int i = 0; i < countOfVertices; i++) {
            int tempDist = adjMatrix[startTree][i];
            Way way = new Way(tempDist);
            way.getParentVertices().add(0);
            shortestWays.add(way);
        }
        while (countOfVertexVisit < countOfVertices) {
            int indexMin = getMin();
            int minDist = shortestWays.get(indexMin).getDistance();

            if (minDist == infinity) {
                System.out.println("Неверная вершина");
                break;
            } else {
                currentVertex = indexMin;
                startToCurrent = shortestWays.get(indexMin).getDistance();
            }
            vertexList.get(currentVertex).setVisited(true);
            countOfVertexVisit++;
            updateShortestWay();
        }
        printBestWays();
    }


    private int getMin() {
        int minDist = infinity;
        int indexMin = 0;
        for (int i = 1; i < countOfVertices; i++) {
            if (!vertexList.get(i).isVisited() && shortestWays.get(i).getDistance() < minDist) {
                minDist = shortestWays.get(i).getDistance();
                indexMin = i;
            }
        }
        return indexMin;
    }

    private void updateShortestWay() {
        int vertexIndex = 1;
        while (vertexIndex < countOfVertices) {
            if (vertexList.get(vertexIndex).isVisited()) {
                vertexIndex++;
                continue;
            }
            int currentToLast = adjMatrix[currentVertex][vertexIndex];
            int startToLast = startToCurrent + currentToLast;
            int shortPathDistance = shortestWays.get(vertexIndex).getDistance();
            if (startToLast < shortPathDistance) {
                List<Integer> newParents = new ArrayList<>(shortestWays.get(currentVertex).getParentVertices());
                newParents.add(currentVertex);
                shortestWays.get(vertexIndex).setParentVertices(newParents);
                shortestWays.get(vertexIndex).setDistance(startToLast);
            }
            vertexIndex++;
        }
    }

    private void printBestWays() {
        for (int i = 0; i < countOfVertices; i++) {
            if (Objects.equals(vertexList.get(i).getLabel(), vertexList.get(0).getLabel())){
                continue;
            }
            System.out.print("Кратчайший путь от " + vertexList.get(0).getLabel() + " до " + vertexList.get(i).getLabel() + " = ");
            if (shortestWays.get(i).getDistance() == infinity) {
                System.out.println("0");
            } else {
                StringBuilder result = new StringBuilder(shortestWays.get(i).getDistance() + "км (");
                List<Integer> parents = shortestWays.get(i).getParentVertices();
                for (Integer parent : parents) {
                    result.append(vertexList.get(parent).getLabel()).append("->");
                }
                System.out.println(result + vertexList.get(i).getLabel() + ")");
            }
        }
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        countOfVertices++;
    }
    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);
        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }
    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }
    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            System.out.println(adjMatrix[currentIndex][i]);
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited() ) {
                //System.out.println(adjMatrix[currentIndex][i]);
                return vertexList.get(i);
            }
        }
        return null;
    }
    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {

        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }
    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }
    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int getSize() {
        return vertexList.size();
    }
    @Override
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {

            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0 && adjMatrix[i][j] != infinity) {
                   sb.append(vertexList.get(i)).append(" ").append(adjMatrix[i][j]).append("км -> ").append(vertexList.get(j)).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }
        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }
}
