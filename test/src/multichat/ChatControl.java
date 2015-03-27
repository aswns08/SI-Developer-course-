package multichat;

import java.util.Iterator;
import java.util.Vector;

public class ChatControl extends Vector<ChatThread>{
	
	
	public synchronized void addChatThread(ChatThread ct){
	//���ÿ� �����ԵǸ� �ΰ��� ����ε��������ϱ⶧���� -> ����ȭ -> �ѹ��� �Ѱ��� �߰��ǵ���
		this.add(ct);	//���Ϳ� �ִ� add() => �ڵ�����ȭ���o
	}
	
	public synchronized void removeChatThread(ChatThread ct){
	//�߰���  ������ ���ÿ��Ͼ �� ���ֱ⶧���� -> ����ȭ
		if(this.contains(ct)){	//�� Ŭ������ ct�� ������ (thread�� �������̱⶧���� ���ϴ� ���� ã�����ؼ� ������ ��) 
			this.remove(ct);	//�װ��� ����
			//== ������ : ������ �� (= equals)
		}		
	}
	
	public synchronized void sendAllmessage(String msg){		
		Iterator<ChatThread> it=this.iterator();
		while(it.hasNext()){
			ChatThread ct = it.next();	
			System.out.println(ct.toString()+"���� ����");
			ct.sendMessage(msg);
		}
	}
}
