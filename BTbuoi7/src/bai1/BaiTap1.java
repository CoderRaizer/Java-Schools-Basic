package bai1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class BaiTap1 {

	public static void main(String[] args) {

		int sizeOfString = 0;
		String s = "Hi D16DCCN076-N! Welcome to Object Oriented Programming in Java";
		String fileName = "D://Text.txt";
		Path p = Paths.get(fileName);

		if (Files.exists(p)) {
			JOptionPane.showMessageDialog(null, "File Đã Tồn Tại");
		} else {
			JOptionPane.showMessageDialog(null, "File Chưa Tồn Tại");
		}

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			byte[] arrByte = s.getBytes();
			sizeOfString = arrByte.length;
			bos.write(arrByte);
			bos.flush();
			fos.close();
			bos.close();

		} catch (FileNotFoundException errorFile) {
			System.out.print("Exception = " + errorFile);
		} catch (IOException errorIO) {
			System.out.print("Exception = " + errorIO);
		} finally {
			System.out.println("Kích thướt của s là: " + sizeOfString + " Bytes <=> " + (sizeOfString * 8) + " Bit");
		}

		String nienkhoahoc = "20";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			int count = 0;
			int c;
			do {
				c = fis.read();
				if (c >= 48 && c <= 57 && count < 2) {
					nienkhoahoc += Character.toString((char) (c));
					count++;
				}

				if (c >= 65 && c <= 90) {
					System.out.println((char) (c));
				}

				else if (c >= 97 && (int) c <= 122) {
					System.out.println((char) (c - 32));
				}

			} while (c != -1);
		} catch (IOException errorIO) {
			System.out.print("Exception = " + errorIO);
		} finally {
			System.out.println("Niên Khóa Học Là: " + nienkhoahoc);
		}

		/*-------------------------------------------*/
		String monhoc = "";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			int count = 0;
			boolean flag = false;
			int c;
			do {
				c = fis.read();
				if (c == 74) {
					flag = true;
				}
				if (flag == true && count < 4) {
					monhoc += Character.toString((char) (c));
					count++;
				}
			} while (c != -1);
		} catch (IOException errorIO) {
			System.out.print("Exception = " + errorIO);
		} finally {
			System.out.println("Tên Môn Học Là: " + monhoc);
		}

	}

}
