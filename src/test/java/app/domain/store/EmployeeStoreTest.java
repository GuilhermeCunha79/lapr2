/*package app.domain.store;

import app.mappers.dto.EmpDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeStoreTest{

    EmployeeStore emps = new EmployeeStore();

    @Test(expected = NullPointerException.class)
    public void testEmployeeNullIsNotCreated(){
        emps.newEmployee(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmployeeWithEmptyNameIsNotCreated(){
        EmpDto empDto = new EmpDto("receptionist", "", "sdvdsv", "12121212121", "afdsfa@gmail.com", "1234");
        emps.newEmployee(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmployeeWithEmptyAddressIsNotCreated(){
        EmpDto empDto = new EmpDto("receptionist", "Asdvdsv", "", "12121212121", "afdsfa@gmail.com", "1234");
        emps.newEmployee(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmployeeWithEmptyPhoneNumberIsNotCreated(){
        EmpDto empDto = new EmpDto("receptionist", "Asdvdsv", "sfadsfa", "", "afdadaffa@gmail.com", "1234");
        emps.newEmployee(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmployeeWithEmptyEmailIsNotCreated(){
        EmpDto empDto = new EmpDto("receptionist", "Asdvdsv S", "sfadsfa", "12121232121", "", "1234");
        emps.newEmployee(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmployeeWithEmptySocIsNotCreated(){
        EmpDto empDto = new EmpDto("receptionist", "Asdvdsv V", "sfadsfa", "12131232121", "afsaaasdsfa@gmail.com", "");
        emps.newEmployee(empDto);
    }

    @Test(expected = NullPointerException.class)
    public void testSpecialistDoctorNullIsNotCreated(){
        emps.newSpecialistDoctor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialistDoctorWithEmptyNameIsNotCreated(){
        EmpDto empDto = new EmpDto("specialist doctor", "", "asdvdsv", "12121212121", "aadsvavasva@gmail.com", "1234", "123456");
        emps.newSpecialistDoctor(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialistDoctorWithEmptyAddressIsNotCreated(){
        EmpDto empDto = new EmpDto("specialist doctor", "asdvdsv", "", "12121212121", "adasffdsfa@gmail.com", "1334", "543211");
        emps.newSpecialistDoctor(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialistDoctorWithEmptyPhoneNumberIsNotCreated(){
        EmpDto empDto = new EmpDto("specialist doctor", "asdvdsv", "sfadsfa", "", "advasdva@gmail.com", "1413", "098675");
        emps.newSpecialistDoctor(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialistDoctorWithEmptyEmailIsNotCreated(){
        EmpDto empDto = new EmpDto("specialist doctor", "Asdvdsv", "sfadsfa", "12121272121", "", "1231", "211341");
        emps.newSpecialistDoctor(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialistDoctorWithEmptySocIsNotCreated(){
        EmpDto empDto = new EmpDto("specialist doctor", "asdvdsv", "sfadsfa", "12132232121", "adadsca@gmail.com", "", "123123");
        emps.newSpecialistDoctor(empDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialistDoctorWithEmptyDocIndexNumIsNotCreated(){
        EmpDto empDto = new EmpDto("specialist doctor", "asdvdsv", "sfadsfa", "12121232121", "adadcadasdf@gmail.com", "6543", "");
        emps.newSpecialistDoctor(empDto);
    }

    @Test
    public void testisSpecialistDoctorMethod(){
        assertTrue(emps.isSpecialistDoctor("specialist doctor"));
    }

    @Test
    public void testIfisSpecialistDoctorMethodReturnsFalse(){
        assertFalse(emps.isSpecialistDoctor("administrator"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfisSpecialistDoctorMethodReturnsExceptionIfRoleDoesntExist(){
        emps.isSpecialistDoctor("fireman");
    }


}*/