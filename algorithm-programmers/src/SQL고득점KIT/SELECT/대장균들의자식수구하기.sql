CREATE TABLE ECOLI_DATA
(
    ID                   INTEGER NOT NULL,
    PARENT_ID            INTEGER,
    SIZE_OF_COLONY       INTEGER NOT NULL,
    DIFFERENTIATION_DATE DATE    NOT NULL,
    GENOTYPE             INTEGER NOT NULL,
    PRIMARY KEY (ID)
);

-- 대장균 개체 간의 부모-자식 관계를 나타내기 위해 사용된다.
-- LEFT JOIN으로 왼쪽 테이블(부모 개체)은 모두 포함하고, 오른쪽 테이블(자식 개체)에 해당하는 데이터가 없을 경우 NULL로 반환한다.
-- 이는 자식이 없는 부모도 결과에 포함되어 자식 개체 수가 0으로 나타나게 된다.

SELECT E.ID, COUNT(C.ID) AS CHILD_COUNT
FROM ECOLI_DATA E
         LEFT JOIN ECOLI_DATA C ON E.ID = C.PARENT_ID
GROUP BY E.ID
ORDER BY E.ID ASC;
