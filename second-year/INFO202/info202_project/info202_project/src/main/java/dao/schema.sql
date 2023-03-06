create table if not exists Product(
    Product_ID varchar(50) not null,
    Name varchar(50) not null,
    Description varchar(500),
    Category varchar(50) not null,
    List_Price decimal(10,2) not null,
    Quantity_In_Stock integer not null check (Quantity_In_Stock >= 0),
    constraint Product_PK primary key (Product_ID)
);

create table if not exists Customer(
    Customer_ID integer auto_increment (1000),
    Username varchar(50) not null unique,
    First_Name varchar(50) not null,
    Surname varchar(50) not null,
    Password varchar(50) not null,
    Email_Address varchar(100) not null,
    Shipping_Address varchar(500) not null,
    constraint Customer_PK primary key (Customer_ID)
);

create table if not exists Sale(
    Sale_ID integer auto_increment (1000),
    Customer_ID integer not null, --links to customer table
    Date varchar(50) not null,
    Status varchar(50) not null,
    constraint Sale_PK primary key (Sale_ID),
    constraint Sale_Customer foreign key (Customer_ID) references Customer
);

create table if not exists Sale_Item(
    Quantity_Purchased decimal(10,2) not null,
    Product_ID varchar(50) not null, --links to product table
    Sale_ID integer not null, --links to sale table
    Sale_Price decimal(10,2) not null,
    constraint Sale_Item_PK primary key (Product_ID, Sale_ID),
    constraint Sale_Item_Product foreign key (Product_ID) references Product,
    constraint Sale_Item_Sale  foreign key (Sale_ID) references Sale
);