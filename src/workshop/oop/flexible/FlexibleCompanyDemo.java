package workshop.oop.flexible;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

		MereClerk mereClerk1 = new MereClerk("철수", 100);
		MereClerk mereClerk2 = new MereClerk("영희", 100);
		Manager manager = new Manager("홍길동", 200);

		Manager hrMgr = new Manager("하늘", 200, "HR");
		System.out.println(hrMgr.getName());
		System.out.println(hrMgr.getSalary());
		System.out.println(hrMgr.getDept());

		// 다형성
		Employee itMgr = new Manager("보리", 200, "IT");
		System.out.println(itMgr.getSalary());

//        System.out.println(itMgr.getDept()); 상속해서 내려오지 않았기 때문에
		// Manager(자식) 가 가진 getDept 호출
		Manager itMgr2 = (Manager) itMgr;
		System.out.println(itMgr2.getName());
		System.out.println(itMgr2.getDept());

		// Heterogeneous Collection
		Employee[] emps = new Employee[4];

		emps[0] = new Manager("길동", 250, "it");
		emps[1] = new MereClerk("철수", 150);
		emps[2] = new MereClerk("영희", 100);
		emps[3] = new Manager("둘리", 200, "HR");
		System.out.println("현재 월급입니다.");
		
		printEmployeeeInfo(emps);
		
		for (Employee emp : emps) {
			emp.manageSalary(10);
		}

		System.out.println("인상 후 월급");

		for (Employee emp : emps) {
			System.out.println(emp.getName() + "의 인상 후 월급은 " + emp.getSalary() + " 만원 입니다.");
		}
		// List<Employee> emps2 = new ArrayList<Employee>();

	}

	public static void printEmployeeeInfo(Employee[] emps) {
		for (Employee emp : emps) {
			
			if (emp instanceof Manager) {
				
				System.out.print("관리자 부서명 : "+((Manager)emp).getDept() + " ");
				
			}
			
			
			System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");
			
		}
	}
}
