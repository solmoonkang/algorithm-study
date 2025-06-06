CREATE TABLE FISH_INFO
(
    ID        INTEGER NOT NULL,
    FISH_TYPE INTEGER NOT NULL,
    LENGTH    FLOAT,
    TIME      DATE    NOT NULL,
    PRIMARY KEY (ID)
);

SELECT ID, LENGTH
FROM FISH_INFO
ORDER BY LENGTH DESC, ID ASC LIMIT 10;
