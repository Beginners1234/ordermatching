
drop table TRADE_DETAILS
drop table USER_DETAILS
drop table ORDER_DETAILS


CREATE TABLE USER_DETAILS(
user_id NUMERIC(4) IDENTITY (1001,1) NOT NULL CONSTRAINT USER_DETAILS_user_id_pk PRIMARY KEY,
name VARCHAR(30) NOT NULL,
login_id VARCHAR(30) NOT NULL CONSTRAINT USER_login_id UNIQUE,
password VARCHAR(20) NOT NULL,
contact NUMERIC(10) NOT NULL,
reg DATETIME
)

CREATE TABLE ORDER_DETAILS(
order_id NUMERIC(4) IDENTITY (1,1) NOT NULL CONSTRAINT ORDER_DETAILS_order_id_pk PRIMARY KEY,
order_category VARCHAR(4) NOT NULL,
order_type VARCHAR(6) NOT NULL,
order_time DATETIME,
quantity NUMERIC(15) NOT NULL,
price NUMERIC(15) not null,
user_id_order NUMERIC(4) NOT NULL,
order_status VARCHAR(12) NOT NULL,
aon VARCHAR(3) NOT NULL,
remaining_quantity NUMERIC(10) NOT NULL
)

CREATE TABLE TRADE_DETAILS(
trade_id Numeric(4) IDENTITY(2001,1) NOT NULL CONSTRAINT TRADE_DETAILS_trade_id_pk PRIMARY KEY,
order_id_buy NUMERIC(4) NOT NULL,
order_id_sell NUMERIC(4) NOT NULL,
user_id_buy NUMERIC(4) NOT NUll,
user_id_sell NUMERIC(4) NOT NULL,
traded_price NUMERIC(15) NOT NULL,
traded_quantity NUMERIC(15) NOT NULL,
traded_time	DATETIME NOT NULL
)


SELECT * FROM ORDER_DETAILS
SELECT * FROM TRADE_DETAILS
SELECT * FROM USER_DETAILS


insert into USER_DETAILS values ('chirag','chiragtnak','abc',70219,GETDATE())
insert into ORDER_DETAILS values('buy','limit',getdate(),12,12,100, 'pending',1, 10)
insert into TRADE_DETAILS values(11,12,123,1234,getdate());

SP_HELP 'TRADE_DETAILS'
SP_HELP 'ORDER_DETAILS'
SP_HELP 'USER_DETAILS'


