CREATE TABLE USER_INFO
(
    USER_ID INTEGER NOT NULL,
    GENDER  TINYINT(1),
    AGE     INTEGER,
    JOINED  DATE    NOT NULL,
    PRIMARY KEY (USER_ID)
);

SELECT COUNT(*) AS MEMBER_COUNT
FROM USER_INFO
WHERE JOINED BETWEEN '2021-01-01' AND '2021-12-31'
  AND AGE BETWEEN 20 AND 29;
