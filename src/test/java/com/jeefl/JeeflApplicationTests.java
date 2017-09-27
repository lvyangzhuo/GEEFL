package com.jeefl;

import com.jeefl.demo.controller.HelloWorldController;
import com.jeefl.demo.controller.JunitTestController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JeeflApplicationTests {

    @Autowired
    private JunitTestController junitTestController;

	@Test
	public void contextLoads() {
	}

	@Test
    public void test(){
        System.out.println("hello world");
    }



    @Test
    public void test2(){
        int sum = junitTestController.evaluate("2+2+3");
        Assert.assertEquals(7, sum);
        Assert.assertNotNull(sum);
    }

}
