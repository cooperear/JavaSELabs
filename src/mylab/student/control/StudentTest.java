package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student SihoonPark = new Student("20171111", "�ڽ���", "��ǻ�Ͱ�������", 4);
		System.out.println(
				SihoonPark.getName() + SihoonPark.getStudentId() + SihoonPark.getMajor() + SihoonPark.getGrade());

		SihoonPark.setMajor("AI ��������");
		System.out.println(
				SihoonPark.getName() + SihoonPark.getStudentId() + SihoonPark.getMajor() + SihoonPark.getGrade());

		SihoonPark.setName("�ϴú���");
		System.out.println(
				SihoonPark.getName() + SihoonPark.getStudentId() + SihoonPark.getMajor() + SihoonPark.getGrade());

		SihoonPark.setGrade(2);
		System.out.println(
				SihoonPark.getName() + SihoonPark.getStudentId() + SihoonPark.getMajor() + SihoonPark.getGrade());

		try {
			SihoonPark.setGrade(5);
			System.out.println(
					SihoonPark.getName() + SihoonPark.getStudentId() + SihoonPark.getMajor() + SihoonPark.getGrade());

		} catch (InvalidGradeException E) {
			System.out.println(E.getMessage());
		}

		try {

			Student Std = new Student("20171111", "�����۽�", "��ǻ�Ͱ�������", 5);

		}

		catch (InvalidGradeException E) {
			System.out.println(E.getMessage());

		}

	}

}
