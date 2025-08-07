package workshop.person.control;

import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManager {

	public static void main(String[] args) {
		PersonManager personMgr = new PersonManager();

		Scanner Sc = new Scanner(System.in);

		System.out.print("성별을 입력하세요 :");
		String inputvalue = Sc.next();
		char gender = inputvalue.charAt(0);

		System.out.println("이릅을 입력하세요 :");
		String name = Sc.next();
		
		System.out.println(String.format("성별은 %s자, 이름은 %s", gender,name));
		
		
		Sc.close();
		personMgr.printTitle("인물정보 조회시스템");

		PersonEntity[] persons = new PersonEntity[10];
		// persons 변수는 PersonEntity
		personMgr.FillPersons(persons);

		// for loop로 순회한다
		personMgr.showPerson(persons);

		String message = String.format("입력결과 성별 : %s자 는  %d명 입니다.", gender, personMgr.findbyGender(persons, gender));
		System.out.println(message);
		// System.out.println("남자는"+ personMgr.findbyGender(persons, '남') + "명 입니다.");
		personMgr.showPerson(persons,name);
		

	}

	public void showPerson(PersonEntity[] persons) {
		for (PersonEntity p : persons) {
			System.out.println("[이름] " + p.getName() + " \t [성별] " + p.getGender() + " \t [전화번호] " + p.getPhone());
		}
	}
	
	//override 구현
	public void showPerson(PersonEntity[] persons,String name) {
		for (PersonEntity p : persons) {
			if (p.getName().equals(name)) {
				System.out.println("[이름] " + p.getName());
				System.out.println("[성별] " + p.getGender());
				System.out.println("[전번] " + p.getPhone());
				System.out.println("[주소] " + p.getAddress());
				
				break;
			}
		}
		
	}

	public void FillPersons(PersonEntity[] persons) {
		persons[0] = new PersonEntity("이성호", "7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘", "7302132363217", "서울 강동구", "02-362-1932");
		persons[2] = new PersonEntity("박영수", "7503111233201", "서울 성북구", "02-887-1542");
		persons[3] = new PersonEntity("나인수", "7312041038988", "대전 유성구", "032-384-2223");
		persons[4] = new PersonEntity("홍정수", "7606221021341", "서울 양천구", "02-158-7333");
		persons[5] = new PersonEntity("이미숙", "7502142021321", "서울 강서구", "02-323-1934");
		persons[6] = new PersonEntity("박성구", "7402061023101", "서울 종로구", "02-308-0932");
		persons[7] = new PersonEntity("유성미", "7103282025101", "서울 은평구", "02-452-0939");
		persons[8] = new PersonEntity("황재현", "7806231031101", "인천 중구", "032-327-2202");
		persons[9] = new PersonEntity("최철수", "7601211025101", "인천 계양구", "032-122-7832");
	}

	public int findbyGender(PersonEntity[] persons, char gender) {
		int genderCnt = 0;

		for (PersonEntity p : persons) {
			if (p.getGender() == gender) {
				genderCnt++;
			}
		}

		return genderCnt;
	}
	
	
	
	public void printTitle(String title) {
		System.out.println("@@@@ " + title + " @@@@");
		System.out.println();
	}

}