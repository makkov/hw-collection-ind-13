package hwcollectionsind13.hwcollectionsind13.service;

import hwcollectionsind13.hwcollectionsind13.exception.EmployeeAlreadyAddedException;
import hwcollectionsind13.hwcollectionsind13.exception.EmployeeNotFoundException;
import hwcollectionsind13.hwcollectionsind13.exception.EmployeeStorageIsFullException;
import hwcollectionsind13.hwcollectionsind13.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int MAX_SIZE = 2;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String firstName, String lastName) {

        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переополнен.");
        }

        String key = getKey(firstName, lastName);

        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть.");
        }

        Employee newEmployee = new Employee(firstName, lastName);

        employees.put(key, newEmployee);

        return newEmployee;
    }

    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Невозможно удалить. Такого сотрудника не существует.");
        }

        Employee employeeForRemove = employees.get(key);

        employees.remove(key);
        return employeeForRemove;
    }

    public Employee get(String firstName, String lastName) {
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника не существует.");
        }

        return employees.get(key);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
