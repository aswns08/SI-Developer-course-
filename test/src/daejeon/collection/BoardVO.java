package daejeon.collection;

public class BoardVO {
	private int article_num ;
	private String id ;
	private String content ;
	private String title ;
	
	//Get/Set Method
	public int getArticle_num() {
		return article_num;
	}
	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BoardVO [article_num=" + article_num + ", id=" + id
				+ ", conent=" + content + ", title=" + title + "]";
	}



}
