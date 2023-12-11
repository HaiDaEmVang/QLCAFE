CREATE DATABASE QuanLyCaFe_Demo
GO

USE QuanLyCaFe_Demo
GO

CREATE TABLE TableFood
(
	id INT IDENTITY PRIMARY KEY,
	name NVARCHAR(50) NOT NULL,
	status NVARCHAR(100) NOT NULL DEFAULT N'Trống' ----- trống|| có người 
)
GO
CREATE TABLE Account
(
	UserName NVARCHAR(100) PRIMARY KEY,
	DisplayName NVARCHAR(100) NOT NULL,
	PassWord NVARCHAR(100) NOT NULL DEFAULT 0,
	Type INT NOT NULL DEFAULT 0 ---1 :admin || 0:staff
)
GO

CREATE TABLE FoodCategory
(
	id INT IDENTITY PRIMARY KEY,
	name NVARCHAR(100) NOT NULL
)
GO

CREATE TABLE Food
(
	id INT IDENTITY PRIMARY KEY,
	name NVARCHAR(100) NOT NULL,
	idCategory INT NOT NULL FOREIGN KEY REFERENCES FoodCategory(id),
	price FLOAT NOT NULL
)
GO

CREATE TABLE Bill
(
	id INT IDENTITY PRIMARY KEY,
	DateCheckIn DATE DEFAULT GETDATE(),
	DateCheckOut DATE,
	idTable INT NOT NULL FOREIGN KEY REFERENCES TableFood(id),
	status INT NOT NULL DEFAULT 0--- 1: đã thanh toán và 0: chưa thanh toán
)
GO

CREATE TABLE BillInfo
(
	id INT IDENTITY PRIMARY KEY,
	idBill INT NOT NULL FOREIGN KEY REFERENCES Bill(id),
	idFood INT NOT NULL FOREIGN KEY REFERENCES Food(id),
	count INT NOT NULL DEFAULT 0
)
GO


insert intO FoodCategory
VALUES
	(N'Nông sản'),
	(N'Hải sản'),
	(N'Lâm sản'),
	(N'Nước ngọt'),
	(N'Sinh sản')


INSERT INTO Food
VALUES 
	(N'Mực khô', 2, 120000),
	(N'Cá khô', 2, 320000),
	(N'Cơm cháy', 1, 620000),
	(N'Rau lang muối', 1, 20000),
	(N'Da heo', 1, 120000),
	(N'Thịt cừu', 3, 140000),
	(N'Thịt Huơu', 3, 1210000),
	(N'CàFe', 4, 12000),
	(N'Sì ting', 4, 120000)


INSERT INTO Bill (DateCheckIn, DateCheckOut, idTable, status)
VALUES 
	(GETDATE(), GETDATE(), 1, 1),
	(GETDATE(), NULL, 2, 0),
	(GETDATE(), NULL,6, 0),
	(GETDATE(), GETDATE(),3, 1)


INSERT INTO BillInfo (idBill, idFood, count)
VALUES
	(1, 5, 1),
	(2, 1, 2),
	(2, 6, 2),
	(3, 5, 2),
	(1, 3, 3)

insert into Account
values ('1','1','1', 0),
		('2','2','2', 0),
		('3','3','3', 0)
GO
CREATE PROC SP_LOGIN
	@user varchar(100),
	@password varchar(100)
as
BEGIN
	SELECT * FROM Account
	WHERE UserName = @user AND @password = @password
END 
		
EXEC SP_LOGIN '1', '1'

DECLARE @ID INT;
SET @ID = 1;
WHILE @ID< 10
BEGIN
	INSERT INTO TableFood(name)
	VALUES(N'Bàn' + cast(@ID as varchar(100)))
	 SET @ID = @ID + 1;
END 



GO
alter  PROC SP_DSTABLE
AS
BEGIN
	SELECT id 'ID', name 'Tên bàn' , status 'Trạng thái' FROM TableFood
END

EXEC SP_DSTABLE

CREATE PROC SP_DSTABLETRONG
AS
BEGIN
	SELECT * FROM TableFood WHERE status = N'Trống'
END
EXEC SP_DSTABLETRONG

SELECT Food.name 'Tên Món', Food.price 'Giá', BillInfo.count 'Số lượng', Food.price * BillInfo.count 'Tổng tiền' 
FROM  BillInfo, Food, Bill
WHERE Food.id = BillInfo.idFood AND Bill.id = BillInfo.idBill  AND Bill.status = 0 AND BillInFo.idBill = 2 


GO

CREATE PROC SP_INSERTBILL
	@idTable INT
AS
BEGIN 
	INSERT INTO Bill (DateCheckOut, idTable, status)
	VALUES (NULL, @idTable, 0)
END

SELECT MAX(ID) FROM Bill

GO
ALTER PROC SP_INSERTBILLINFO
	@idBill int,
	@idFood int,
	@countNew int
AS
BEGIN
	DECLARE @countOld int;
	IF(EXISTS (SELECT * FROM BillInfo WHERE idBill = @idBill AND @idFood = idFood))
	BEGIN 
		SELECT @countOld = count  FROM BillInfo WHERE idBill = @idBill AND @idFood = idFood
		
		IF(@countNew + @countOld <= 0)
			DELETE BillInfo WHERE idBill = @idBill AND @idFood = idFood
		ELSE 
			UPDATE BillInfo SET count = @countNew + @countOld WHERE idBill = @idBill AND idFood = @idFood
	END
	ELSE 
	BEGIN
		
		IF(@countNew >0)
			INSERT INTO BillInfo (idBill, idFood, count)
				VALUES (@idBill, @idFood, @countNew)
			
	END
	IF NOT EXISTS(SELECT * FROM BillInfo WHERE idBill = @idBill)
		DELETE Bill WHERE id = @idBill
END

EXEC SP_INSERTBILL 1
EXEC  SP_INSERTBILLINFO 16, 2, -2

SELECT * FROM TableFood
SELECT * FROM Bill
SELECT * FROM BillInfo
SELECT * FROM Food
SELECT * FROM FoodCategory

GO

ALTER PROC SP_TOGLESTATUFOODTABLE
	@idTableFood INT 
AS
BEGIN
	DECLARE @statusNew  nvarchar(100)
	IF(EXISTS(SELECT * 
				FROM Bill, TableFood
				WHERE BILL.idTable = TableFood.id AND idTable = @idTableFood AND Bill.status = 0))
		SET @statusNew = N'Đã đặt'
	ELSE SET @statusNew = N'Trống'

	UPDATE TableFood 
	SET status = @statusNew
	WHERE id = @idTableFood
END

EXEC SP_TOGLESTATUFOODTABLE 1
go 

CREATE  PROC SP_LISTFOODANDCATEGORY
AS
BEGIN
	SELECT Food.name 'Tên thức ăn', FoodCategory.name 'Tên danh mục', Food.price 'Giá'
	FROM Food, FoodCategory
	WHERE Food.idCategory = FoodCategory.id
	ORDER BY Food.idCategory
END

CREATE PROC SP_LISTFOOD
AS
BEGIN
	SELECT * FROM Food
END
EXEC SP_LISTFOOD

CREATE PROC SP_LISTFOODCATEGORY
AS
BEGIN
	SELECT id 'ID', name 'Tên danh mục'  FROM FoodCategory
END
EXEC SP_LISTFOODCATEGORY

CREATE PROC SP_LISTACCOUNT
AS
BEGIN
	SELECT UserName 'Tên tài khoản', DisplayName 'Tên hiển thị' , PassWord 'Mật khẩu', type 'Loại'  FROM Account
END
EXEC SP_LISTACCOUNT

SELECT * FROM ACCOUNT


CREATE PROC SP_INS_FOOD 
	@nameFood nvarchar(100),
	@idCategory int,
	@price float
AS
BEGIN
	INSERT INTO Food 
	VALUES (@nameFood, @idCategory, @price)
END

CREATE PROC SP_UP_FOOD
	@idFood int,
	@nameFood nvarchar(100),
	@idCategory int,
	@price float
AS
BEGIN
	UPDATE Food
	SET name = @nameFood,
		idCategory	= @idCategory,
		price = @price
	WHERE id = @idFood
END

CREATE PROC SP_DEL_FOOD
	@id int
AS
BEGIN
	DELETE Food
	WHERE id = @id
END

select * from food 