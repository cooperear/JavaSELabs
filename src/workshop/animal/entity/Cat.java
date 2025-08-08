package workshop.animal.entity;

import workshop.animal.entity.Animal;

public class Cat extends Animal implements Pet {

	private String name;
	
	public Cat() {
		this("");
	}
	
	public Cat(String name) {
		super(4);
		this.name = name;

		// TODO Auto-generated constructor stub
	}

	/////////
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name =name;

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("고양이는 사냥을 하지요 영역다툼도 하고요");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("고양이는 설치류, 곤충, 어류를 먹어요");

	}
	

}
