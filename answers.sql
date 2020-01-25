SELECT DISTINCT * FROM TableName


INSERT INTO TableName
(
 [Column1], [Column2], [Column3]
)
VALUES
( 
 Column1_Value, Column2_Value, Column3_Value
)
GO

SELECT Customers.*, Orders.* FROM Customers FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID;