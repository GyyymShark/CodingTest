-- 코드를 입력하세요
SELECT B.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK AS B, BOOK_SALES AS BS
WHERE B.BOOK_ID=BS.BOOK_ID AND
DATE_FORMAT(BS.SALES_DATE, '%Y-%m')='2022-01'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY;