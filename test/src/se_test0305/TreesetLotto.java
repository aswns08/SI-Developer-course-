package se_test0305;

import java.util.Random;
import java.util.TreeSet;

public class TreesetLotto {
	public void lotto() {
		Random rd = new Random() ;
		TreeSet ts = new TreeSet() ;	
		while(true) {
			ts.add(rd.nextInt(45)+1) ;	
			//TreeSet().add : Adds the specified element to this set if it is not already present.
			//				  �̹� �������������� �߰�!
			
			if(ts.size()==6)
				break ;
		}
		
		System.out.println(ts);
	}	

}