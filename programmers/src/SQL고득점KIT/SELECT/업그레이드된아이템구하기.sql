CREATE TABLE ITEM_INFO
(
    ITEM_ID   INTEGER NOT NULL,
    ITEM_NAME VARCHAR NOT NULL,
    RARITY    INTEGER NOT NULL,
    PRICE     INTEGER NOT NULL,
    PRIMARY KEY (ITEM_ID)
);

CREATE TABLE ITEM_TREE
(
    ITEM_ID        INTEGER NOT NULL,
    PARENT_ITEM_ID INTEGER,
    PRIMARY KEY (ITEM_ID),
    FOREIGN KEY (ITEM_ID) REFERENCES ITEM_INFO (ITEM_ID),
    FOREIGN KEY (PARENT_ITEM_ID) REFERENCES ITEM_INFO (ITEM_ID)
);

-- 아이템의 희귀도가 'RARE'인
-- 아이템들의 모든 다음 업그레이드 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요.
-- 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.

SELECT II.ITEM_ID, II.ITEM_NAME, II.RARITY
FROM ITEM_INFO II
         JOIN ITEM_TREE IT ON II.ITEM_ID = IT.ITEM_ID
WHERE IT.PARENT_ITEM_ID IN (SELECT ITEM_ID
                            FROM ITEM_INFO
                            WHERE RARITY = 'RARE')
ORDER BY II.ITEM_ID DESC;

