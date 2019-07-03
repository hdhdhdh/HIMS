package test.com;

import com.whut.bean.Patient;
import com.whut.bean.Type;
import com.whut.dao.ITypeDao;
import com.whut.enums.GenderEnum;
import com.whut.service.IAppointmentService;
import com.whut.service.IPatientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TypeDaoTest extends BaseTest
{
    @Autowired
    private ITypeDao iTypeDao;

    @Test
    public void addTypeTest() throws Exception {
        Type type = new Type();
        type.setT_id("99");
        type.setT_name("test");
        iTypeDao.addType(type);
    }
    @Test
    public void updateTypeTest() throws Exception {
        Type type = new Type();
        type.setT_id("99");
        type.setT_name("test1");
        iTypeDao.updateType(type);
    }
    @Test
    public void getTypeByIdTest() throws Exception {
        System.out.println(iTypeDao.getTypeById("99"));
    }
    @Test
    public void getAllTypeTest() throws Exception {
        List<Type> types = iTypeDao.getAllType();
        for(Type type:types)
            System.out.println(type);
    }
    @Test
    public void deleteType() throws Exception {
        iTypeDao.deleteType("99");
    }
}