package com.example.cloud.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuweijun 2017-11-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ReceiverTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

}