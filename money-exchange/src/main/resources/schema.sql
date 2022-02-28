DROP TABLE IF EXISTS DIVISA ;
CREATE TABLE DIVISA ( date_exchange DATETIME PRIMARY KEY, buy decimal NOT NULL, sell decimal, money_symbol VARCHAR(30));