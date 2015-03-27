package daejeon.hastMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import daejeon.collection.Elec_interface;
import daejeon.collection.Radio_inter;
import daejeon.collection.Tv_inter;


public class HashMapTest {
	HashMap<String, Elec_interface> hm ;
	
	public void test() {
		hm = new HashMap<String, Elec_interface> () ;
		hm.put("1st", new Radio_inter());
		hm.put("2nd", new Tv_inter()) ;
		
		//1. key값을 Iterator로 리턴받음
		Iterator<String> it = hm.keySet().iterator();
		//=> Set<String> ss=hm.keySet() ;
		//   Iterator<String> it=ss.iterator() ;
		while(it.hasNext()) {
			System.out.println("key값만 출력 :" + it.next());
		}
		
		//2. value값을 Iterator로 리턴받음
		Iterator<Elec_interface> itt = hm.values().iterator();
		//Collection<Elec_interface> cc = hm.values() ;
		//Iterator <Elec_interface> itt = cc.iterator() ;
		while(itt.hasNext()) {
			Elec_interface ha = itt.next() ;
			ha.up();
		}
		
		System.out.println("******************************** ");
		
		//3. 특정 key값이 주어지면 key값에 해당한느 value값 가져오기
		Iterator<String> it2 = hm.keySet().iterator() ;
		while(it2.hasNext()) {
			Elec_interface ha1=hm.get(it2.next());
			ha1.up();
			ha1.down();
		}
	}

}
