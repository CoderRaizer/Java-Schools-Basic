package bai5;

import java.util.Scanner;

public abstract class NhanVien implements Comparable<NhanVien> {

	private String manv;
	private String hoten;
	private String ngaysinh;
	private String diachi;
	private String ngayvaolam;
	protected boolean coconduoi3tuoi; // protected de class con tinh luong

	Scanner o = new Scanner(System.in);

	public NhanVien() {
	}

	public NhanVien(String manv, String hoten, String ngaysinh, String diachi, String ngayvaolam, boolean coconduoi3tuoi) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.ngayvaolam = ngayvaolam;
		this.coconduoi3tuoi = coconduoi3tuoi;
	}

	/*-------------------------------------*/
	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getNgayvaolam() {
		return ngayvaolam;
	}

	public void setNgayvaolam(String ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}

	public boolean isCoconduoi3tuoi() {
		return coconduoi3tuoi;
	}

	public void setCoconduoi3tuoi(boolean coconduoi3tuoi) {
		this.coconduoi3tuoi = coconduoi3tuoi;
	}
	/*-------------------------------------*/

	private String NhapMaNhanVien() {
		String sample;
		do {
			o = new Scanner(System.in);
			System.out.println("Nhập mã nhân viên: ");
			sample = o.nextLine();
			if (sample.length() != 5) {
				System.out.println("Eror: Mã Nhân Viên Phải Đủ 5 ký tự (Vd: NV123)!!!");
			}
		} while (sample.length() != 5);
		return sample;
	}

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

	public String InHoaKyTuDau(String sample) {
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
		return InHoaKyTuDau(sample);
	}

	private String NhapHoTen() {
		String sample;
		boolean check = true;
		do {
			o = new Scanner(System.in);
			System.out.print("Nhập Họ Tên (Không Dấu): ");
			sample = o.nextLine();
			char[] array = sample.toCharArray();
			for (int i = 0; i < sample.length(); i++) {
				if (((int) array[i] >= 65 && (int) array[i] <= 90) || ((int) array[i] >= 97 && (int) array[i] <= 122) || ((int) array[i] == 32))
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

	private boolean kiemTraNgayVaoLam(String ngaysinh, String ngayvaolam) {
		char[] array1 = ngaysinh.toCharArray();
		char[] array2 = ngayvaolam.toCharArray();
		String convert1 = "";
		String convert2 = "";
		for (int i = 0; i < ngaysinh.length(); i++) {
			if ((int) array1[i] >= 48 && (int) array1[i] <= 57) {
				convert1 += Character.toString((char) ((int) array1[i]));
			}
		}
		for (int i = 0; i < ngayvaolam.length(); i++) {
			if ((int) array2[i] >= 48 && (int) array2[i] <= 57) {
				convert2 += Character.toString((char) ((int) array2[i]));
			}
		}
		if (Integer.parseInt(convert1) > Integer.parseInt(convert2)) {
			return false;
		} else
			return true;
	}

	public void nhapThongTin() {
		this.manv = NhapMaNhanVien();
		this.hoten = NhapHoTen();
		System.out.print("Địa chỉ: ");
		this.diachi = o.nextLine();

		do {
			System.out.print("Ngày sinh (Theo định dạng dd/mm/yyyy) : ");
			this.ngaysinh = o.nextLine();
			o = new Scanner(System.in);
			System.out.print("Ngày vào làm (Theo định dạng dd/mm/yyyy) : ");
			this.ngayvaolam = o.nextLine();
			if (kiemTraNgayVaoLam(this.ngaysinh, this.ngayvaolam) == false) {
				System.out.println("Ngày sinh hoặc ngày vào làm không hợp lệ (Mời Nhập Lại) : ");
			}
		} while (kiemTraNgayVaoLam(this.ngaysinh, this.ngayvaolam) == false);
		
		System.out.print("Có con dưới 3 tuổi ?(1.Yes  2.No) : ");
		int confirm;
		confirm = o.nextInt();
		if (confirm == 1) {
			coconduoi3tuoi = true;
		} else {
			coconduoi3tuoi = false;
		}
	}

	public void xuatThongTin() {
		System.out.print(this.manv + "          " + this.hoten);
		
		for (int i = 0; i < (20 - this.hoten.length()); i++) {
			System.out.print(" ");
		}
		System.out.print(this.ngaysinh + "      " + this.ngayvaolam + "         ");
	}

	public abstract double tinhLuong();

//	@Override
//	public int compareTo(NhanVien nv) {
//		if (this.manv == nv.manv)
//			return 0;
//		else if (this.manv.compareTo(nv.manv) > 0)
//			return 1;
//		else
//			return -1;
//	}
	
	@Override
	public int compareTo(NhanVien o) {
		if(this.manv.compareTo(o.manv) > 0) {
			return 1;
		} else return -1;
	}

}
