package test.com;

import com.whut.bean.Patient;
import com.whut.enums.GenderEnum;
import com.whut.service.IPatientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class PatientServiceTest extends BaseTest
{
    @Autowired
    private IPatientService iPatientService;

    @Test
    public void patientLoginTest() throws Exception {
        Patient patient = new Patient();
        patient.setP_id("432132199911247289");
        patient.setP_password("522");
        System.out.println(iPatientService.patientLogin(patient));
    }
    @Test
    public void addPatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setP_id("432132199911247288");
        patient.setP_name("sfh");
        patient.setP_birthday( new Date());
        patient.setP_gender(GenderEnum.MEAL.getGender());
        patient.setP_password("522");
        System.out.println(iPatientService.addPatient(patient));
    }
    @Test
    public void appointment() throws Exception {
        System.out.println(iPatientService.appointment("432132199911247289","0102"));
    }

}
