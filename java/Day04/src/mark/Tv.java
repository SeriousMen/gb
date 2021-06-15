package mark;

public class Tv {

	//애니메이션은 "애니메이션입니다." ,애니메이션이 아니면 "애니메이션이 아닙니다." 라고 prinln으로 출력하는 메소드
	void checkAni(Video [] arVideo) { //비디오 탕비의 클래스 배열로 다담는다.
		String msg = null; // 일괄처리로 간단명료하게 만든다.
		for(int i =0; i< arVideo.length; i++) { 
			if(arVideo[i] instanceof Animation) { //이렇게 빈 인터페이스를 타입으로 활용해서 묶는다. -> 이게 애니메이션 타입이니?
//				System.out.println(arVideo[i]+"은(는) 애니메이션입니다.");
			msg = arVideo[i]+"은(는) 애니메이션입니다.";
			}else {
//				System.out.println(arVideo[i]+"은(는) 애니메이션이 아닙니다.");
				msg = arVideo[i]+"은(는) 애니메이션이 아닙니다.";
			}
			//일괄처리 --> 하나씩 묶어서 한번에 처리하고 넘어가고 해서 속도가 더빠르다. 
			System.out.println(msg);
		}
		
	}
	public static void main(String[] args) {
		Video[] arVideo = {
				new Zzangu(),
				new Titanic(),
				new Ddolbee(),
				new Dooly(),
		};
		new Tv().checkAni(arVideo);
		
	}
}
