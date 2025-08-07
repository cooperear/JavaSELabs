package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId, name, major;
	private int grade;

	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
		super();

		if (grade > 0 && grade < 5) {
			this.studentId = studentId;
			this.name = name;
			this.major = major;
			this.grade = grade;
		} else {
			throw new InvalidGradeException("�г��� �ȹٷ� �Է��ϼ���!" + grade);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) throws InvalidGradeException {
		if (0 < grade && grade < 5) {
			this.grade = grade;
		} else {
			throw new InvalidGradeException("�г��� 1~4 ���̿��� �մϴ�: " + grade);
		}
	}

}
