package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	
	private String name;
	
	public Fish() {
		super(0);
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("�ڵ鸵�� �����ϱ⵵ �ϰ�, �ǵ��� �����ؿ�");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("�̳�, �ö�ũ��");

	}
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("������ ������ ���ġ�� �ȴ� ���� �幰��");
	}
}
