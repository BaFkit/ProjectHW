package Lesson5;

public class Employee {  // Homework for Lesson 5

    private int id;
    private String name;
    private String surname;
    private String position;
    private String email;
    private long numPhone;
    private double salary;
    public int age;

    Employee(){
    }

    Employee(int id, String name, String surname, String position, String email, long numPhone, double salary, int age){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.numPhone = numPhone;
        this.salary = salary;
        this.age = age;
    }

    public void employeeInfo (){
        System.out.println("Сотрудник под номером: " + id);
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Должность: " + position);
        System.out.println("E-mail: " + email);
        System.out.println("Номер телефона: " + numPhone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }


    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee(1, "Anton", "Zaytsev",  "Engineer", "AZaytsev@gmail.com", 89231231245L, 45000.0, 41);
        empArray[1] = new Employee(2, "Viktor", "Vasilyev",  "Junior engineer", "VVasilyev@gmail.com", 89241632223L, 35000.0, 29);
        empArray[2] = new Employee(3, "Pyotr", "Vorobyov",  "Department head", "PVorobyov@gmail.com", 89443215678L, 52000.0, 53);
        empArray[3] = new Employee(4, "Anastasia", "Aleksandrova",  "Manager", "Aleksandrova@gmail.com", 89773121987L, 39000.0, 33);
        empArray[4] = new Employee(5, "Yelena", "Yeremeyeva",  "Secretary", "YYeremeyeva@gmail.com", 89665860044L, 30000.0, 31);

        for (Employee i : empArray){
            if (i.age > 40 )
                i.employeeInfo();
            System.out.println();
        }
    }
}
