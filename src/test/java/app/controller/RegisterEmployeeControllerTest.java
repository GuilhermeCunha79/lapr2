package app.controller;


import app.mappers.dto.EmpDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterEmployeeControllerTest {

    RegisterEmployeeController ctrl = new RegisterEmployeeController();

    @Test
    public void testNewEmployeeMethod(){
        EmpDto dto = new EmpDto("Receptionist", "John", "Street 101", "98984898989", "jon@gmail.com","1211");
        assertTrue(ctrl.newEmployee(dto));
    }

    @Test
    public void testNewSpecialistDoctorMethod(){
        EmpDto dto = new EmpDto("Receptionist", "John", "Street 101", "98989898989", "john@gmail.com","1231", "123456");
        assertTrue(ctrl.newSpecialistDoctor(dto));
    }

    @Test
    public void testIsSpecialistDoctor(){
        assertTrue(ctrl.isSpecialistDoctor("Specialist Doctor"));
    }

    @Test
    public void testIsNotSpecialistDoctor(){
        assertFalse(ctrl.isSpecialistDoctor("receptionist"));
    }

    @Test
    public void testSaveEmployeeMethod(){
        EmpDto dto = new EmpDto("Receptionist", "John", "Street 101", "98989898989", "john@gmail.com","1231", "123456");
        ctrl.newEmployee(dto);
        assertTrue(ctrl.saveEmployee());
    }

    @Test
    public void testCannotSaveSameEmployeeTwice(){
        EmpDto dto = new EmpDto("Receptionist", "John", "Street 101", "98989898989", "john@gmail.com","1231");
        ctrl.newEmployee(dto);
        ctrl.saveEmployee();
        ctrl.newEmployee(dto);
    }

    @Test
    public void testCannotSaveSameSpecialistDoctorTwice(){
        EmpDto dto = new EmpDto("Specialist doctor", "John", "Street 101", "98989888989", "johns@gmail.com","1931", "121456");
        ctrl.newSpecialistDoctor(dto);
        ctrl.saveEmployee();
        ctrl.newSpecialistDoctor(dto);
    }



}