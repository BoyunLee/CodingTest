-- 코드를 작성해주세요
SELECT SUM(gr.SCORE) as SCORE, gr.EMP_NO, em.EMP_NAME, em.POSITION, em.EMAIL
FROM HR_GRADE as gr
JOIN HR_EMPLOYEES as em
ON gr.EMP_NO = em.EMP_NO
GROUP BY gr.EMP_NO, em.EMP_NAME, em.POSITION, em.EMAIL
HAVING SUM(gr.SCORE) = (
    SELECT MAX(total_score)
    FROM (
        SELECT SUM(SCORE) AS total_score
        FROM HR_GRADE
        GROUP BY EMP_NO
    ) t
);
