package com.example.cloud;

/**
 * @author yuweijun 2017-11-23.
 */

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OkHttpClient client;

    private Random random = new Random();

    @RequestMapping("service1")
    public String start() throws InterruptedException, IOException {
        int sleep = randomSleepMillis();
        Request request = new Request.Builder().url("http://localhost:9092/service2").get().build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return " [service1 sleep " + sleep + " ms]" + result;
    }

    @RequestMapping("service2")
    public String service2() throws InterruptedException, IOException {
        int sleep = randomSleepMillis();
        Request request = new Request.Builder().url("http://localhost:9093/service3").get().build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        request = new Request.Builder().url("http://localhost:9094/service4").get().build();
        response = client.newCall(request).execute();
        result += response.body().string();
        return " [service2 sleep " + sleep + " ms]" + result;
    }

    @RequestMapping("service3")
    public String service3() throws InterruptedException, IOException {
        int sleep = randomSleepMillis();
        Request request = new Request.Builder().url("http://localhost:9094/service4").get().build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return " [service3 sleep " + sleep + " ms]" + result;
    }

    @RequestMapping("service4")
    public String service4() throws InterruptedException, IOException {
        int sleep = randomSleepMillis();
        return " [service4 sleep " + sleep + " ms]";
    }

    private static int randomSleepMillis() {
        try {
            int timeout = new Random().nextInt(100);
            TimeUnit.MILLISECONDS.sleep(timeout);
            return timeout;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

}