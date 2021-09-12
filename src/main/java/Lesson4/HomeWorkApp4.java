package Lesson4;

//Проверка на победу начинается после 3-го хода;
//Компьютер блокироют ходы игрока по горизонтали, вертикали и диагонали.


import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    public static char[][] map;
    public static final int SIZE = 3;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static int move;               // для подсчета хода

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return  false;
        return map[y][x] == DOT_EMPTY;
    }

// ***********************************************************************************************

    public static void aiTurn() {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    count += 1;
                }
            }
            if (count == (SIZE - 1)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        x = j;
                        y = i;
                        z += 1;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == DOT_X) {
                    count += 1;
                }
            }
            if (count == (SIZE - 1)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] == DOT_EMPTY) {
                        x = i;
                        y = j;
                        z += 1;
                    }
                }
            }
        }
        for (int i = SIZE - 1, count = 0, j = 0; i >= 0; i--, j++) {
            if (map[i][j] == DOT_X) {
                count += 1;
            }
            if (count == (SIZE - 1)) {
                for (int i2 = SIZE - 1, j2 = 0; i2 >= 0; i2--, j2++) {
                    if (map[i2][j2] == DOT_EMPTY) {
                        x = j2;
                        y = i2;
                        z += 1;
                    }
                }
            }
        }
        for (int i = SIZE - 1, count = 0; i >= 0; i--) {
            if (map[i][i] == DOT_X) {
                count += 1;
            }
            if (count == (SIZE - 1)) {
                for (int i2 = SIZE - 1; i2 >= 0; i2--) {
                    if (map[i2][i2] == DOT_EMPTY) {
                        x = i2;
                        y = i2;
                        z += 1;
                    }
                }
            }
        }
    if(z == 0) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);

            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер походил в точку " + ( x + 1) + " " + (y + 1));
        map[y][x] = DOT_0;
    }
// *************************************************************************************************

    public static boolean checkWin (char symb){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0, count = 0; j < SIZE; j++){
                if (map[i][j] == symb){
                    count += 1;
                }
                if (count == SIZE){
                    return true;
                }
            }
            for(int j = 0,  count = 0; j < SIZE; j++){
                if (map[j][i] == symb){
                    count += 1;
                }
                if (count == SIZE){
                    return true;
                }
            }
        }
        for (int i = SIZE - 1, count = 0, j = 0; i >= 0; i--, j++){
                if (map[i][j] == symb){
                    count += 1;
                }
                if (count == SIZE){
                    return true;
                }
            }
        for (int i = SIZE - 1, count = 0; i >= 0; i--){
            if (map[i][i] == symb){
                count += 1;
            }
            if (count == SIZE){
                return true;
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
//**********************************************************************************************
    public static void main(String[] args) {
    initMap();
    printMap();
    while (true) {
        humanTurn();
        printMap();
        move += 1;
        if(move > 2) {
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        aiTurn();
        printMap();
        if(move > 2) {
            if (checkWin(DOT_0)) {
                System.out.println("Победил Искуственный Интелект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }
        System.out.println("Игра закончена");
    }
}


