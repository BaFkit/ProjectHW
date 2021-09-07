package Lesson5;

public class Employee {  // Homework for Lesson 5

    int id;
    String name;
    String surname;
    String position;
    String email;
    long numPhone;
    double salary;
    int age;

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

    public static void employeeInfo (Employee emp){
        System.out.println("Сотрудник под номером: " + emp.id);
        System.out.println("Имя: " + emp.name);
        System.out.println("Фамилия: " + emp.surname);
        System.out.println("Должность: " + emp.position);
        System.out.println("E-mail: " + emp.email);
        System.out.println("Номер телефона: " + emp.numPhone);
        System.out.println("Зарплата: " + emp.salary);
        System.out.println("Возраст: " + emp.age);
    }

    public static void  employeesOlder_40(Employee[] arr){
        int count = 0;
        for (Employee i: arr) {
            if (i.age > 40){
                count += 1;
            }
        }
        if (count > 0) {
            String s;
            if (count == 1){
                s = " сотрудник";
            }else if (count < 5){
                s = " сотрудника";
            }else {
                s = " сотрудников";
            }
            System.out.println("Имеются " + count + s +" возрастом старше 40 лет:");
            for (Employee i : arr) {
                if (i.age > 40) {
                    System.out.println("Сотрудник: " + i.name + " " + i.surname);
                }
            }
        }
    }


    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee(1, "Anton", "Zaytsev",  "Engineer", "AZaytsev@gmail.com", 89231231245L, 45000.0, 41);
        empArray[1] = new Employee(2, "Viktor", "Vasilyev",  "Junior engineer", "VVasilyev@gmail.com", 89241632223L, 35000.0, 29);
        empArray[2] = new Employee(3, "Pyotr", "Vorobyov",  "Department head", "PVorobyov@gmail.com", 89443215678L, 52000.0, 53);
        empArray[3] = new Employee(4, "Anastasia", "Aleksandrova",  "Manager", "Aleksandrova@gmail.com", 89773121987L, 39000.0, 33);
        empArray[4] = new Employee(5, "Yelena", "Yeremeyeva",  "Secretary", "YYeremeyeva@gmail.com", 89665860044L, 30000.0, 31);

        employeeInfo(empArray[2]);
        System.out.println("*********************************************");
        employeesOlder_40(empArray);


    }
}
