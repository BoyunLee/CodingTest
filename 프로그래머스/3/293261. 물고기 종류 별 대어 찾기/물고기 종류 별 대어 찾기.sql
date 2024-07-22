-- 코드를 작성해주세요
SELECT F.ID, N.FISH_NAME, F.LENGTH 
FROM FISH_INFO F
JOIN FISH_NAME_INFO N ON F.FISH_TYPE = N.FISH_TYPE
WHERE F.LENGTH IN (SELECT MAX(LENGTH)
                FROM FISH_INFO
                WHERE FISH_TYPE = F.FISH_TYPE)
ORDER BY F.ID ASC;
