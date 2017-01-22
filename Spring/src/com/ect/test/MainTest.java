package com.ect.test;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.propertyeditors.InputSourceEditor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.support.ServletContextResource;

import com.ect.domain.User;

public class MainTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String filePath = "D:/tools/apache-tomcat-7.0.69/wtpwebapps/Spring/WEB-INF/classes/conf/test.txt";
//		Resource res1 =  new FileSystemResource(filePath);
//		Resource res2 = new ClassPathResource("conf/testFromClassPath.txt");
//		//Resource res3 = new ServletContextResource(application, path);
//		
//		byte[] byteStr =  new byte[100];
//		res1.getInputStream().read(byteStr);
//		
//		byte[] byteStr2 =  new byte[100];
//		res2.getInputStream().read(byteStr2);
//		
//		byte[] byteStr3 =  new byte[100];
//		res2.getInputStream().read(byteStr2);
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:com/ect/resources/beans.xml");
		BeanFactory bFactory  =  new XmlBeanFactory(resource);
		
		System.out.println("init..........");
		User user = bFactory.getBean("user", User.class);
		
		
		System.out.println("user:" + user);
	}

}
