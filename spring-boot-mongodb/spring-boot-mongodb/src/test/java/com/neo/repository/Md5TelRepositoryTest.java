package com.neo.repository;

import com.neo.model.Md5TelDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liqingshan
 * Date: 2019-09-17
 * Time: 18:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Md5TelRepositoryTest {

    @Autowired
    private Md5TelRepository md5TelRepository;

    @Test
    public void saveMd5Tel() {
        Md5TelDO md5TelDO = new Md5TelDO();
        md5TelDO.setMd5("111");
        md5TelDO.setTelephone("111");
        md5TelRepository.saveMd5Tel(md5TelDO);
    }
}