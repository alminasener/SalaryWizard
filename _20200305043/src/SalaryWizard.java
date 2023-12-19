import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

public class SalaryWizard {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the SALARY WIZARD!\n");
        /* ArrayList sınıfının bir örneği olan employeeList adlı bir liste oluşturur.
        Kullanıcının girdiği her çalışanın bilgileri employeeList listesinde saklar.*/
        List<Employee> employeeList = new ArrayList<>();
        /*
        Çalışanların isimlerini kontrol etmek
        ve aynı isimde bir çalışanın daha önce eklenip
        eklenmediğini kontrol etmek amacıyla kullanılmıştır.
         */
        Set<String> employeeNamesSet = new HashSet<>();

        // 3 çalışanın bilgilerini kullanıcıdan almak için döngü oluşturuluyor.
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Employee " + (i + 1) + " info:");

            String name;
            do {
                System.out.print("Name:");
                name = scanner.nextLine();

                // Aynı isimde bir çalışanın daha önce eklenip eklenmediği kontrol ediliyor.(Set)
                if (employeeNamesSet.contains(name)) {
                    System.out.println("This name already exists. Please enter a different name.");
                }
            } while (employeeNamesSet.contains(name));

            // İsim daha önce eklenmemişse kümeye ekleniyor.
            employeeNamesSet.add(name);

            System.out.print("Salary:");
            double salary = scanner.nextDouble();

            // Yeni bir Çalışan nesnesi oluşturuluyor ve listeye ekleniyor.(Array)
            Employee employee = new Employee(name, salary);
            employeeList.add(employee);
        }

        // Predicate arayüzünü uygular. Bu lambda ifadesi, çalışanın maaşını kontrol eder ve maaşı 55.000'den yüksek olanları filtrelemek için kullanılır.
        List<Employee> highSalaryEmployees = filterEmployees(employeeList, e -> e.calculateSalary() > 55000);

        // Filtrelenmiş çalışanlar ekrana yazdırılıyor.
        System.out.println("\nEmployees whose salary is greater than 55000:");
        for (Employee employee : highSalaryEmployees) {
            employee.displayInfo();
        }
    }

    private static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            // Predicate tarafından belirtilen koşulu sağlayan çalışanlar filtrelenmiş liste üzerine ekleniyor.
            if (predicate.test(employee)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }
}
