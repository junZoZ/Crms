package xmu.crms.mapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassMapperTest {

    @Autowired
    private ClassMapper classMapper;

    private Log log = LogFactory.getLog(ClassMapperTest.class);
    @Test
    public void testGetClassByClassId() {

        log.info(classMapper.getClassByClassId(new BigInteger("2")));
    }
}
