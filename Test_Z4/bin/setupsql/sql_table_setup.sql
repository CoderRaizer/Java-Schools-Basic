CREATE DATABASE Z4_TEST
GO

USE Z4_TEST
GO


DROP DATABASE Z4_TEST
GO
-----------------------------------CREATE-----------------------------------------
-- THƯƠNG HIỆU --
CREATE TABLE THUONGHIEU(
MaTH NVARCHAR(20) NOT NULL PRIMARY KEY,
TenTH NVARCHAR(40) NOT NULL UNIQUE
)
GO

-- GIẢM GIÁ --
CREATE TABLE GIAMGIA(
MaGG NVARCHAR(10) NOT NULL PRIMARY KEY,
MucGiam INT CHECK (MucGiam >= 1 AND MucGiam <= 100)
)
GO

-- NHÀ CUNG CẤP --
CREATE TABLE NHACUNGCAP(
MaNCC NVARCHAR(20) NOT NULL PRIMARY KEY,
TenNCC NVARCHAR(50) NOT NULL,
Email CHAR(30),
Fax CHAR(10),
DiaChi NVARCHAR(45)
)
GO

-- NGÀNH HÀNG --
CREATE TABLE NGHANHHANG(
MaNH NVARCHAR(20) NOT NULL PRIMARY KEY,
TenNH NVARCHAR(40) NOT NULL UNIQUE
)
GO


-- DANH MỤC --
CREATE TABLE DANHMUC(
MaDM NVARCHAR(20) NOT NULL PRIMARY KEY,
TenDM NVARCHAR(30) NOT NULL UNIQUE,
MaNH NVARCHAR(20) FOREIGN KEY(MaNH) REFERENCES dbo.NGHANHHANG(MaNH)
)
GO
-- SẢN PHẨM --
CREATE TABLE SANPHAM(
MaSP NVARCHAR(20) NOT NULL PRIMARY KEY,
TenSP NVARCHAR(50) NOT NULL,
ThoiGianBH TINYINT CHECK (ThoiGianBH > 0 AND ThoiGianBH < 36),
GiaNhap INT CHECK (GiaNhap > 0),
GiaBan INT CHECK (GiaBan > 0),
TonKho INT CHECK (TonKho >= 0),
ThongSoSP TEXT,
MaDM NVARCHAR(20) FOREIGN KEY(MaDM) REFERENCES dbo.DANHMUC(MaDM),
MaTH NVARCHAR(20) FOREIGN KEY(MaTH) REFERENCES dbo.THUONGHIEU(MaTH),
MaGG NVARCHAR(10) FOREIGN KEY(MaGG) REFERENCES dbo.GIAMGIA(MaGG)
)
GO

-- KHÁCH HÀNG --
CREATE TABLE KHACHHANG(
Username NVARCHAR(20) NOT NULL PRIMARY KEY,
HoTen NVARCHAR(40) NOT NULL,
GioiTinh CHAR(1) CHECK (GioiTinh IN('M','F')) NOT NULL,
NgaySinh DATE NOT NULL,
DiaChi NVARCHAR(100) NOT NULL
)
GO


-- SODIENTHOAI_KHACHHANG
CREATE TABLE SDT_KHACHHANG(
SDT CHAR(12) PRIMARY KEY NOT NULL,
Username NVARCHAR(20) FOREIGN KEY(Username) REFERENCES dbo.KHACHHANG(Username),
CHECK (SDT LIKE '[0][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
)
GO

-- BỘ PHẬN --
CREATE TABLE BOPHAN(
MaBP NVARCHAR(10) NOT NULL PRIMARY KEY,
TenBP NVARCHAR(40) NOT NULL UNIQUE,
SDT CHAR(12) CHECK (SDT LIKE '[0][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') UNIQUE
)


-- NHÂN VIÊN --
CREATE TABLE NHANVIEN(
MaNV NVARCHAR(20) NOT NULL PRIMARY KEY,
HoTen NVARCHAR(40) NOT NULL,
GioiTinh CHAR(1) CHECK (GioiTinh IN('M','F')) NOT NULL,
NgaySinh DATE NOT NULL,
Email CHAR(30) NOT NULL UNIQUE,
SDT CHAR(10) CHECK (SDT LIKE '[0][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') UNIQUE,
MucLuong INT CHECK (MucLuong > 0),
MaBP NVARCHAR(10) FOREIGN KEY(MaBP) REFERENCES dbo.BOPHAN(MaBP)
)
GO


-- HÓA ĐƠN --
CREATE TABLE HOADON(
MaHD NVARCHAR(20) NOT NULL PRIMARY KEY,
ThoiGianLapHD DATE NOT NULL,
GhiChu NVARCHAR(100),
USername NVARCHAR(20) FOREIGN KEY(USername) REFERENCES dbo.KHACHHANG(Username),
MaNV NVARCHAR(20) FOREIGN KEY(MaNV) REFERENCES dbo.NHANVIEN(MaNV)
)
GO

-- CHI TIẾT HÓA ĐƠN --
CREATE TABLE CHITIET_HOADON(
MaHD NVARCHAR(20) FOREIGN KEY(MaHD) REFERENCES dbo.HOADON(MaHD),
MaSP NVARCHAR(20) FOREIGN KEY(MaSP) REFERENCES dbo.SANPHAM(MaSP),
SoLuong INT CHECK(SoLuong > 0 AND SoLuong < 100)
)
GO

-- PHIẾU NHẬP HÀNG --
CREATE TABLE PHIEUNHAPHANG(
MaPN NVARCHAR(20) NOT NULL PRIMARY KEY,
NgayNhap DATE NOT NULL,
MaNV NVARCHAR(20) FOREIGN KEY(MaNV) REFERENCES dbo.NHANVIEN(MaNV),
MaNCC NVARCHAR(20) FOREIGN KEY(MaNCC) REFERENCES dbo.NHACUNGCAP
)
GO

-- CHI TIẾT PHIẾU NHẬP --
CREATE TABLE CHTIETPHIEUNHAP(
MaPN NVARCHAR(20) FOREIGN KEY(MaPN) REFERENCES dbo.PHIEUNHAPHANG(MaPN),
MaSP NVARCHAR(20) FOREIGN KEY(MaSP) REFERENCES dbo.SANPHAM(MaSP),
SoLuong INT CHECK(SoLuong > 0)
)
GO



-----------------------------------CREATE TABLE-----------------------------------------



----------------------------------INSERT DATA-------------------------------------
-- THƯƠNG HIỆU -----------------------------------------------

--Áo Quần Giầy Dép--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'theblue', N'The Blue')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'canifa',N'Canifa')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'ninomaxx',N'Ninomaxx')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'elise',N'Elise')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'limeorange',N'Lime Orange')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'nemfashion',N'NEM Fashion')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'yame',N'YaMe')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'converse',N'Converse')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'juno',N'JUNO')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'vascara',N'VASCARA')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'vans',N'Vans')

--Balo--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'simplecarry',N'SimpleCarry')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'herschel',N'HersChel' )
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'jansport',N'JanSport')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'puma',N'Puma')

--Bàn phím, chuột--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'filco',N'Filco')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'leopold',N'Leopold')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'cmstorm',N'CM Storm')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'ducky',N'Ducky')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'razer',N'Razer')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'logitech',N'Logitech')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'corsair',N'Corsair')

--Chăm sóc thú cưng--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'CSTC1',N'Chăm Sóc Thú Cưng 1')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'CSTC2',N'Chăm Sóc Thú Cưng 2')

--Đồ Chơi(lấy hết chữ cái)--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'mykingdom',N'My Kingdom')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'bibomart',N'Bibo Mart')

--Dụng cụ cắm trại--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'coleman',N'Coleman')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'eureka',N'Eureka')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'trackman',N'Trackman')

--Dụng cụ gym - dụng cụ thể thao--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'impulse',N'Impulse')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'hoist',N'Hoist')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'nike',N'Nike')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'adidas',N'Adidas')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'reebok',N'Reebok')

--Điện thoại , sạc , loa ,laptop , tai nghe--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'samsung',N'SamSung')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'apple',N'Apple')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'oppo',N'Oppo')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'xiaomi',N'Xiaomi')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'huawei',N'Huawei')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'sony',N'Sony')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'nokia',N'Nokia')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'lenovo',N'Lenovo')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'alienware',N'Alienware')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'asus',N'Asus')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'toshiba',N'Toshiba')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'dell',N'Dell')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'acer',N'Acer')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'philips',N'Philips')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'bose',N'Bose')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'beats',N'Beats')

--Mỹ phẩm nước hoa--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'chanel',N'Chanel')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'gucci',N'Gucci')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'dior',N'Dior')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'lancome',N'Lancome')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'innisfree',N'Innisfree')

--Nước đóng chai đóng lon sữa bột--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'cocacola',N'Coca-Cola')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'pepsi',N'Pepsi')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'tropicana',N'Tropicana')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'lavie',N'LaVie')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'aquarius',N'Aquarius')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'vinamilk',N'Vinamilk')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'milo',N'Milo')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'dutchlady',N'Dutch Lady')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'nutifood',N'Nutifood')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'nestle',N'Nestle')

--điện gia dụng--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'kangaroo',N'Kangaroo')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'sunhouse',N'Sunhouse')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'goldsun',N'Goldsun')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'panasonic',N'Panasonic')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'electrolux',N'Electrolux')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'sanyo',N'Sanyo')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'sharp',N'Sharp')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'hitachi',N'Hitachi')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'goldsiden',N'GoldSiden')

--Ô to xe may--
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'toyota',N'Toyota')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'honda',N'Honda')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'yamaha',N'Yamaha')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'shell',N'Shell')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'castrol',N'Castrol')
INSERT INTO dbo.THUONGHIEU( MaTH, TenTH )VALUES  ( 'repsol',N'Repsol')


-- GIẢM GIÁ -----------------------------------------------
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG0',5)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG1',10)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG2',15)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG3',20)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG4',25)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG5',30)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG6',35)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG7',40)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG8',45)
INSERT INTO dbo.GIAMGIA ( MaGG, MucGiam )VALUES  ( 'GG9',50)


-- NHÀ CUNG CẤP --------------------------------------------
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC0',N'Nhà Cung Cấp 0','cungcap0@gmail.com','0123557879',N'Quận 4')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC1',N'Nhà Cung Cấp 1','cungcap1@gmail.com','0123586321',N'Quận 6')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC2',N'Nhà Cung Cấp 2','cungcap2@gmail.com','0123684734',N'Quận 12')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC3',N'Nhà Cung Cấp 3','cungcap3@gmail.com','0957647746',N'Quận 1')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC4',N'Nhà Cung Cấp 4','cungcap4@gmail.com','0919884738',N'Quận 3')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC5',N'Nhà Cung Cấp 5','cungcap5@gmail.com','0909879377',N'Quận 9')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC6',N'Nhà Cung Cấp 6','cungcap6@gmail.com','0125798223',N'Quận 10')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC7',N'Nhà Cung Cấp 7','cungcap7@gmail.com','0931981446',N'Quận 7')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC8',N'Nhà Cung Cấp 8','cungcap8@gmail.com','0933933947',N'Quận 2')
INSERT INTO dbo.NHACUNGCAP ( MaNCC, TenNCC, Email, Fax, DiaChi )VALUES  ( 'NCC9',N'Nhà Cung Cấp 9','cungcap9@gmail.com','0945212310',N'Quận 8')


-- NGHÀNH HÀNG ---------------------------------------------
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'TBDT', N'Thiết Bị Điện Tử')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'PKDT',N'Phụ Kiện Điện Tử')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'SKSD',N'Sức Khỏe Và Sắc Đẹp')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'NGK',N'Nước Giải Khát')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'TSSDC',N'Trẻ Sơ Sinh Và Đồ Chơi')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'TC',N'Thú Cưng')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'TTDL',N'Thể Thao Và Du Lịch')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'PTDL',N'Phương Tiện Đi Lại')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'TT',N'Thời Trang')
INSERT INTO dbo.NGHANHHANG( MaNH, TenNH )VALUES  ( 'SVPP',N'Sách Và Văn Phòng Phẩm')


-- DANH MỤC -----------------------------------------------

--Cho nghành hàng thiết bị điện tử--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'TV', N'TiVi','TBDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'LT',N'LapTop','TBDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'DT',N'Điện Thoại','TBDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'ML',N'Máy Lạnh','TBDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'MG',N'Máy Giặt','TBDT')

--Cho nghành hàng phụ kiện điện tử--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'BP',N'Bàn Phím','PKDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'C',N'Chuột','PKDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'L',N'Loa','PKDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'DS',N'Dây Sạc','PKDT')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'TN',N'Tai Nghe','PKDT')
--Cho nghành hàng phụ kiện điện tử--

--Cho nghành hàng sức khỏe và sắc đẹp--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'DCG',N'Dụng Cụ Gym','SKSD')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'MP',N'Mỹ Phẩm','SKSD')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'NH',N'Nước Hoa','SKSD')
--Cho nghành hàng sức khỏe và sắc đẹp--

--Cho nghành hàng nước giải khát--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'NDC',N'Nước Đóng Chai','NGK')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'NDL',N'Nước Đóng Lon','NGK')
--Cho nghành hàng nước giải khát--

--Cho nghành hàng trẻ sơ sinh và đồ chơi--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'DC',N'Đồ Chơi','TSSDC')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'SB',N'Sữa Bột','TSSDC')
--Cho nghành hàng trẻ sơ sinh và đồ chơi--

--Cho nghành hàng thú cưng--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'TATC',N'Thức Ăn Thú Cưng','TC')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'CSTC',N'Chăm Sóc Thú Cưng','TC')
--Cho nghành hàng thú cưng--

--Cho nghành hàng thể thao và du lịch--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'DCTT',N'Dụng Cụ Thể Thao','TTDL')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'DCCT',N'Dụng Cụ Cắm Trại','TTDL')
--Cho nghành hàng thể thao và du lịch--

--Cho nghành hàng phương tiện đi lại--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'OT',N'Ô Tô','PTDL')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'XM',N'Xe Máy','PTDL')
--Cho nghành hàng phương tiện đi lại--

--Cho nghành hàng thời trang--
INSERT INTO dbo.DANHMUC( MaDM, TenDM, MaNH )VALUES  ( 'AQ',N'Áo Quần','TT')
INSERT INTO dbo.DANHMUC( MaDM, TenDM, MaNH )VALUES  ( 'GD',N'Giầy Dép','TT')
INSERT INTO dbo.DANHMUC( MaDM, TenDM, MaNH )VALUES  ( 'BL',N'BaLo','TT')
--Cho nghành hàng thời trang--

--Cho nghành hàng sách và văn phòng phẩm--
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'S',N'Sách','SVPP')
INSERT INTO dbo.DANHMUC ( MaDM, TenDM, MaNH )VALUES  ( 'HTVP',N'Học Tập Và Văn Phòng','SVPP')
--Cho nghành hàng sách và văn phòng phẩm--



-- SẢN PHẨM -----------------------------------------------
-- cho danh muc dien thoai--
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'iphone6s' ,N'Iphone 6S' ,12 ,10000000 ,12000000 ,50 ,N'Apple A9' ,'DT' ,'apple' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'iphone7' ,N'Iphone 7' ,12 ,15000000 ,18000000 ,50 ,N'Apple A10' ,'DT' ,'apple' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'iphonex' ,N'Iphone X' ,12 ,20000000 ,25000000 ,50 ,N'Apple A11 Bionic' ,'DT' ,'apple' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'asuszenmax' ,N'Asus Zen Max' ,12 ,7000000 ,9000000 ,50 ,N'Not found' ,'DT' ,'asus' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'asuszenfone5' ,N'Asus Zenfone 5' ,12 ,8000000 ,9000000 ,50 ,N'Not found' ,'DT' ,'asus' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'nova3i' ,N'Huawei Nova 3i' ,12 ,5000000 ,6500000 ,50 ,N'not found' ,'DT' ,'huawei' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'oppof3' ,N'Oppo F3' ,12 ,5000000,7000000,50 ,N'not found' ,'DT' ,'oppo' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'oppof5' ,N'Oppo F5' ,12 ,5000000,7000000,50 ,N'not found' ,'DT' ,'oppo' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 's9' ,N'SamSung Galaxy S9' ,12 ,15000000,18000000,50 ,N'quancom snapdagron' ,'DT' ,'samsung' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'note9' ,N'SamSung Galaxy Note 9' ,12 ,20000000,22000000,50 ,N'quancom snapdagron 8989' ,'DT' ,'samsung' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'sonyxperiaz1' ,N'Sony Xperia Z1' ,12 ,13000000,15000000,50 ,N'Not found' ,'DT' ,'sony' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'sonyxperiaz2' ,N'Sony Xperia Z2' ,12 ,12000000,14000000,50 ,N'Not found' ,'DT' ,'sony' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'nokian95' ,N'Nokia N95' ,12 ,7000000,8000000,50 ,N'Not found' ,'DT' ,'nokia' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'nokialumia' ,N'Nokia Lumia' ,12 ,5000000,6000000,50 ,N'Not found' ,'DT' ,'nokia' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'lenovoa7010' ,N'Lenovo A7010' ,12 ,9000000,10000000,50 ,N'Not found' ,'DT' ,'lenovo' ,'GG0')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'lenovos60' ,N'Lenovo S60' ,12 ,3000000,4000000,50 ,N'Not found' ,'DT' ,'lenovo' ,'GG0')
-- cho danh muc dien thoai--


-- cho danh muc laptop--
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'macbookair2018' ,N'Macbook Air' ,24 ,25000000 ,35000000 ,20 ,N'not found' ,'LT' ,'apple' ,'GG2')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'macbookpro2018' ,N'Macbook Pro' ,12 ,30000000 ,40000000 ,20 ,N'not found' ,'LT' ,'apple' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'a456u' ,N'Laptop Asus A456U' ,12 ,10000000,13000000,50 ,N'not found' ,'LT' ,'asus' ,'GG3')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'vivobookx510ua' ,N'Asus VivoBook X510UA' ,12 ,10000000,13000000,50 ,'not found','LT' ,'asus' ,'GG3')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'alienwarem14x' ,N'Alienware M14x' ,12 ,30000000,35000000,50 ,N'not found' ,'LT' ,'alienware' ,'GG2')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'aspirea315' ,N'Aspire A315' ,12 ,15000000,17000000,50 ,N'not found' ,'LT' ,'acer' ,'GG2')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'dellvostro5568' ,N'Dell Vostro 5568' ,12 ,12000000,16000000,50, N'not found' ,'LT' ,'dell' ,'GG2')
-- cho danh muc laptop--

-- cho danh muc Chuot--
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'sensei310' ,N'SteelSeries Sensei 310' ,12 ,2000000,3000000,50 ,N'not found' ,'C' ,'razer' ,'GG2')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'rival300' ,N'SteelSeries Rival 300' ,12 ,2000000,4000000,50 ,N'not found' ,'C' ,'razer' ,'GG5')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'g600mmo' ,N'Logitech G600 MMO' ,12 ,2000000,4000000,50 ,N'not found' ,'C' ,'logitech' ,'GG4')

-- cho danh muc Ban phim--
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'logitechg810' ,N'Logitech G810' ,12 ,3000000,4500000,50 ,N'not found' ,'BP' ,'logitech' ,'GG4')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'chromav2' ,N'Chroma V2' ,12 ,3000000,4500000,50 ,N'not found' ,'BP' ,'razer' ,'GG2')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'corsairk70' ,N'Corsair K70 RAPIDFIRE' ,12 ,3000000, 4500000,50 ,N'not found' ,'BP' ,'corsair' ,'GG1')

-- cho danh muc tai nghe--
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'airpod' ,N'Apple AirPod' ,12 ,5000000,6000000,50 ,N'not found' ,'TN' ,'apple' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'beats3power' ,N'PowerBeats 3 Nobox Black',12 ,2000000,3000000,50 ,N'not found' ,'TN' ,'beats' ,'GG3')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'beatmixr' ,N'Beat Mixr' ,12 ,4000000,5000000,50 ,N'not found' ,'TN' ,'beats' ,'GG1')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'philips3800' ,N'Philips SHE 3800' ,12 ,1000000,2000000,50 ,N'not found' ,'TN' ,'philips' ,'GG5')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'philips3060' ,N'Philips SHL3060' ,12 ,3000000,4000000,50 ,N'not found' ,'TN' ,'philips' ,'GG3')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'sonyex250ap' ,N'SONY EX250AP' ,12 ,500000,700000,50 ,N'not found' ,'TN' ,'sony' ,'GG3')
INSERT INTO dbo.SANPHAM( MaSP ,TenSP ,ThoiGianBH ,GiaNhap ,GiaBan ,TonKho ,ThongSoSP ,MaDM ,MaTH ,MaGG)
VALUES  ( 'sonyxb450ap' ,N'EXTRA BASS MDR XB450AP' ,12 ,1000000,2000000,50 ,N'not found' ,'TN' ,'sony' ,'GG3')



-- BỘ PHẬN ---------------------------------------------
INSERT INTO dbo.BOPHAN( MaBP, TenBP, SDT)VALUES ( 'BP1',N'Quản Lý','0909887461')
INSERT INTO dbo.BOPHAN( MaBP, TenBP, SDT)VALUES ( 'BP2',N'Kho Hàng','0968675373')
INSERT INTO dbo.BOPHAN( MaBP, TenBP,SDT)VALUES ( 'BP3',N'Kiểm Kê','0176427632')
INSERT INTO dbo.BOPHAN( MaBP, TenBP, SDT)VALUES ( 'BP4',N'Tư Vấn','0183647534')
INSERT INTO dbo.BOPHAN( MaBP, TenBP, SDT)VALUES ( 'BP5',N'Giao Hàng','0568197874')



-- NHÂN VIÊN -----------------------------------------------
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV0' ,N'Lê Đình Lộc' ,'M' ,'19981210' ,'ledinhloc@gmail.com' ,'0123141101' ,5000000 ,'BP5')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV1' ,N'Võ Như Phú' ,'M' ,'19980715' ,'vonhuphu@gmail.com' ,'0125719605' ,4500000 ,'BP5')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV2' ,N'Trần Công Minh' ,'M' ,'19970410' ,'trancongminh@gmail.com' ,'0125986579' ,3000000 ,'BP2')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV3' ,N'Trần Duy Hoàng' ,'M' ,'19971004' ,'tranduyhoang@gmail.com' ,'0125564224' ,2500000 ,'BP2')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV4' ,N'Vũ Thị Lan' ,'F' ,'19990522' ,'vuthilan@gmail.com' ,'0127775469' ,6000000 ,'BP3')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV5' ,N'Đỗ Quý Long' ,'M' ,'19961005' ,'doquylong@gmail.com' ,'0123331532' ,3000000 ,'BP3')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV6' ,N'Lê Trúc Lâm' ,'M' ,'19980815' ,'letruclam@gmail.com' ,'0125467955' ,3500000 ,'BP4')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV7' ,N'Nguyễn Nguyên Khôi' ,'M' ,'19980306' ,'nguyennguyenkhoi@gmail.com' ,'0123876556' ,4000000 ,'BP2')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV8' ,N'Phạm Nguyễn Trung Phong' ,'M' ,'19980218' ,'trungphong@gmail.com' ,'0965344532' ,3500000 ,'BP2')
INSERT INTO dbo.NHANVIEN( MaNV ,HoTen ,GioiTinh ,NgaySinh ,Email ,SDT ,MucLuong ,MaBP)
VALUES( 'NV9' ,N'Võ Duy Khánh' ,'M' ,'19960903' ,'voduykhanh@gmail.com' ,'0931061891' ,10000000 ,'BP1')



-- KHÁCH HÀNG -----------------------------------------------
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang0' ,N'Trần Quốc Tuấn' ,'M' ,'19701215' ,N'TP Hồ Chí Minh')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang1' ,N'Lê Minh Đạt' ,'M' ,'19860516' ,N'TP Nha Trang')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang2' ,N'Ngô Minh Tiến' ,'M' ,'19900413' ,N'TP Hồ Chí Minh')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang3' ,N'Lê Thị Huyền' ,'F' ,'19920710' ,N'Tây Ninh')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang4' ,N'Trần Ngọc Mai' ,'F' ,'19950420' ,N'Cần Thơ')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang5' ,N'Đặng Thu Thảo' ,'F' ,'19930915' ,N'Tiền Giang')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang6' ,N'Phạm Ngọc Vượng' ,'M' ,'19720415' ,N'Đà Lạt')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang7' ,N'Nguyễn Ngọc Duy' ,'M' ,'19750818' ,N'Bình Dương')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang8' ,N'Hồ Minh Tài' ,'M' ,'19750214' ,N'Quảng Ngãi')
INSERT INTO dbo.KHACHHANG ( Username ,HoTen ,GioiTinh ,NgaySinh ,DiaChi)
VALUES  ( 'khachhang9' ,N'Nguyễn Minh Vương' ,'M' ,'19971014' ,N'Gia Lai')


---- SDT_KHACHHANG ---------------------------------------------------------
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0948393939','khachhang0')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0941031285','khachhang1')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0981542393','khachhang2')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0941170883','khachhang3')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0941751456','khachhang4')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0941202737','khachhang5')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0941050345','khachhang6')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0967147577','khachhang7')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0962427797','khachhang8')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0965056046','khachhang9')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0125562356','khachhang5')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0127684657','khachhang3')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0968755624','khachhang1')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0125998112','khachhang8')
INSERT INTO dbo.SDT_KHACHHANG( SDT, Username )VALUES  ( '0988456453','khachhang6')


-- HÓA ĐƠN VÀ CHI TIẾT HÓA ĐƠN ----------------------------------------
Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD3547658970','20181003','Not','khachhang8','NV1')
insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
values ('a456u','HD3547658970',5)
insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
values ('airpod','HD3547658970',3)
-------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD5465765687','20180903','Not','khachhang5','NV2')
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('beatmixr','HD5465765687',4)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('iphone6s','HD5465765687',2)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('lenovos60','HD5465765687',1)
-------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD1323436099','20180902','Not','khachhang2','NV7')
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('lenovos60','HD1323436099',7)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('s9','HD1323436099',2)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('rival300','HD1323436099',3)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('oppof3','HD1323436099',1)
------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD1234567891','20181002','Not','khachhang7','NV9')
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('oppof5','HD1234567891',2)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('s9','HD1234567891',3)
--------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD8379025617','20180827','Not','khachhang3','NV1')
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('note9','HD8379025617',2)
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('nova3i','HD8379025617',1)
----------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD2930467832','20180824','Not','khachhang5','NV4')
Insert into CHITIET_HOADON (MaSP, MaHD , SoLuong)
Values ('sensei310','HD2930467832',7)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('s9','HD2930467832',2)
----------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD0098023764','20181010','Not','khachhang9','NV8')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('nokialumia','HD0098023764',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('vivobookx510ua','HD0098023764',1)
----------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD5492700921','20180923','Not','khachhang4','NV6')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('nokialumia','HD5492700921',5)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('nokian95','HD5492700921',2)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('philips3800','HD5492700921',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('philips3060','HD5492700921',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyex250ap','HD5492700921',2)
-----------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD2839564722','20180830','Not','khachhang9','NV1')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyxperiaz1','HD2839564722',6)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyxperiaz2','HD2839564722',3)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('dellvostro5568','HD2839564722',2)
----------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD2259184925','20181005','Not','khachhang7','NV8')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyxperiaz2','HD2259184925',5)
---------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD2703199801','20180909','Not','khachhang7','NV9')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyxperiaz2','HD2703199801',4)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('beats3power','HD2703199801',2)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('chromav2','HD2703199801',1)
--------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD0301991805','20180807','Not','khachhang6','NV7')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('corsairk70','HD0301991805',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('chromav2','HD0301991805',2)
--------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD1603200098','20181008','Not','khachhang3','NV1')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('alienwarem14x','HD1603200098',2)
-------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD7112017987','20181009','Not','khachhang5','NV2')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('airpod','HD7112017987',8)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('aspirea315','HD7112017987',6)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('asuszenfone5','HD7112017987',4)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('chromav2','HD7112017987',2)
------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD1357924680','20180927','Not','khachhang4','NV4')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('corsairk70','HD1357924680',2)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('dellvostro5568','HD1357924680',2)
------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD8473906447','20181005','Not','khachhang5','NV5')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('g600mmo','HD8473906447',2)
-----------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD2598303554','20180808','Not','khachhang8','NV2')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('iphonex','HD2598303554',9)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('logitechg810','HD2598303554',4)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyex250ap','HD2598303554',7)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyxperiaz2','HD2598303554',6)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('vivobookx510ua','HD2598303554',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('philips3800','HD2598303554',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('beatmixr','HD2598303554',10)
-----------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD6629300564','20180909','Not','khachhang9','NV9')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('iphone7','HD6629300564',2)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('logitechg810','HD6629300564',2)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('note9','HD6629300564',4)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('nokialumia','HD6629300564',1)
------------------------------------------------------------

Insert into HOADON (MaHD, ThoiGianLapHD, GhiChu, USername, MaNV)
VALUES ('HD4980334355','20180830','Not','khachhang4','NV3')
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('nova3i','HD4980334355',1)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('sonyxb450ap','HD4980334355',2)
Insert into CHITIET_HOADON (MaSP, MaHD, SoLuong)
Values ('rival300','HD4980334355',5)
------------------------------------------------------------


-- PHIẾU NHẬP HÀNG VÀ CHI TIẾT PHIẾU NHẬP HÀNG --------------------
INSERT INTO dbo.PHIEUNHAPHANG( MaPN, NgayNhap, MaNV, MaNCC )
VALUES( 'PN1234567891','20180212','NV2','NCC1')
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'corsairk70','PN1234567891',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'sonyxb450ap','PN1234567891',60)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'rival300','PN1234567891',50)
------------------------------------------------------------------------------------------

INSERT INTO dbo.PHIEUNHAPHANG( MaPN, NgayNhap, MaNV, MaNCC )
VALUES( 'PN1958763563','20180315','NV3','NCC5')
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'iphonex','PN1958763563',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'sonyxperiaz2','PN1958763563',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'logitechg810','PN1958763563',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'vivobookx510ua','PN1958763563',50)
------------------------------------------------------------------------------------------

INSERT INTO dbo.PHIEUNHAPHANG( MaPN, NgayNhap, MaNV, MaNCC )
VALUES( 'PN1234923894','20180330','NV3','NCC8')
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'alienwarem14x','PN1234923894',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'airpod','PN1234923894',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'asuszenfone5','PN1234923894',50)
------------------------------------------------------------------------------------------

INSERT INTO dbo.PHIEUNHAPHANG( MaPN, NgayNhap, MaNV, MaNCC )
VALUES( 'PN5976736093','20180601','NV7','NCC2')
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'lenovos60','PN5976736093',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'oppof5','PN5976736093',50)
------------------------------------------------------------------------------------------

INSERT INTO dbo.PHIEUNHAPHANG( MaPN, NgayNhap, MaNV, MaNCC )
VALUES( 'PN2299669473','20180930','NV8','NCC3')
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'note9','PN2299669473',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'nova3i','PN2299669473',50)
INSERT INTO dbo.CHTIETPHIEUNHAP( MaSP, MaPN, SoLuong )
VALUES( 'sensei310','PN2299669473',50)
-------------------------------------------------------------------------------------------

----------------------------------END INSERT DATA-------------------------------------






--------------------------VIEW---------------------------------
CREATE VIEW Product_View AS SELECT SP.MaSP,SP.TenSP,SP.MaTH, SP.ThongSoSP FROM dbo.SANPHAM AS SP

SELECT * FROM Product_View

UPDATE Product_View SET ThongSoSP = 'Just Update'
WHERE ThongSoSP like 'not found'

DROP VIEW Product_View
--------------------------VIEW---------------------------------




----------------------------------SELECT DATA-------------------------------------
---- Easy ----
SELECT * FROM dbo.DANHMUC WHERE TenDM = 'BaLo'
SELECT * FROM dbo.DANHMUC WHERE MaDM IN ('DT','LT','BL')
SELECT * FROM dbo.DANHMUC WHERE MaDM NOT IN ('DT','LT','BL')
SELECT TenSP, GiaBan FROM dbo.SANPHAM WHERE GiaBan BETWEEN 5000000 AND 15000000
SELECT TenSP, GiaBan FROM dbo.SANPHAM WHERE GiaBan NOT BETWEEN 5000000 AND 15000000
SELECT TenSP, GiaBan FROM dbo.SANPHAM WHERE GiaBan > 15000000
SELECT * FROM dbo.DANHMUC WHERE MaDM BETWEEN 'A' AND 'C'
SELECT * FROM dbo.DANHMUC WHERE TenDM = 'BaLo' OR TenDM = N'Dây Sạc'
SELECT * FROM dbo.SANPHAM WHERE MaSP = 'a456u' AND GiaBan > 10000000
SELECT * FROM dbo.SANPHAM WHERE MaSP LIKE 'a%'
SELECT * FROM dbo.SANPHAM WHERE MaSP LIKE '%a'
SELECT * FROM dbo.SANPHAM WHERE MaSP LIKE '%a%'
SELECT * FROM dbo.THUONGHIEU WHERE MaTH LIKE 'a____'
SELECT * FROM dbo.THUONGHIEU WHERE MaTH LIKE '___r'
SELECT * FROM dbo.THUONGHIEU WHERE MaTH LIKE '__a%'
SELECT * FROM dbo.SANPHAM WHERE TenSP LIKE 'as%'
---- Easy ----



-----------------------------------------------------------------------------------------------------------------------------------
-- Truy xuất thông tin của các sản phẩm thuộc danh mục Điện Thoại
SELECT * FROM dbo.SANPHAM AS SP
WHERE SP.MaDM = 'DT'

-- Kiểm tra các danh mục mà có chứa sản phẩm trong danh sách sản phẩm
-- Cách 1: Loại bỏ trùng lặp mã danh mục trong bảng sản phẩm
SELECT DISTINCT SP.MaDM, DM.TenDM
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM
WHERE SP.MaDM = DM.MaDM

-- Cách 2: truy vấn lồng
SELECT DM.MaDM , DM.TenDM FROM dbo.DANHMUC AS DM
WHERE DM.MaDM IN (SELECT SP.MaDM FROM dbo.SANPHAM AS SP)


--Có bao nhiêu sản phẩm có 'TenSP' bắt đầu bằng 'as'
SELECT COUNT(*) AS SoLuongSanPham FROM dbo.SANPHAM WHERE TenSP LIKE 'as%'

--Tổng giá trị bán của các sản phẩm có 'TenSP' bắt đầu bằng 'as'
SELECT SUM(SP.GiaBan) 'Tong Gia Tri'
FROM dbo.SANPHAM AS SP
WHERE SP.TenSP LIKE 'as%'

-- Trung bình 'GiaNhap' của các SP có 'TenSP' bắt đầu bằng 'as'
SELECT AVG(GiaNhap) AS AVGPrice FROM dbo.SANPHAM WHERE TenSP LIKE 'as%'

-- Sản phẩm có giá bán cao nhất trong các SP có 'TenSp' bắt đầu bằng 'as'
-- Cách 1:
SELECT SP.TenSP AS TenSanPham, MAX(GiaBan) AS GiaBanCaoNhat
FROM dbo.SANPHAM AS SP WHERE TenSP LIKE 'as%'
-- Cách 2:
SELECT TOP (1) TenSP, GiaBan FROM dbo.SANPHAM
WHERE TenSP LIKE 'as%'
ORDER BY GiaBan DESC


-- Lấy ra 3 sản phẩm có giá bán thấp nhất
SELECT TOP 3 SP.TenSP AS TenSanPham, SP.GiaBan AS GiaBanThapNhat
FROM dbo.SANPHAM AS SP
GROUP BY SP.TenSP,SP.GiaBan ORDER BY GiaBanThapNhat ASC



---ORTHER BY : Sắp xếp dữ liệu theo thứ tự tăng dần hoặc giảm dần, dựa trên một hoặc nhiều cột.
-- Sắp xếp các SP với 'TenSP' tăng dần
SELECT SP.MaSP, SP.TenSP FROM dbo.SANPHAM AS SP ORDER BY TenSP ASC
-- Sắp xếp các SP theo giá bán tăng dần
SELECT MaSP,GiaBan FROM dbo.SANPHAM ORDER BY GiaBan ASC -- sap xep cac SP voi MaSP tang dan
-- Sắp xếp theo MaNH trước, sau đó sắp xếp theo MaDM (tăng dần)
SELECT * FROM dbo.DANHMUC ORDER BY MaNH, MaDM ASC
-- Sắp xếp theo 'MaDM' trước, sau đó sắp xếp theo 'MaNH' (Giảm dần)
SELECT * FROM dbo.DANHMUC ORDER BY MaDM, MaNH DESC






---GROUP BY : Sử dụng hợp tác với câu lệnh SELECT để sắp xếp dữ liệu giống nhau thành các nhóm.
--Mệnh đề GROUP BY này tuân theo mệnh đề WHERE trong câu lệnh SELECT và đứng trước mệnh đề ORDER BY.


-- Xuất ra số lượng danh mục tương ứng với mỗi nghành hàng (sắp xếp tăng dần)
SELECT NH.TenNH 'TÊN NGHÀNH HÀNG',COUNT(DM.MaDM) AS SoLuongDanhMuc
FROM dbo.DANHMUC AS DM, dbo.NGHANHHANG AS NH
WHERE DM.MaNH = NH.MaNH
GROUP BY NH.TenNH ORDER BY SoLuongDanhMuc ASC


-- Tổng giá trị bán ra của các sản phẩm thuộc từng danh mục , sắp xếp các tổng giá trị đó theo giảm dần
SELECT DM.TenDM AS TenDanhMuc,SUM(SP.GiaBan) AS TongGiaTri
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM
WHERE SP.MaDM = DM.MaDM
GROUP BY DM.TenDM ORDER BY TongGiaTri


--Các sản phẩm có giá bán lớn nhất trong từng danh mục
SELECT DM.TenDM AS TenDanhMuc, MAX(SP.GiaBan) SanPhamGiaCaoNhat
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM
WHERE SP.MaDM = DM.MaDM
GROUP BY DM.TenDM ORDER BY SanPhamGiaCaoNhat ASC




-- Giá trị trung bình các sản phẩm trong từng danh mục, sắp xếp các giá trị theo giảm dần
SELECT DM.TenDM AS TenDanhMuc, AVG(SP.GiaBan) AS GiaTriBanTrungBinh
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM
WHERE SP.MaDM = DM.MaDM
GROUP BY DM.TenDM ORDER BY GiaTriBanTrungBinh ASC


-- Giá trị trung bình tổng các sản phẩm trong danh mục laptop
SELECT AVG(GiaBan) AS TrungBinhGiaTri, MaDM
FROM dbo.SANPHAM AS SP
WHERE SP.MaDM = 'LT'
GROUP BY MaDM




------------------------HAVING: Chỉ định điều kiện lọc mà kết quả nhóm xuất hiện trong kết quả --------------------------
--Mệnh đề WHERE đặt các điều kiện vào các cột đã chọn, trong khi mệnh đề HAVING đặt các điều kiện vào các nhóm được tạo bởi mệnh đề GROUP BY.

-- tổng giá trị (nhập) các sản phẩm của từng danh mục khi được nhóm bởi GroupBy và điều kiện là sau khi được nhóm thì phải có giá trị trên 100000000
SELECT SUM(GiaNhap) AS TongGiaTriNhap, MaDM AS CodeCategory
FROM dbo.SANPHAM 
GROUP BY MaDM HAVING SUM(GiaNhap) > 100000000 
ORDER BY TongGiaTriNhap ASC;


-- Liệt kê các danh mục có số sản phẩm tồn kho nhỏ hơn 200
SELECT DM.TenDM AS TenDanhMuc , SUM(SP.TonKho) AS SoLuongTonKho
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM
WHERE SP.MaDM = DM.MaDM
GROUP BY DM.TenDM HAVING SUM(SP.TonKho) < 200


-- JOIN: Inner Join , Left Join, Right Join, Full Join

--Inner Join
-- hiển thị các giá trị thương hiệu tương ứng cho từng sản phẩm với phép Join dựa trên thuộc tính quan hệ chung là 'MaTH'
SELECT dbo.SANPHAM.TenSP, dbo.THUONGHIEU.TenTH
FROM dbo.SANPHAM INNER JOIN dbo.THUONGHIEU
ON THUONGHIEU.MaTH = SANPHAM.MaTH

-- hiển thị các giá trị thương hiệu tương ứng cho từng sản phẩm với phép Join dựa trên thuộc tính quan hệ chung là 'MaTH' trong 2 bảng, sắp xếp theo 'TenSP' tăng dần
SELECT dbo.SANPHAM.TenSP AS TenSanPham, dbo.THUONGHIEU.TenTH AS TenThuongHieu
FROM dbo.SANPHAM INNER JOIN dbo.THUONGHIEU
ON THUONGHIEU.MaTH = SANPHAM.MaTH ORDER BY TenSP ASC


--Left Join
-- Hiển thị toàn bộ các danh mục (bảng trái) và map với tên các nghành hàng tương ứng của danh mục , kể cả khi danh mục đó không thuộc nghành hàng đó
-- thì giá trị tại điểm Join bởi 'MaNH' đó là NULL.
SELECT dbo.DANHMUC.TenDM AS TenDanhMuc, dbo.NGHANHHANG.TenNH AS TenNghanhHang
FROM dbo.DANHMUC LEFT JOIN dbo.NGHANHHANG
ON NGHANHHANG.MaNH = DANHMUC.MaNH

--Right Join
-- Hiển thị toàn bộ các nghành hàng (bảng phải) và map với các danh mục tương ứng của nghành hàng đó , kể cả khi nghành hàng đó không có danh mục nào
-- thì giá trị tại điểm Join bởi 'MaNH' đó là NULL.
SELECT dbo.DANHMUC.TenDM AS TenDanhMuc, dbo.NGHANHHANG.TenNH AS TenNghanhHang
FROM dbo.DANHMUC RIGHT JOIN dbo.NGHANHHANG
ON NGHANHHANG.MaNH = DANHMUC.MaNH

-- Join: Tổng Giá trị của các nghành hàng có sản phẩm
-- Cách 1
SELECT SUM(SP.GiaBan) AS TongGiaTriNghanhHang, DM.MaNH AS MaNghangHang
FROM dbo.SANPHAM AS SP JOIN dbo.DANHMUC AS DM
ON DM.MaDM = SP.MaDM
GROUP BY DM.MaNH
ORDER BY TongGiaTriNghanhHang DESC

-- Cách 2
SELECT NH.TenNH, SUM(SP.GiaBan) TongGiaTriNghanhHang
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM, dbo.NGHANHHANG AS NH
WHERE SP.MaDM = DM.MaDM AND DM.MaNH = NH.MaNH
GROUP BY NH.TenNH ORDER BY TongGiaTriNghanhHang ASC


-- Sub Query
SELECT * FROM dbo.SANPHAM WHERE GiaBan <> (SELECT MAX(GiaBan) FROM dbo.SANPHAM )

SELECT * FROM dbo.SANPHAM WHERE MaSP <> (SELECT MaSP FROM dbo.SANPHAM WHERE MaDM = 'LT' )--khong cho phep truy van

SELECT * FROM dbo.SANPHAM WHERE MaSP NOT IN (SELECT MaSP FROM dbo.SANPHAM WHERE MaDM = 'LT' )--cho phep truy van

SELECT MaSP FROM dbo.SANPHAM WHERE MaDM = 'LT'-- truy van don ben ngoai thi duoc
-------------------------------------------------------------------------





--Cho biết các danh mục nào mà mỗi danh mục đó đều có 3 loại sản phẩm
SELECT DM.TenDM AS TenDanhMuc
FROM dbo.DANHMUC AS DM
WHERE 3 = ( SELECT COUNT(*) FROM dbo.SANPHAM AS SP WHERE SP.MaDM = DM.MaDM )




--Cho biết các danh mục nào mà mỗi danh mục đó đều có hơn 10 sản phẩm
SELECT DM.TenDM AS TenDanhMuc
FROM dbo.DANHMUC AS DM
WHERE 10 < ( SELECT COUNT(*) FROM dbo.SANPHAM AS SP WHERE SP.MaDM = DM.MaDM )




-- cho biết chi tiết hóa đơn có mã số 'HD1323436099'
SELECT CTHD.MaSP,CTHD.SoLuong
FROM dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD
WHERE HD.MaHD = CTHD.MaHD AND HD.MaHD = 'HD1323436099'


-- Tổng sản phẩm trong từng hóa đơn (correct)
SELECT HD.MaHD , SUM(CTHD.SoLuong) AS SoLuongSanPham
FROM dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD
WHERE HD.MaHD = CTHD.MaHD
GROUP BY HD.MaHD ORDER BY SoLuongSanPham DESC


-- Tổng sản phẩm trong hóa đơn có MaHD: HD0098023764

SELECT HD.MaHD , SUM(CTHD.SoLuong) AS SoLuongSanPham
FROM dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD
WHERE HD.MaHD = CTHD.MaHD AND HD.MaHD = 'HD0098023764'



-- Cho biết tên của từng khách hàng và số hóa đơn đã mua của từng khách hàng
-- Và sắp xếp giảm dần theo số lượng hóa đơn
SELECT KH.HoTen AS TenKhachHang, COUNT(HD.MaHD) AS SoLuongHoaDon
FROM dbo.HOADON AS HD, dbo.KHACHHANG AS KH
WHERE KH.Username = HD.USername
GROUP BY KH.HoTen, HD.USername
ORDER BY SoLuongHoaDon DESC;



-- Cho biết số lượng hóa đơn đã mua của khách hàng Hồ Minh Tài
SELECT KH.HoTen, COUNT(HD.MaHD) AS SoLuongHoaDon
FROM dbo.HOADON AS HD, dbo.KHACHHANG AS KH
WHERE HD.USername = KH.Username AND KH.HoTen = N'Hồ Minh Tài'
GROUP BY KH.HoTen
ORDER BY SoLuongHoaDon DESC





-- Cho biết tên của từng khách hàng và số loại sản phẩm đã mua, sắp xếp tăng dần
SELECT KH.HoTen AS TenKhachHang, COUNT(CTHD.MaSP) AS SoLoaiSanPham
FROM dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD, dbo.KHACHHANG AS KH
WHERE KH.Username = HD.USername AND HD.MaHD = CTHD.MaHD
GROUP BY KH.HoTen
ORDER BY SoLoaiSanPham ASC;




-----here ->
-- Cho biết nhân viên có Mã X đã giao được bao nhiêu đơn hàng
SELECT NV.HoTen AS TenNhanVien ,COUNT(HD.MaNV) AS SoLuongGiao
FROM dbo.HOADON AS HD, dbo.NHANVIEN AS NV
WHERE HD.MaNV = NV.MaNV AND HD.MaNV = 'NV2'
GROUP BY NV.HoTen




-- Cho biết nhân viên có tên X đã ký bao nhiêu phiếu nhập hàng
SELECT NV.HoTen, COUNT(PNH.MaNV) AS SLPhieuNhapHangDaKy
FROM dbo.PHIEUNHAPHANG AS PNH, dbo.NHANVIEN AS NV
WHERE PNH.MaNV = NV.MaNV AND NV.HoTen = N'Trần Duy Hoàng'
GROUP BY NV.HoTen





-- Cho biết số lượng hóa đơn mà mỗi nhân viên đã giao
SELECT Bill.MaNV AS CodeOfStaff, COUNT(Bill.MaHD) AS QuantityDelivery
FROM dbo.HOADON AS Bill
GROUP BY Bill.MaNV
ORDER BY Bill.MaNV ASC






-- Cho biết số lượng phiếu nhập của mỗi nhân viên đã ký
SELECT NV.HoTen AS Hoten, COUNT(PNH.MaPN) AS SL_PhieuNhapHang
FROM dbo.PHIEUNHAPHANG AS PNH, dbo.NHANVIEN AS NV
WHERE PNH.MaNV = NV.MaNV
GROUP BY NV.HoTen ORDER BY SL_PhieuNhapHang ASC








-- Cho biết có bao nhiêu sản phẩm thuộc nghành hàng có mã nghành hàng là X
SELECT NH.TenNH AS TenNganhHang , COUNT(SP.MaSP) AS SoLuongSanPham
FROM dbo.DANHMUC AS DM, dbo.NGHANHHANG AS NH, dbo.SANPHAM AS SP
WHERE SP.MaDM = DM.MaDM AND DM.MaNH = NH.MaNH AND DM.MaNH = 'TBDT'
GROUP BY NH.TenNH



-- Cho biết Số lượng sản phẩm của từng danh mục và sắp xếp tăng dần theo 'MaDM'
SELECT COUNT(SP.MaSP) AS QuantityOfProduct, SP.MaDM AS CodeCategory
FROM dbo.SANPHAM AS SP
GROUP BY SP.MaDM ORDER BY SP.MaDM ASC

-- Cho biết danh mục có nhiều sản phẩm nhất
SELECT SP.MaDM AS CodeOfCategory , COUNT(SP.MaSP) AS MaxQuantity
FROM dbo.SANPHAM AS SP
GROUP BY SP.MaDM
ORDER BY SP.MaDM



--truy vấn lồng
SELECT * FROM dbo.SANPHAM

--Xuất ra danh sách danh mục mà danh mục đó có hơn 5 sản phẩm -- correct
SELECT * FROM dbo.DANHMUC AS DM
WHERE 5 <
(
SELECT COUNT(*) FROM dbo.SANPHAM AS SP
WHERE SP.MaDM = DM.MaDM
)

-- Phép giao Intersect --
-- Tìm những mặt hàng xuất hiện trong SP và trong SPYT
--SELECT SP.MaSP FROM dbo.SANPHAM AS SP
--INTERSECT
--SELECT SPYT.MaSP FROM dbo.SANPHAMYEUTHICH AS SPYT

-- Phép loại trừ Except--
-- Liệt kê 'MaSP' của các sản phẩm chưa bán được (ngoại trừ các 'MaSP' đã tồn tại trong bảng Chi Tiết Hóa Đơn)
SELECT SP.MaSP FROM dbo.SANPHAM AS SP
EXCEPT
SELECT CTHD.MaSP FROM dbo.CHITIET_HOADON AS CTHD

-- Câu lệnh trên tương đương với
SELECT SP.MaSP FROM dbo.SANPHAM AS SP
WHERE SP.MaSP NOT IN (
SELECT DISTINCT CTHD.MaSP FROM dbo.CHITIET_HOADON AS CTHD
)

-- Xuất ra các hóa đơn được tạo từ 1/9/2018 - 30/9/2018 , sắp xếp thời gian tăng dần
SELECT * FROM dbo.HOADON AS HD
WHERE HD.ThoiGianLapHD >= '2018/9/1' AND HD.ThoiGianLapHD <= '2018/9/30'
ORDER BY HD.ThoiGianLapHD

-- Xuất ra tổng tiền của từng hóa đơn(correct)
SELECT CTHD.MaHD ,SUM(SP.GiaBan*CTHD.SoLuong) AS ThanhTien
FROM dbo.CHITIET_HOADON CTHD, dbo.SANPHAM AS SP
WHERE CTHD.MaSP = SP.MaSP
GROUP BY CTHD.MaHD

-- Xuất ra tổng tiền thanh toán của từng khách hàng dựa trên tổng hóa đơn của khách hàng đó(correct)
SELECT KH.HoTen, SUM(SP.GiaBan*CTHD.SoLuong) AS TongTien
FROM dbo.KHACHHANG AS KH, dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD, dbo.SANPHAM AS SP
WHERE CTHD.MaSP = SP.MaSP AND CTHD.MaHD = HD.MaHD AND HD.USername = KH.Username
GROUP BY (KH.HoTen)

-- Xuất ra các khách hàng mà tổng giá trị tiền thanh toán trên 100000000(correct)
SELECT KH.HoTen, SUM(SP.GiaBan*CTHD.SoLuong) AS TongTien
FROM dbo.KHACHHANG AS KH, dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD, dbo.SANPHAM AS SP
WHERE CTHD.MaSP = SP.MaSP AND CTHD.MaHD = HD.MaHD AND HD.USername = KH.Username
GROUP BY (KH.HoTen) HAVING SUM(SP.GiaBan*CTHD.SoLuong) > 100000000

-- Tính tổng tiền của khách hàng có tên Ngô Minh Tiến
SELECT KH.HoTen, SUM(SP.GiaBan*CTHD.SoLuong) AS TongTien
FROM dbo.KHACHHANG AS KH, dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD, dbo.SANPHAM AS SP
WHERE CTHD.MaSP = SP.MaSP AND CTHD.MaHD = HD.MaHD AND HD.USername = KH.Username
AND KH.HoTen = N'Ngô Minh Tiến'
GROUP BY (KH.HoTen)


-- Tổng các loại sản phẩm đã mua của từng khách hàng và sắp xếp tăng dần ( Vì mỗi chi tiết hóa đơn là 1 loại sản phẩm)
SELECT KH.HoTen, COUNT(CTHD.MaHD) AS SoLoaiSanPham
FROM dbo.KHACHHANG AS KH, dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD, dbo.SANPHAM AS SP
WHERE CTHD.MaSP = SP.MaSP AND CTHD.MaHD = HD.MaHD AND HD.USername = KH.Username
GROUP BY (KH.HoTen) ORDER BY SoLoaiSanPham

-- Xuất ra khách hàng mua nhiều sản phẩm nhất
-- 1 -> Số lượng sản phẩm đã mua của từng khách hàng
-- 2 -> Lấy TOP 1 của danh sách
SELECT TOP 1 KH.HoTen,SUM(CTHD.SoLuong) AS SoLuongSanPham
FROM dbo.KHACHHANG AS KH, dbo.HOADON AS HD, dbo.CHITIET_HOADON AS CTHD, dbo.SANPHAM AS SP
WHERE CTHD.MaSP = SP.MaSP AND CTHD.MaHD = HD.MaHD AND HD.USername = KH.Username
GROUP BY (KH.HoTen) ORDER BY SoLuongSanPham DESC


-- Xuất ra nhân viên giao được hơn 3 hóa đơn
SELECT NV.HoTen ,COUNT(HD.MaHD) AS abc
FROM dbo.NHANVIEN AS NV, dbo.HOADON AS HD
WHERE HD.MaNV = NV.MaNV
GROUP BY NV.HoTen HAVING COUNT(HD.MaHD) >= 3



-- Xuất ra các khách hàng mua hàng có hóa đơn được lập trong ngày 27/09/2018
SELECT * FROM dbo.KHACHHANG AS KH
WHERE KH.Username IN (
SELECT HD.USername FROM dbo.HOADON AS HD
WHERE HD.ThoiGianLapHD = '2018-09-27'
)


-- Xuất ra số lượng sản phẩm của danh mục Điện Thoại
SELECT SP.MaDM ,COUNT(*) AS QUANTITY
FROM dbo.SANPHAM AS SP, dbo.DANHMUC AS DM
WHERE SP.MaDM = DM.MaDM AND DM.MaDM  = 'DT'
GROUP BY SP.MaDM

-- tương đương
SELECT COUNT(SP.MaSP) FROM dbo.SANPHAM AS SP
WHERE SP.MaDM = 'DT'


-- xem khách hàng Hồ Minh Tài đc giao hàng bởi nhân viên nào
SELECT NV.HoTen AS TenNhanVien
FROM dbo.KHACHHANG AS KH, dbo.HOADON AS HD, dbo.NHANVIEN AS NV
WHERE KH.Username = HD.USername AND HD.MaNV = NV.MaNV AND KH.HoTen = N'Hồ Minh Tài'
GROUP BY NV.HoTen


-- tìm các khách hàng lớn hơn 35 tuổi
SELECT KH.*, YEAR(GETDATE())-YEAR(KH.NgaySinh) AS Tuoi
FROM dbo.KHACHHANG AS KH
WHERE YEAR(GETDATE())-YEAR(KH.NgaySinh) > 35




-- Cho biết số lượng phiếu nhập trong ngày 12/02/2018
SELECT PNH.MaPN AS PhieuNhap, SUM(CTPN.SoLuong) AS TongGiaTri
FROM dbo.PHIEUNHAPHANG AS PNH , dbo.CHTIETPHIEUNHAP CTPN
WHERE PNH.MaPN = CTPN.MaPN AND PNH.NgayNhap = '2018-02-12'
GROUP BY PNH.MaPN

