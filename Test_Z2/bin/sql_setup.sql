CREATE DATABASE Z2_TEST

USE Z2_TEST

CREATE TABLE ROLES(
	Id INT PRIMARY KEY NOT NULL IDENTITY,
	NameRole VARCHAR(20)
)
GO

CREATE TABLE USERS(
	Id INT PRIMARY KEY NOT NULL IDENTITY,
	FullName NVARCHAR(45),
	UserName NVARCHAR(45),
	PassWord NVARCHAR(50),
	LockStatus BIT,
	IdRole INT FOREIGN KEY(IdRole) REFERENCES dbo.ROLES(Id)
)
GO


INSERT INTO dbo.ROLES(NameRole)VALUES  ('Admin')
INSERT INTO dbo.ROLES(NameRole)VALUES  ('Staff')
INSERT INTO dbo.ROLES(NameRole)VALUES  ('Customers')


INSERT INTO dbo.USERS(FullName ,UserName ,PassWord ,LockStatus ,IdRole)
VALUES  (N'Võ Duy Khánh' ,'khanh' ,'111' ,0 ,1)
INSERT INTO dbo.USERS(FullName ,UserName ,PassWord ,LockStatus ,IdRole)
VALUES  (N'Trần Công Minh' ,'minh' ,'222' ,0 ,2)
INSERT INTO dbo.USERS(FullName ,UserName ,PassWord ,LockStatus ,IdRole)
VALUES  (N'Đỗ Quý Long' ,'long' ,'333' ,0 ,3)