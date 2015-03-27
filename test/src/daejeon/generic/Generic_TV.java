package daejeon.generic;

import daejeon.collection.Tv_inter;

public interface Generic_TV extends Generic_parent<Tv_inter> {	//데이터베이스에 들어가는 Tv_inter만 받는 것
	@Override
	public void add(Tv_inter obj);

}
