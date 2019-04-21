package tonghop;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/*--------BTbuoi4 package bai5 co san interface Comparable ----------*/
public class TongHop {
	
	Scanner o = new Scanner(System.in);
	
	
	/*----------------------------Nhap Diem---------------------------*/
	private double InputScoresRegex(String typeScore) {
		double ret;
		do {
			o = new Scanner(System.in);
			System.out.print("Nhập Điểm( không sử dụng dấu phẩy) " + typeScore + " : ");
			ret = o.nextDouble();
			if (ret < 0d || ret > 10d) {
				System.out.println("Điểm Không Hợp Lệ");
			}
		} while (ret < 0d || ret > 10d);
		return ret;
	}
	/*----------------------------------------------------------------*/
	
	
	
	
	/*------------------------Chuan Hoa Ky Tu-------------------------*/
	public int HowManySpace(int index, String temp) {
		int count = 0;
		int z = index;
		char[] array = temp.toCharArray();
		while ((int) array[z] == 32) {
			count++;
			z++;
		}
		return count;
	}
	public String ChuyenKyTuDauThanhHoa(String sample) {
		int lenght = sample.length();
		char[] array = sample.toCharArray();
		sample = "";
		int i = 0;
		while (i < lenght) {
			if (i == 0) {
				if ((int) array[i] >= 65 && (int) array[i] <= 90) {
					sample += Character.toString(array[i]);
				} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
					sample += Character.toString((char) ((int) array[i] - 32));

				}
			} else {
				if ((int) array[i] == 32) {
					sample += Character.toString(array[i]);
					i++;
					if ((int) array[i] >= 65 && (int) array[i] <= 90) {
						sample += Character.toString((char) ((int) array[i]));
					} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
						sample += Character.toString((char) ((int) array[i] - 32));
					}

				} else {
					if ((int) array[i - 1] == 32) {// neu truoc no la khoang trang
						if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i] - 32));
						}
					} else if ((int) array[i - 1] >= 65 && (int) array[i - 1] <= 90) {// neu chu dung truoc la hoa
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i] + 32));
						}
					} else if ((int) array[i - 1] >= 97 && (int) array[i - 1] <= 122) {
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							sample += Character.toString((char) ((int) array[i] + 32));
						}
					}
				}
			}
			i++;
		}
		return sample;
	}
	public String ChuanHoaChuoi(String sample) {
		sample = sample.trim();
		char[] array = sample.toCharArray();
		for (int i = 0; i < sample.length(); i++) {
			if ((int) array[i] == 32) {
				int del = 0;
				del = HowManySpace(i, sample);
				if (del > 1) {
					String space = "";
					for (int j = 0; j < del; j++) {
						space += " ";
					}
					while (sample.indexOf(space) != -1) {
						sample = sample.replaceAll(space, " ");
					}
				}
			}
		}
		return ChuyenKyTuDauThanhHoa(sample);
	}
	private String InputHoTenRegex() {
		String sample;
		boolean check = true;
		do {
			o = new Scanner(System.in);
			System.out.print("Nhập Họ Tên (Không Dấu): ");
			sample = o.nextLine();
			char[] array = sample.toCharArray();
			for (int i = 0; i < sample.length(); i++) {
				if (((int) array[i] >= 65 && (int) array[i] <= 90) || ((int) array[i] >= 97 && (int) array[i] <= 122)
						|| ((int) array[i] == 32))
					check = true;
				else {
					check = false;
					System.out.println("Error: Nhập Tên Không Hợp Lệ!!!");
					break;
				}
			}
		} while (check == false);
		return ChuanHoaChuoi(sample);
	}
	/*----------------------------------------------------------------*/
	
	
	
	
	/*------------------------SORT LIST-------------------------*/
	/*
	public boolean ConfirmSortAlready() {// Trả về true nếu như DS đã được sắp xếp tăng dần theo mã số sinh viên
		for (int i = 0; i < this.quantity - 1; i++) {
			for (int j = i + 1; j < this.quantity; j++) {
				if (this.list_sv[j].getMssv().compareTo(this.list_sv[i].getMssv()) < 0) {// Phần tử sau có mã nhỏ hơn
																							// phần tử trước
					return false;
				}
			}
		}
		return true;
	}

	public void SelectionSort() {
		if (ConfirmSortAlready() == true) {
			System.out.println("--------Danh Sách Đã Được Sắp Xếp Rồi-------");
			ShowDSSV();
		} else {
			int min;
			for (int i = 0; i < this.quantity - 1; i++) {
				min = i;
				for (int j = i + 1; j < this.quantity; j++) {
					if (this.list_sv[j].getMssv().compareTo(this.list_sv[min].getMssv()) < 0) {// so sánh mã phía sau là nhỏ hơn phía trước
						min = j;// gán vị trí min mới là j
					}
				}
				SinhVien temp = new SinhVien();
				temp = this.list_sv[min];
				this.list_sv[min] = this.list_sv[i];
				this.list_sv[i] = temp;
			}
			System.out.println("-------------------------DANH SÁCH SAU KHI SẮP XẾP--------------------------");
			ShowDSSV();
		}
	}
	*/
	/*-----------------------------------------------------------------*/
	
	
	
	
	/*--------------------------STRING REGEX----------------------------*/

	
	
//	public boolean String checkRegexMatching(String typeRegex,String data) {
//		Scanner o = new Scanner(System.in);
//		String chuoi = "";
//		boolean flag = true;
//		
//		if (typeRegex.equalsIgnoreCase("Số có 6 chữ số")) {//correctly
//			String sampleGegex = "\\d{6}";
//			do {
//				System.out.print("Nhập " + typeRegex + " (Gồm 6 Chữ Số): ");
//				chuoi = o.nextLine();
//				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
//				Matcher mt = pt.matcher(chuoi);
//				if (!mt.matches()) {
//					flag = false;
//					System.out.println("Nhập Sai Định Dạng");
//				} else if (mt.matches()) {
//					flag = true;
//				}
//			} while (flag == false);
//		} else if (typeRegex.equalsIgnoreCase("PASSWORD")) {//correctly
//			String sampleGegex = "\\d{4}";
//			do {
//				System.out.print("Nhập " + typeRegex + " (Gồm 4 Chữ Số): ");
//				chuoi = o.nextLine();
//				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
//				Matcher mt = pt.matcher(chuoi);
//				if (!mt.matches()) {
//					flag = false;
//					System.out.println("Nhập Sai Định Dạng");
//				} else if (mt.matches()) {
//					flag = true;
//				}
//			} while (flag == false);
//		} else if (typeRegex.equalsIgnoreCase("HOTEN") || typeRegex.equalsIgnoreCase("DIACHI")) {//correctly
//			String sampleGegex = "^[a-zA-Z\\s]+";
//			do {
//				System.out.print("Nhập " + typeRegex + " : ");
//				chuoi = o.nextLine();
//				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
//				Matcher mt = pt.matcher(chuoi);
//				if (!mt.matches()) {
//					flag = false;
//					System.out.println("Nhập Sai Định Dạng");
//				} else if (mt.matches()) {
//					flag = true;
//				}
//			} while (flag == false);
//		} else if (typeRegex.equalsIgnoreCase("SDT")) {
//			String sampleGegex = "[\\d]{10,12}";
//			do {
//				System.out.print("Nhập " + typeRegex + " (Tối thiểu 10 số - Tối Đa 12 số) : ");
//				chuoi = o.nextLine();
//				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
//				Matcher mt = pt.matcher(chuoi);
//				if (!mt.matches()) {
//					flag = false;
//					System.out.println("Nhập Sai Định Dạng");
//				} else if (mt.matches()) {
//					flag = true;
//				}
//			} while (flag == false);
//		} else if (typeRegex.equalsIgnoreCase("EMAIL")) {//correctly
//			String sampleGegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//			do {
//				System.out.print("Nhập " + typeRegex + " : ");
//				chuoi = o.nextLine();
//				Pattern pt = Pattern.compile(sampleGegex, Pattern.CASE_INSENSITIVE);
//				Matcher mt = pt.matcher(chuoi);
//				if (!mt.matches()) {
//					flag = false;
//					System.out.println("Nhập Sai Định Dạng");
//				} else if (mt.matches()) {
//					flag = true;
//				}
//			} while (flag == false);
//		}
//		return chuoi;
//	}
	/*----------------------------------------------------------------------------------*/
	
	/*----------NHẬP SỐ CÓ 6 CHỮ SỐ---------*/
	public static boolean NhapSoCo_6_ChuSo(String data) {
		boolean flag = true;
		String regex = "\\d{6}";
		Pattern pt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(data);
		if(!mt.matches()) {
			flag = false;
		}
		return flag;
	}
	
	
	
	/*----------NHẬP HỌ TÊN---------*/
	public static boolean NhapHoTen(String data) {//chi duong ky tu chu cai va khoang trang
		boolean flag = true;
		String regex = "^[a-zA-Z\\s]+";
		Pattern pt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(data);
		if(!mt.matches()) {
			flag = false;
		}
		return flag;
	}
	
	
	
	/*----------NHẬP ĐỊA CHỈ---------*/
	public static boolean NhapDiaChi(String data) {//chi duong ky tu chu cai,chu so va khoang trang
		boolean flag = true;
		String regex = "^[a-zA-Z0-9\\s]+";
		Pattern pt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(data);
		if(!mt.matches()) {
			flag = false;
		}
		return flag;
	}
	
	
	
	/*----------NHẬP SỐ ĐIỆN THOẠI---------*/
	public static boolean NhapSoDienThoai(String data) {
		boolean flag = true;
		String regex = "\\d{10,11}";
		Pattern pt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(data);
		if(!mt.matches()) {
			flag = false;
		}
		return flag;
	}
	
	
	
	/*----------NHẬP EMAIL---------*/
	public static boolean NhapEmail(String data) {
		boolean flag = true;
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pt = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher mt = pt.matcher(data);
		
		if(!mt.matches()) {
			flag = false;
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	/*--------------------------------------MAIN----------------------------------------*/
	public static void main(String[] args) {
		
		
		String chuoi = "";
		
		
		
		
		/*-----------NHẬP CHỮ SỐ
		do {
			Scanner o = new Scanner(System.in);
			System.out.print("Nhap chu so: ");
			chuoi = o.nextLine();
			if(NhapSoCo_6_ChuSo(chuoi) == true) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
				chuso = "";
			}
		}while(NhapSoCo_6_ChuSo(chuso) == false);
		*/
		
		
		/*------------NHẬP HỌ TÊN
		do {
			Scanner o = new Scanner(System.in);
			System.out.print("Nhap ho ten: ");
			chuoi = o.nextLine();
			if(NhapHoTen(chuoi) == true) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
				chuoi = "";
			}
		}while(true);
		*/
		
		
		
		/*------------NHẬP ĐỊA CHỈ
		do {
			Scanner o = new Scanner(System.in);
			System.out.print("Nhap dia chi: ");
			chuoi = o.nextLine();
			if(NhapDiaChi(chuoi) == true) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
				chuoi = "";
			}
		}while(true);
		
		
		/*------------NHẬP SỐ ĐIỆN THOẠI
		do {
			Scanner o = new Scanner(System.in);
			System.out.print("Nhap so dien thoai: ");
			chuoi = o.nextLine();
			if(NhapSoDienThoai(chuoi) == true) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
				chuoi = "";
			}
		}while(true);
		*/
		
		
		
		/*------------NHẬP EMAIL
		do {
			Scanner o = new Scanner(System.in);
			System.out.print("Nhap email: ");
			chuoi = o.nextLine();
			if(NhapEmail(chuoi) == true) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
				chuoi = "";
			}
		}while(true);
		*/
		
		
		
		
		
		
		
		
	}
	
	
	
}
