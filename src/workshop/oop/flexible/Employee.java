package workshop.oop.flexible;
/*
 * 
 * 
 * 추상클래스는 객체 생성못함
 * super class의 매서드가 추상이면 sub클래스에서 그 추상메서드를
 * 반드시 override 해야함
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