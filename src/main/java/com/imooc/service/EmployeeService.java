package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private Employee employee;
    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }

    public List<Employee> findAll(){return employeeRepository.findAll();}
}
