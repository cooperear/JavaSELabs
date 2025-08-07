package workshop.oop.flexible;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

		MereClerk mereClerk1 = new MereClerk("ö��", 100);
		MereClerk mereClerk2 = new MereClerk("����", 100);
		Manager manager = new Manager("ȫ�浿", 200);

		Manager hrMgr = new Manager("�ϴ�", 200, "HR");
		System.out.println(hrMgr.getName());
		System.out.println(hrMgr.getSalary());
		System.out.println(hrMgr.getDept());

		// ������
		Employee itMgr = new Manager("����", 200, "IT");
		System.out.println(itMgr.getSalary());

//        System.out.println(itMgr.getDept()); ����ؼ� �������� �ʾұ� ������
		// Manager(�ڽ�) �� ���� getDept ȣ��
		Manager itMgr2 = (Manager) itMgr;
		System.out.println(itMgr2.getName());
		System.out.println(itMgr2.getDept());

		// Heterogeneous Collection
		Employee[] emps = new Employee[4];

		emps[0] = new Manager("�浿", 250, "it");
		emps[1] = new MereClerk("ö��", 150);
		emps[2] = new MereClerk("����", 100);
		emps[3] = new Manager("�Ѹ�", 200, "HR");
		System.out.println("���� �����Դϴ�.");
		
		printEmployeeeInfo(emps);
		
		for (Employee emp : emps) {
			emp.manageSalary(10);
		}

		System.out.println("�λ� �� ����");

		for (Employee emp : emps) {
			System.out.println(emp.getName() + "�� �λ� �� ������ " + emp.getSalary() + " ���� �Դϴ�.");
		}
		// List<Employee> emps2 = new ArrayList<Employee>();

	}

	public static void printEmployeeeInfo(Employee[] emps) {
		for (Employee emp : emps) {
			
			if (emp instanceof Manager) {
				
				System.out.print("������ �μ��� : "+((Manager)emp).getDept() + " ");
				
			}
			
			
			System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");
			
		}
	}
}
