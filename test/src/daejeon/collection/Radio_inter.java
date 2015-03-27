package daejeon.collection;

public class Radio_inter implements Elec_interface {

	@Override
	public void up() {
		System.out.println("Radio 클래스에서 볼륨 업");

	}

	@Override
	public void down() {
		System.out.println("Radio 클래스에서 볼륨 다운");
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "요놈은 Radio 클래스 입니다" ; 
	}

}
