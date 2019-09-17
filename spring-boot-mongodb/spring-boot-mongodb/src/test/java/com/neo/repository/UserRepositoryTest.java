package com.neo.repository;

import com.neo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by summer on 2017/5/5.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    private UserRepository userDao;

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
            User user=new User();
            for(int i = mongoSeq; i < mongoSeq + 10000000; i++) {
                user.setId((long)i);
                user.setUserName(String.format("%d",i));
                user.setPassWord("fffooo123");
                userDao.saveUser(user);
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
    public void test000() throws Exception {

        int tNum = 50;
        RunnableDemo[] tArray = new RunnableDemo[tNum];
        for (int i = 0; i< tNum; i++) {
            tArray[i] = new RunnableDemo(String.format("thread-%d", i), i * 10000000);
            tArray[i].start();
        }

        while (true) {

        }
    }

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userDao.saveUser(user);
    }

    @Test
    public void testSaveBatchUser() throws Exception {
        User user = new User();
        for (int i = 0; i < 10000000; i++) {
            user.setId((long)i);
            user.setUserName(String.format("%d",i));
            user.setPassWord("fffooo123");
            userDao.saveUser(user);
        }
    }

    @Test
    public void findUserByUserName(){
       User user= userDao.findUserByUserName("小明");
       System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userDao.deleteUserById(1l);
    }

}
