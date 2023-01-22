package com.ssafy.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestApplication.class, args);
		System.out.println("뭐지?");
		String crawlingURL = "https://news.naver.com/main/ranking/popularDay.naver";

		Document document = Jsoup.connect(crawlingURL).get();
		System.out.println(document.select(".list_title"));
	}
}
