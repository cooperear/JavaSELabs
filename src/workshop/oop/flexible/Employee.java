package workshop.oop.flexible;
/*
 * 
 * 
 * �߻�Ŭ������ ��ü ��������
 * super class�� �ż��尡 �߻��̸� subŬ�������� �� �߻�޼��带
 * �ݵ�� override �ؾ���
 * 
 * 
 * */
public abstract class Employee {

	private String name;
	protected double salary;

	public Employee() {
		super();
	}
	
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}
	
	public abstract void manageSalary(double rate);
	
	
}