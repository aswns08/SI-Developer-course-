

import java.util.Iterator;
import java.util.Vector;

public class ChatControl extends Vector<ChatThread>{
	
	
	public synchronized void addChatThread(ChatThread ct){
	//동시에 들어오게되면 두개다 제대로들어오지못하기때문에 -> 동기화 -> 한번에 한개만 추가되도록
		this.add(ct);	//벡터에 있는 add() => 자동동기화기능o
	}
	
	public synchronized void removeChatThread(ChatThread ct){
	//추가와  삭제가 동시에일어날 수 도있기때문에 -> 동기화
		if(this.contains(ct)){	//이 클래스에 ct가 있으면 (thread가 여러개이기때문에 원하는 것을 찾기위해서 참조값 비교) 
			this.remove(ct);	//그것을 제거
			//== 연산자 : 참조값 비교 (= equals)
		}		
	}
	
	public synchronized void sendAllmessage(String msg){		
		Iterator<ChatThread> it=this.iterator();
		while(it.hasNext()){
			ChatThread ct = it.next();	
			System.out.println(ct.toString()+"에서 접속");
			ct.sendMessage(msg);
		}
	}
}
