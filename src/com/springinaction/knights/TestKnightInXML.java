package com.springinaction.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestKnightInXML {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./META-INF/spring/knights.xml");
		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();
	}
}
