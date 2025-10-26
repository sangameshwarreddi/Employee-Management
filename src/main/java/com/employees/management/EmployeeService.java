package com.employees.management;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    

    public Employee getEmployeebyID(int  id) {
          return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
      employeeRepository.deleteById(id);
    }

    public void addEmployee(Employee employee) {
       System.out.println("Saving employee: " + employee);
        employeeRepository.save(employee);
    }


 public void update(int id, Employee entity) {
    Employee current = getEmployeebyID(id);
    if (current == null) return;

    if (entity.getName() != null && !Objects.equals(entity.getName(), current.getName()))
        current.setName(entity.getName());

    if (entity.getEmail() != null && !Objects.equals(entity.getEmail(), current.getEmail()))
        current.setEmail(entity.getEmail());

    if (entity.getPosition() != null && !Objects.equals(entity.getPosition(), current.getPosition()))
        current.setPosition(entity.getPosition());

    if (entity.getSalary() != 0 && entity.getSalary() != current.getSalary())
        current.setSalary(entity.getSalary());

    if (entity.getLocation() != null && !Objects.equals(entity.getLocation(), current.getLocation()))
        current.setLocation(entity.getLocation());

    employeeRepository.save(current);
}

}
