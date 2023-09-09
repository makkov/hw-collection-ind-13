package hwcollectionsind13.hwcollectionsind13.controller;

import hwcollectionsind13.hwcollectionsind13.model.Employee;
import hwcollectionsind13.hwcollectionsind13.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e) {
        return e.getMessage();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.get(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return employeeService.getAll();
    }
}
