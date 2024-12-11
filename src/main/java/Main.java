public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich", "Analyst", "IvanAnal@gmail.com", 880055535, 30, 19);

        employee1.employeePrint();

        Employee[] employeesList = new Employee[5];
        employeesList[0] = employee1;
        employeesList[1] = new Employee("Ptrov", "Petr", "Petrovich", "Developer", "PetrDev@gmail.com", 880055535, 30, 34);
        employeesList[2] = new Employee("Baranov", "Kirill", "Vasilievich", "Project Manager", "KirilPM@gmail.com", 880055535, 30, 22);
        employeesList[3] = new Employee("Malov", "Evgeniy", "Nikolaevich", "QA Engineer", "EvgeniyQA@gmail.com", 880055535, 30, 27);
        employeesList[4] = new Employee("Sverchkov", "Egor", "Aleksandrovich", "Developer", "EgorDev@gmail.com", 880055535, 30, 32);


        Park disney = new Park("Disnay Land", "Street 6", "10:00AM - 6:00PM");

        System.out.println();
        System.out.println(disney.ferrisWheel.getFerrisWheelPrice());
        System.out.println(disney.ferrisWheel.getFerrisWheelWorkTime());

        System.out.println(disney.shootingGallery.getShootingGalleryPrice());
        System.out.println(disney.shootingGallery.getShootingGalleryWorkTime());


    }

}
