CREATE SCHEMA PUBLIC AUTHORIZATION DBA

CREATE MEMORY TABLE CUSTOMER(CUSTOMER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL 
PRIMARY KEY,CUSTOMER_FIRSTNAME VARCHAR(128),CUSTOMER_LASTNAME VARCHAR(128),CUSTOMER_EMAIL 
VARCHAR(128),CUSTOMER_PASSWORD VARCHAR(64))

CREATE MEMORY TABLE ADDRESS(ADDRESS_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL 
PRIMARY KEY,ADDRESS_ADDRESS1 VARCHAR(255),ADDRESS_ADDRESS2 VARCHAR(255),ADDRESS_CITY 
VARCHAR(255),ADDRESS_STATE VARCHAR(255),ADDRESS_ZIP VARCHAR(255),CUSTOMER_ID BIGINT NOT NULL,CONSTRAINT
 FKE66327D46DF50C34 FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID))

CREATE MEMORY TABLE CATEGORY(CATEGORY_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL 
PRIMARY KEY,CATEGORY_NAME VARCHAR(255))

CREATE MEMORY TABLE ORDER_ITEM(ORDER_ITEM_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL
 PRIMARY KEY,ORDER_ITEM_QUANTITY INTEGER,ORDER_ID BIGINT NOT NULL,PRODUCT_ID BIGINT NOT NULL)

CREATE MEMORY TABLE PRODUCT(PRODUCT_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL 
PRIMARY KEY,PRODUCT_NAME VARCHAR(255),PRODUCT_PRICE DOUBLE,PRODUCT_DESCRIPTION VARCHAR(255),
PRODUCT_INVENTORY INTEGER)

CREATE MEMORY TABLE PRODUCT_CATEGORIES(PRODUCT_ID BIGINT NOT NULL,CATEGORY_ID BIGINT NOT NULL,
PRIMARY KEY(PRODUCT_ID,CATEGORY_ID),CONSTRAINT FK5A93E78C121E7834 FOREIGN KEY(CATEGORY_ID) 
REFERENCES CATEGORY(CATEGORY_ID),CONSTRAINT FK5A93E78CF8BBB8E0 FOREIGN KEY(PRODUCT_ID) REFERENCES 
PRODUCT(PRODUCT_ID))

CREATE MEMORY TABLE ORDERS(ORDER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL 
PRIMARY KEY,ORDER_SUBTOTAL DOUBLE,ORDER_TAX DOUBLE,ORDER_TOTAL DOUBLE,CUSTOMER_ID BIGINT NOT NULL,
ADDRESS_ID BIGINT NOT NULL,CONSTRAINT FK8B7256E5AE379EC0 FOREIGN KEY(ADDRESS_ID) 
REFERENCES ADDRESS(ADDRESS_ID),CONSTRAINT FK8B7256E56DF50C34 FOREIGN KEY(CUSTOMER_ID) 
REFERENCES CUSTOMER(CUSTOMER_ID))

ALTER TABLE ORDER_ITEM ADD CONSTRAINT FK4BBDE984F8BBB8E0 FOREIGN KEY(PRODUCT_ID) 
REFERENCES PRODUCT(PRODUCT_ID)

ALTER TABLE ORDER_ITEM ADD CONSTRAINT FK4BBDE984715B5200 FOREIGN KEY(ORDER_ID) 
REFERENCES ORDERS(ORDER_ID)

ALTER TABLE CUSTOMER ALTER COLUMN CUSTOMER_ID RESTART WITH 16

ALTER TABLE ADDRESS ALTER COLUMN ADDRESS_ID RESTART WITH 1

ALTER TABLE CATEGORY ALTER COLUMN CATEGORY_ID RESTART WITH 6

ALTER TABLE ORDER_ITEM ALTER COLUMN ORDER_ITEM_ID RESTART WITH 1

ALTER TABLE PRODUCT ALTER COLUMN PRODUCT_ID RESTART WITH 7

ALTER TABLE ORDERS ALTER COLUMN ORDER_ID RESTART WITH 1

CREATE USER SA PASSWORD ""

GRANT DBA TO SA

SET WRITE_DELAY 10

SET SCHEMA PUBLIC