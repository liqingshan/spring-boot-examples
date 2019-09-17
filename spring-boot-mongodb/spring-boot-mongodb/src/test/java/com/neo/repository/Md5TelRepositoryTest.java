package com.neo.repository;

import com.neo.model.Md5TelDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

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

    class RunnableDemo implements Runnable {
        private Thread t;
        private String threadName;
        private int mongoSeq;

        RunnableDemo( String name, int index) {
            threadName = name;
            mongoSeq = index;
            System.out.println("Creating " +  threadName );
        }

        public void run() {
            //System.out.println("Running " +  threadName );
            Md5TelDO md5TelDO = new Md5TelDO();
            for(int i = mongoSeq; i < mongoSeq + 10000000; i++) {

                String tel = String.format("%11d", i);
                String encodeStr= DigestUtils.md5DigestAsHex(tel.getBytes());
                md5TelDO.setMd5(encodeStr);
                md5TelDO.setTelephone(String.format("%d", i));
                md5TelRepository.saveMd5Tel(md5TelDO);
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }

        public void start () {
            System.out.println("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }

    @Test
    public void saveMd5Tel() {
        Md5TelDO md5TelDO = new Md5TelDO();
        String tel = "111";
        String encodeStr = DigestUtils.md5DigestAsHex(tel.getBytes());
        md5TelDO.setMd5(encodeStr);
        md5TelDO.setTelephone(tel);
        md5TelRepository.saveMd5Tel(md5TelDO);
    }

    @Test
    public void test000() throws Exception {

        int tNum = 50;
        Md5TelRepositoryTest.RunnableDemo[] tArray = new Md5TelRepositoryTest.RunnableDemo[tNum];
        for (int i = 0; i< tNum; i++) {
            tArray[i] = new Md5TelRepositoryTest.RunnableDemo(String.format("thread-%d", i), i * 10000000);
            tArray[i].start();
        }

        while (true) {

        }
    }
}