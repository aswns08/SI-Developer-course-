package daejeon.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Receive_BoardVO {
	BoardVO article ;
	int i=1 ;
	
	public void receive(ArrayList<BoardVO> articleList) {
		
		System.out.println("<<<<< Iterator 사용 >>>>> ");
		
		Iterator<BoardVO> it = articleList.iterator();
		
		while(it.hasNext()) {
			article = it.next();
			System.out.println(i+" " + article.getArticle_num());
			System.out.println(i+" " + article.getId());
			System.out.println(i+" " + article.getTitle());
			System.out.println(i+" " + article.getContent());
			i++ ;
		}
		System.out.println("*******************************************") ;
		System.out.println("<<<<< For each문 >>>>> ");
		//For each문을 이용하는 방법
		System.out.println("size = " + articleList.size());
		
		for(BoardVO aa : articleList) {
			System.out.println(i+" " + article.getArticle_num());
			System.out.println(i+" " + article.getId());
			System.out.println(i+" " + article.getTitle());
			System.out.println(i+" " + article.getContent());
			i++ ;		
		}
		
	}

}
