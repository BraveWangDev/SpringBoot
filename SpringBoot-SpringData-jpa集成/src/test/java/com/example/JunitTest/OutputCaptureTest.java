package com.example.JunitTest;

import static org.junit.Assert.*;

import com.example.DemoApplication;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebAppConfiguration // 使用@WebIntegrationTest注解需要将@WebAppConfiguration注释
@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以指定端口
public class OutputCaptureTest {

	@Rule
	// 这里注意，使用@Rule注解必须要用public
	public OutputCapture capture = new OutputCapture();

	@Test
	public void outputCaptureTest(){

		System.out.println("");
		System.out.println("Hello");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld1");
		System.out.println("HelloWorld2");
		System.out.println("HelloWorld3");

		System.out.println(capture.toString());

		assertThat(capture.toString(), Matchers.containsString("HelloWorld"));

	}

}
