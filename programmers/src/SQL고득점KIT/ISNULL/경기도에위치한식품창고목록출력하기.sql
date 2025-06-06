CREATE TABLE FOOD_WAREHOUSE
(
    WAREHOUSE_ID   VARCHAR(10) NOT NULL,
    WAREHOUSE_NAME VARCHAR(20) NOT NULL,
    ADDRESS        VARCHAR(100),
    TLNO           VARCHAR(20),
    FREEZER_YN     VARCHAR(1),
    PRIMARY KEY (WAREHOUSE_ID)
);

SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, COALESCE(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID ASC;
