package test.com;

import com.whut.bean.Patient;
import com.whut.bean.Type;
import com.whut.dao.IMedicineDao;
import com.whut.dao.ITypeDao;
import com.whut.enums.GenderEnum;
import com.whut.service.IAppointmentService;
import com.whut.service.IPatientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MedicineDaoTest extends BaseTest
{
    @Autowired
    IMedicineDao iMedicineDao;
    @Test
    public void otherTest() throws Exception
    {
        System.out.println(iMedicineDao.getMedicineByName("林"));
    }
}