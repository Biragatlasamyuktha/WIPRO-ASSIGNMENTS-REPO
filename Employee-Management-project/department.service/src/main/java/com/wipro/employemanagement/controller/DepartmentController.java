package com.wipro.employemanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.ProjectDTO;
import com.wipro.employemanagement.entity.Department;
import com.wipro.employemanagement.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully.");
    }
    @GetMapping("/dept/{id}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDept(@PathVariable Long id){
    	 return ResponseEntity.ok(departmentService.getEmployeeByDept(id));
    }
    @GetMapping("/{departmentId}/projects")
    public List<ProjectDTO> getAllProjectsUnderADepartment(@PathVariable Long departmentId) {
        return departmentService.getAllProjectsUnderADepartment(departmentId);
    }
}
