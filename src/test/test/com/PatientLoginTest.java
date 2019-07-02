package test.com;

import com.whut.bean.Patient;
import com.whut.service.IPatientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientLoginTest extends BaseTest
{
    @Autowired
    private IPatientService iPatientService;

    @Test
    public void testAppoint() throws Exception {
        Patient patient = new Patient();
        patient.setP_id("432132199911247289");
        patient.setP_password("522");
        System.out.println(iPatientService.patientLogin(patient));
    }

}

