SELECT B.CITY, B.city_length
FROM
(
SELECT ROW_NUMBER() OVER (ORDER BY city_length, CITY) AS RNUM,
    A.*
FROM 
    (SELECT CITY, LENGTH(CITY) AS city_length 
     FROM STATION 
    ) A
) B
WHERE B.RNUM=1;

SELECT B.CITY, B.city_length 
FROM 
(
SELECT ROW_NUMBER() OVER (ORDER BY city_length DESC, CITY) AS RNUM,
    A.*
FROM 
    (SELECT CITY, LENGTH(CITY) AS city_length 
     FROM STATION 
    ) A
) B
WHERE B.RNUM=1;
