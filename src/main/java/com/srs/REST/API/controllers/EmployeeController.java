package com.srs.REST.API.controllers;

import com.srs.REST.API.dto.EmployeeDTO;
import com.srs.REST.API.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController  // add this annotation to make the class/file a controller for REST API methods
@RequestMapping(path="/employees")
public class EmployeeController {

    // the service layer handling business logic
    private final EmployeeService employeeService;

    // setting service for the controller
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {    // can name this method anything
    return employeeService.getAllEmployees();   // this name must be same as service method
    }

    // PathVariable => Binds the id path parameter to the employeeId method argument
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId) {
//        return new EmployeeDTO(employeeId, "emp1", LocalDate.of(2024,10,3), true);
        return employeeService.getEmployeeById(employeeId);
    }

    // url.../employees?sortBy=value&limit=101 ... can add more
//    @GetMapping
//    public String getData(@PathParam("sortBy") String sortBy, @PathParam("limit") Integer limit) {
//        return "Hello " + sortBy + " " + limit;
//    }

    // why datatype EmpDTO?
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
