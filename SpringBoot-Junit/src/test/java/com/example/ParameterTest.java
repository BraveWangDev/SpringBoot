package com.example;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {

	private String name;
	private String password;

	// 2,将@Parameters注解的方法中的Object数组中值的顺序对应
	public ParameterTest(String name, String password) {
		super();
		System.out.println("=== ParameterTest ===");
		this.name = name;
		this.password = password;
	}

	// 3,进入测试逻辑
	@Test
	public void test() {
		System.out.println("=== test ===");
		assertTrue(name.contains("Test")==true);
		assertTrue(password.equals("123"));
	}

	 // 1,返回Collection测试数据集合
	@Parameters
	public static Collection<?> data(){
		System.out.println("=== data ===");
		// Object 数组中值的顺序注意要和上面的构造方法ParameterTest的参数对应
		return Arrays.asList(new Object[][]{
				{"Test", "123"},
				{"ATest", "123"},
				{"bTest", "123"},
		});
	}
}