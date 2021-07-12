package com.spring.payroll;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
	//It is based on converting a non-model object (Employee) 
	//into a model-based object (EntityModel<Employee>)
	@Override
	public EntityModel<Employee> toModel(Employee employee) {
		return EntityModel.of(employee, 
				//asks Spring HATEOAS build a link to the 
				//EmployeeController's one() method, and flags it as a self link
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
				//asks Spring HATEOAS to build a link to the 
				//aggregate root, all(), and call it "employees".
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withRel("employees"));
	}
}