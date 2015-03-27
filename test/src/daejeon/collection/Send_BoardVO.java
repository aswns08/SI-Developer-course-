package daejeon.collection;

import java.util.ArrayList;

public class Send_BoardVO {
	Receive_BoardVO rb ;
	ArrayList<BoardVO> articleList ;
	BoardVO article ;
	
	int time ;
	
	public void send() {
		articleList = new ArrayList<>() ;
		
		while(time<10) {
			article = new BoardVO() ;
			article.setArticle_num(1);
			article.setId("a");
			article.setContent("내용");
			article.setTitle("졸지마세요");
			articleList.add(article);
			time++ ;
		}
		
		rb = new Receive_BoardVO() ;
		rb.receive(articleList);
	}

}
