package solid.single_responsibility.main.java.hr.persistence;


import solid.single_responsibility.main.java.hr.personnel.Employee;
import solid.single_responsibility.main.java.hr.personnel.FullTimeEmployee;
import solid.single_responsibility.main.java.hr.serializer.EmployeeFileSerializer;
import solid.single_responsibility.main.java.hr.personnel.PartTimeEmployee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
Helper method to perform CRUD operations on employees. In a production
application we could use the database for persistence. In this demo,
we are storing employees in the file system.
 */

public class EmployeeRepository {

    private final EmployeeFileSerializer employeeSerializer;
    private final String basePath;

    public EmployeeRepository(EmployeeFileSerializer employeeSerializer, String basePath){
        this.employeeSerializer = employeeSerializer;
        this.basePath = basePath;
    }

    public List<Employee> findAll(){

        // Employees are kept in memory for simplicity
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);

        Employee steve = new PartTimeEmployee("Steve Jones", 800);
        Employee magda = new PartTimeEmployee("Magda Iovan", 920);

        return Arrays.asList(anna, billy, steve, magda);
    }

    public void save(Employee employee) throws IOException {
        byte[] serializeEmployee = employeeSerializer.serializeEmployee(employee);
        Path path = Paths.get(basePath + "/" +employee.getFullName()
                .replace(" ","_") + ".rec");
        Files.write(path, serializeEmployee);
    }
}
