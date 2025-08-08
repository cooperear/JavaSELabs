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
		System.out.println("핸들링이 가능하기도 하고, 피딩이 가능해요");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("이끼, 플랑크톤");

	}
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("물고기는 물에서 헤엄치지 걷는 경우는 드물죠");
	}
}
