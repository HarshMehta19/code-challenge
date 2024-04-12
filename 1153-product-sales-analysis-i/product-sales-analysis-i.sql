# Write your MySQL query statement below
select Product.product_name, Sales.year, Sales.price from Sales as sales join Product on Sales.product_id = Product.product_id 