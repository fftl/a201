package com.ssafy.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestApplication.class, args);
		//간단하게 그냥 main 메소드에서 테스트 진행하였습니다.
		//gradle에서 jsoup을 추가 한 뒤 진행합니다.

		//내가 크롤링 하고자 하는 사이트의 링크를 담은 crawlingURL 입니다.
		String crawlingURL = "https://news.naver.com/main/ranking/popularDay.naver";

		//해당 URL을 담은 Jsoup document를 만듭니다.
		Document document = Jsoup.connect(crawlingURL).get();

		//document에서 select함수를 이용해 .list_title 클래스를 가진 모든 항목을 가져왔습니다!
		System.out.println(document.select(".list_title"));
	}
}
