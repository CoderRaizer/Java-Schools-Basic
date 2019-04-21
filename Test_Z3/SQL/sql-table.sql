CREATE DATABASE Z3_TEST
USE Z3_TEST


CREATE TABLE SinhVien(
	mssv CHAR(10) PRIMARY KEY NOT NULL,
	HoTen NVARCHAR(40) NOT NULL,
	DiemToan FLOAT,
	DiemLy FLOAT,
	DiemHoa FLOAT
)
GO

INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn076' ,N'Võ Duy Khánh' ,8.0 ,7.0 ,6.0)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn095' ,N'Trần Công Minh' ,8.3 ,7.5 ,6.1)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn111' ,N'Nguyễn Đông Nhật' ,9.4 ,5.8 ,6.5)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn062' ,N'Trần Duy Hoàng' ,9.3 ,9.5 ,6.1)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn087' ,N'Đỗ Quý Long' ,7.3 ,8.5 ,10.0)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn107' ,N'Đặng Cao Nguyên' ,6.7 ,8.0 ,9.9)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n16dccn73' ,N'Nguyễn Mạnh Khang' ,4.5 ,7.1 ,6.0)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n15dccn050' ,N'Trần Duy Bảo' ,2.5 ,3.5 ,4.8)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n15dccn120' ,N'Lê Văn Luyện' ,8.0 ,7.0 ,5.1)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n14dccn020' ,N'Đàm Trung Nguyên' ,3.5 ,9.5 ,6.5)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n14dcvt198' ,N'Đinh Văn Hoàng' ,8.0 ,3.5 ,7.1)
INSERT INTO dbo.SinhVien( mssv ,HoTen ,DiemToan ,DiemLy ,DiemHoa)
VALUES  ( 'n14dcvt180' ,N'Nguyễn Trung Kiên' ,8.3 ,3.5 ,9.0)