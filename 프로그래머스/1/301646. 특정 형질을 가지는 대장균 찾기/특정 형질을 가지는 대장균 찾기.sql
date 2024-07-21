-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE 
    (GENOTYPE & 2) = 0  -- 2번 형질을 보유하지 않는 경우
    AND 
    (
        (GENOTYPE & 1) != 0  -- 1번 형질을 보유하는 경우
        OR 
        (GENOTYPE & 4) != 0  -- 3번 형질을 보유하는 경우
                             -- (GENOTYPE & 4) != 0  -- 3번 형질을 보유하는 경우
    );
