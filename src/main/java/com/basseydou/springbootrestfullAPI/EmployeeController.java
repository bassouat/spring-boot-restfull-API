package com.basseydou.springbootrestfullAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/get-all-employees")
    public List<EmployeeEntity> getAllEmployee(){
        List<EmployeeEntity> allEmployeelist = employeeRepository.findAll();
        return allEmployeelist;

    }

    @GetMapping("/get-employee/{id}")
    public EmployeeEntity getEmployeebyId(@PathVariable(value = "id") Integer employee_Id)

    {
        EmployeeEntity employeeEntity = employeeRepository.findById(employee_Id).get();

        return employeeEntity;
    }

    @PostMapping("/create-employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {

        EmployeeEntity savedEmployee = employeeRepository.save(employee);

        return savedEmployee;
    }

    @PutMapping("/update-employees/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Integer employee_Id,
                                                         @RequestBody EmployeeEntity employeeDetails) {
        EmployeeEntity employee = employeeRepository.findById(employee_Id).get();

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setName(employeeDetails.getName());
        employee.setLocation(employeeDetails.getLocation());
        final EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete-employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employee_Id)
    {
        EmployeeEntity employee = employeeRepository.findById(employee_Id).get();

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
