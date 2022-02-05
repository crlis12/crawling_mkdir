package test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) {
		// Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링
				String url = "http://www.cgv.co.kr/movies/"; //크롤링할 url지정
				Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
				Elements element = doc.select("div.sect-movie-chart");    

				System.out.println("============================================================");

				//Iterator을 사용하여 하나씩 값 가져오기
				Iterator<Element> ie1 = element.select("strong.rank").iterator();
				Iterator<Element> ie2 = element.select("strong.title").iterator();
				Iterator<Element> ie3 = element.select("span.txt-info").iterator(); //span class = 
				        
				while (ie2.hasNext()) {
					String second = ie2.next().text();
					System.out.println(ie1.next().text()+"\t"+second+"\t"+ie3.next().text());
					String path = "C:\\Users\\crlis\\OneDrive\\바탕 화면\\이클립스 실습\\폴더만들기\\" +second; // 폴더 경로
					File Folder = new File(path);

					// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
					if (!Folder.exists()) {
						try {
							Folder.mkdir(); // 폴더 생성합니다.
							System.out.println("폴더가 생성되었습니다.");
						} catch (Exception e) {
							e.getStackTrace();
						}
					} else {
						System.out.println("이미 폴더가 생성되어 있습니다.");
					}
				}
				
				System.out.println("============================================================");
				
		for (int i = 0; i < 5; i++) {

			
		}
	}
}