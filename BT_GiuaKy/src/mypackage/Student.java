package mypackage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person implements Comparable<Student> {

	private float mark;
	private String grade;

	Scanner o = new Scanner(System.in);

	public Student() {
	}

	public Student(float mark, String grade) {
		super();
		this.mark = mark;
		this.grade = grade;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void calGrade() {
		if (this.mark >= (float) 8 && this.mark <= (float) 10) {
			this.grade = "distintion";
		}
		if (this.mark >= (float) 7 && this.mark < (float) 8) {
			this.grade = "credit";
		}
		if (this.mark >= (float) 5 && this.mark < (float) 7) {
			this.grade = "pass";
		}
		if (this.mark >= (float) 0 && this.mark < (float) 5) {
			this.grade = "fail";
		}
	}

	public float inputScore() {
		Scanner o = new Scanner(System.in);
		String chuoi = "";
		boolean flag = true;
		String sampleGegex = "\\d{1,2}\\.\\d";
		do {
			System.out.print("Nhap diem: ");
			chuoi = o.nextLine();
			Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
			Matcher mt = pt.matcher(chuoi);
			if (!mt.matches()) {
				flag = false;
				System.out.println("Nhập Sai Định Dạng");
			} else if (mt.matches()) {
				float x = Float.parseFloat(chuoi);
				if (x >= 0 && x <= 10) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} while (flag == false);

		float score = Float.parseFloat(chuoi);
		return score;
	}

	@Override
	public void input() {
		super.input();
		this.mark = inputScore();
		calGrade();
	}

	@Override
	public void display() {
		super.display();
		System.out.println("Mark: " + this.mark + " Grade: " + this.grade);
	}

	@Override
	public int compareTo(Student x) {
		if (this.mark > x.mark) {
			return 1;
		} else
			return -1;
	}

}
