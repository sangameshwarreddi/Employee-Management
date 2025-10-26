package com.employees.management;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@CrossOrigin(origins = "*")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

@GetMapping("/getAllEmployees")
public List<Employee> getAllEmp() {
    return employeeService.getAllEmployees();
}

@GetMapping("updateEmployee/{id}")
public Employee getMethodName(@PathVariable("id") int id) {
    return employeeService.getEmployeebyID(id);
}
@DeleteMapping("/delemployee/{empid}")
public ResponseEntity<String> delemployee(@PathVariable("empid") int id){
    Employee emp = employeeService.getEmployeebyID(id);
    if(emp == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Employee not found");
    }

    employeeService.deleteEmployee(id);
    return ResponseEntity.ok("Employee deleted successfully");
}


@PostMapping("/AddEmployee")
public void AddEmployee(@RequestBody Employee employee) {
employeeService.addEmployee(employee);
}


@PutMapping("employee/update/{id}")
public void update(@PathVariable int id, @RequestBody Employee entity) {
    
employeeService.update(id,entity);
}



}
