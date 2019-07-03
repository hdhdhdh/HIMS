package test.com;

import com.whut.bean.Patient;
import com.whut.bean.Prescription;
import com.whut.bean.Type;
import com.whut.dao.IPrescriptionDao;
import com.whut.dao.ITypeDao;
import com.whut.enums.GenderEnum;
import com.whut.service.IAppointmentService;
import com.whut.service.IPatientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

public class PrescriptionDaoTest extends BaseTest
{
//    @Autowired
//    private IPrescriptionDao iPrescriptionDao;
//
//    @Test
//    public void addPrescriptionTest() throws Exception {
//        Prescription prescription = new Prescription();
//        prescription.setC_id(723);
//        prescription.setM_id("86900373000051");
//        prescription.setPr_date(new Date() );
//    }
//    @Test
//    public void updateTypeTest() throws Exception {
//        Type type = new Type();
//        type.setT_id("99");
//        type.setT_name("test1");
//        iTypeDao.updateType(type);
//    }
//    @Test
//    public void getTypeByIdTest() throws Exception {
//        System.out.println(iTypeDao.getTypeById("99"));
//    }
//    @Test
//    public void getAllTypeTest() throws Exception {
//        List<Type> types = iTypeDao.getAllType();
//        for(Type type:types)
//            System.out.println(type);
//    }
//    @Test
//    public void deleteType() throws Exception {
//        iTypeDao.deleteType("99");
//    }
}