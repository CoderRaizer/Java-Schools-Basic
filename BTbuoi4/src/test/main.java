package test;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<>();
		a.add("cuong");
		a.add("tuan");
		a.add("phuong");
		a.add("hong");
		a.add(1,"hanh");
		a.set(0, "teo");
		a.remove(3);
		a.remove("phuong");
		int x = a.size() - a.indexOf("hong");
		int y = a.size() - a.indexOf("phuong");//neu phuong khong co trong array thi mac dinh chi so = - 1
		System.out.println("x : " + x);
		System.out.println("y : " + y);
	}

}
