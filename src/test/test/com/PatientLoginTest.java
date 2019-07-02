package test.com;

import com.whut.service.IPatientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientLoginTest extends BaseTest
{
    @Autowired
    private IPatientService iPatientService;

    @Test
    public void testAppoint() throws Exception {
        System.out.println(iPatientService.patienLogin("432132199911247289"));
    }

}

