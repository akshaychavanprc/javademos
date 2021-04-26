package com.emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

	@Autowired
	EmployeeReposistory repository;
	
	public List<EmployeeEntity> getAllEmployee(){
		List<EmployeeEntity> employeeList=repository.findAll();
		if(employeeList.size()>0) {
			return employeeList;
		}
		else
			return new ArrayList<EmployeeEntity>();
	}
	
	
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException{
		Optional<EmployeeEntity> employee=repository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else 
		{
			throw new RecordNotFoundException("No employee record found");
		}
	}
	
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException{
		Optional<EmployeeEntity> employee=repository.findById(entity.getId());
		if(employee.isPresent()) {
			EmployeeEntity newEntity=employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFistName(entity.getFistName());
			newEntity.setLastName(entity.getLastName());
			newEntity=repository.save(newEntity);
			return newEntity;
		}
		else {
			entity=repository.save(entity);
			return entity;
		}
	}
	
	public void deleteEmployeeById(Long id) throws RecordNotFoundException{
		Optional<EmployeeEntity> employee=repository.findById(id);
		if(employee.isPresent()) {
			repository.deleteById(id);
		}
		else {
			throw new RecordNotFoundException("No employee found to delete");
		}
	}
	
}
