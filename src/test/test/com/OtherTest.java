package test.com;

import com.whut.bean.Patient;
import com.whut.bean.Type;
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

public class OtherTest extends BaseTest
{
    @Test
    public void otherTest() throws Exception
    {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currdate = format.format(d);
        System.out.println(d.toString() );

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 1);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);
    }
}