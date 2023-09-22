-- 코드를 입력하세요
SELECT DISTINCT(C.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR C
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON C.CAR_ID=H.CAR_ID
WHERE C.CAR_TYPE='세단' AND
DATE_FORMAT(H.start_date, '%m') = '10'
ORDER BY C.CAR_ID DESC;