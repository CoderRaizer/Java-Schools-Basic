package quanlyxaukytu;

import java.util.Scanner;

public class XauKyTu {

	private String sample;

	public XauKyTu() {

	}

	public XauKyTu(String sample) {
		this.sample = sample;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	private String InputStringRegex() {
		String sample;
		boolean check;
		Scanner o = new Scanner(System.in);
		do {
			check = true;
			o = new Scanner(System.in);
			System.out.println("Nhập Chuỗi (Không Dấu): ");
			sample = o.nextLine();
			char[] array = sample.toCharArray();
			int length = sample.length();
			for (int i = 0; i < length; i++) {
				if (!((int) array[i] >= 65 && (int) array[i] <= 90) && !((int) array[i] >= 97 && (int) array[i] <= 122)
						&& !((int) array[i] == 32)) {
					check = false;
					System.out.println("Error: Nhập Chuỗi Không Hợp Lệ!!!");
					break;
				}
			}
		} while (check == false);
		return sample;
	}

	public void Input() {
		this.sample = InputStringRegex();
	}

	public void CountQuantityCharacterInString() {
		Scanner o = new Scanner(System.in);
		String temp;
		char kytu;
		int count = 0;
		System.out.print("Nhập 1 Ký Tự: ");
		temp = o.nextLine();
		kytu = temp.charAt(0);

		char[] array = this.sample.toCharArray();
		int length = this.sample.length();
		for (int i = 0; i < length; i++) {
			if ((int) array[i] == (int) kytu) {
				count++;
			}
		}
		System.out.println("Số Lần Xuất Hiện Của Ký Tự " + kytu + " Là: " + count);
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

	public void StandardizeString() {//loai bo khoang trang
		this.sample = this.sample.trim();//loai bo khoang trang dau va cuoi
		char[] array = this.sample.toCharArray();
		int length = this.sample.length();
		for (int i = 0; i < length; i++) {
			if ((int) array[i] == 32) {//bat gap khoang trang trong chuoi
				int del = 0;
				del = HowManySpace(i, this.sample);//dem khoang trang
				if (del > 1) {
					String space = "";
					StringBuilder builder = new StringBuilder();
					for (int j = 0 ; j < del ; j++) {
						builder.append(" ");
//						space += " ";
					}
					space = builder.toString();
					while (this.sample.indexOf(space) != -1) {//indexOf tra ve vi tri cua chuoi con la space co trong chuoi
						this.sample = this.sample.replaceAll(space, " ");//tai vi tri do thuc hien thay the khoang trang moi
					}
				}
			}
		}
		System.out.println("Chuỗi Sau Khi Chuẩn Hóa:" + this.sample);
	}

	public void CountQuantityWordInString() {
		int numSpace = 0;
		char[] temp = this.sample.toCharArray();
		int length = this.sample.length();
		for (int i = 0; i < length; i++) {
			if ((int) temp[i] == 32) {
				numSpace++;
			}
		}
		System.out.println("Số từ của xâu là: " + (numSpace + 1));
	}

	public void CountNumberOfWordStartingWith_H() {
		char[] array = this.sample.toCharArray();
		int num = 0;
		if ((int) array[0] == 72) {
			num += 1;
		}
		for (int i = 0; i < this.sample.length(); i++) {
			if ((int) array[i] == 32) {
				if ((int) array[i + 1] == 72) {
					num++;
				}
			}
		}
		System.out.println("Số Từ Bắt Đầu Bằng Chữ H là: " + num);
	}

	public void ChangeFirstCharacterToCase() {
		int lenght = this.sample.length();
		char[] array = this.sample.toCharArray();
		this.sample = "";
		int i = 0;
		while (i < lenght) {
			if (i == 0) {
				if ((int) array[i] >= 65 && (int) array[i] <= 90) {
					this.sample += Character.toString(array[i]);
				} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
					this.sample += Character.toString((char) ((int) array[i] - 32));

				}
			} else {
				if ((int) array[i] == 32) {
					this.sample += Character.toString(array[i]);
					i++;
					if ((int) array[i] >= 65 && (int) array[i] <= 90) {
						this.sample += Character.toString((char) ((int) array[i]));
					} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
						this.sample += Character.toString((char) ((int) array[i] - 32));
					}

				} else {
					if ((int) array[i - 1] == 32) {
						if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							this.sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							this.sample += Character.toString((char) ((int) array[i] - 32));
						}
					} else if ((int) array[i - 1] >= 65 && (int) array[i - 1] <= 90) {
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							this.sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							this.sample += Character.toString((char) ((int) array[i] + 32));
						}
					} else if ((int) array[i - 1] >= 97 && (int) array[i - 1] <= 122) {
						if ((int) array[i] >= 97 && (int) array[i] <= 122) {
							this.sample += Character.toString((char) ((int) array[i]));
						} else if ((int) array[i] >= 65 && (int) array[i] <= 90) {
							this.sample += Character.toString((char) ((int) array[i] + 32));
						}
					}
				}
			}
			i++;
		}

		System.out.println("Sau Khi In Hoa Ky Tu Dau: " + this.sample);
	}

	public void FindWordMaxLength() {
		StandardizeString();
		String temp = "";
		int max = -1;
		String wordMaxLength = "";
		char[] array = this.sample.toCharArray();
		int i = 0;
		int length = array.length;
		for (; i < array.length; i++) {
			for (int j = i; j < length; j++) {
				if ((int) array[j] != 32) {
					temp += Character.toString((char) (int) array[i]);
					i++;
				} else
					break;
			}
			if (temp.length() > max) {
				max = temp.length();
				wordMaxLength = temp;
				temp = "";
			}
		}
		System.out.println("Từ Dài Nhất Là Từ:  " + wordMaxLength + " Có Chiều dài là:   " + max + "ký tự");
	}

	@Override
	public String toString() {
		return "Result [" + sample + "]";
	}
}
