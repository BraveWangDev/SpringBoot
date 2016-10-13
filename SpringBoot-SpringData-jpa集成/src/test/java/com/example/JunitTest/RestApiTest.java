package com.example.JunitTest;

import com.example.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebAppConfiguration // 使用@WebIntegrationTest注解需要将@WebAppConfiguration注释
@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以指定端口
public class RestApiTest {

	private String dateReg;
	private Pattern pattern;
	private RestTemplate template = new TestRestTemplate();

	@Value("${local.server.port}")// 注入端口号
	private int port;

	@Test
	public void testApi_Get() throws URISyntaxException {

		URI uri = new URI("http://tingapi.ting.baidu.com/v1/restserver/ting?" +
				"format=json%E6%88%96xml&calback=&from=webapp_music" +
				"&method=baidu.ting.billboard.billList&type=1&size=10&offset=0");
		String result = template.getForObject(uri, String.class);
		System.err.println("");
		System.err.println(result);

	}

	@Test
	public void testApi_Post() throws URISyntaxException {

		String url = "http://localhost:"+port+"/hello";
		System.out.println("");
		System.err.println("url = " + url);
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("Parameter1", "value1");
		map.add("Parameter2", "value2");
		String result = template.postForObject(url, map, String.class);
		System.err.println(result);

	}

}
