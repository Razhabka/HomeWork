public class Employee {

    private String lastName;
    private String firstName;
    private String surname;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public Employee(String lastName, String firstName, String surname, String position, String email, long phoneNumber, int salary, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void employeePrint(){
        System.out.println("Имя: " + firstName + "\nФамилия: " + lastName + "\nОтчество: " + surname +
                "\nДолжность: " + position + "\nemail: " + email + "\nТелефон: " + phoneNumber + "\nЗарплата: " + salary + "\nВозраст: " + age);
    }
}
