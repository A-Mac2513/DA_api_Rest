package com.restapi.departmentdb_demo.resource;

import com.restapi.departmentdb_demo.persistence.Department;
import com.restapi.departmentdb_demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentResource {
    DepartmentService service;

    public DepartmentResource(DepartmentService service) {
        this.service = service;
    }

    @GetMapping (value = "/departments")
    public List<Department> getAll() {
       return this.service.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @PostMapping(value = "/departments")
    public Department add (Department department){
        return this.service.add(department);
    }

    @PutMapping(value = "/departments/{id}", consumes = "application/json")
    public Department update (@PathVariable Long id, @RequestBody Department department) {
        return this.service.update(id, department);
    }

    @DeleteMapping(value = "/departments/{id}")
    public void delete (@PathVariable Long id){
        this.service.delete(id);
    }
}
