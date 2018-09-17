package com.example.cloud;

import com.netflix.servo.monitor.BasicTimer;
import com.netflix.servo.monitor.MonitorConfig;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author yuweijun
 * @date 2018-09-17
 */
public class ConsumerControllerTest {

    @Test
    public void test1() {
        MonitorConfig monitorConfig = new MonitorConfig.Builder("test").build();
        BasicTimer basicTimer = new BasicTimer(monitorConfig);
        System.out.println(ClassLayout.parseClass(BasicTimer.class).toPrintable());
        System.out.println(GraphLayout.parseInstance(basicTimer).toFootprint());
    }

}