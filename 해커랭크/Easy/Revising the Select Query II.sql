SELECT  ID, NAME, COUNTRYCODE, DISTRICT, POPULATION
FROM CITY
WHERE 1=1
AND POPULATION > 100000
AND COUNTRYCODE = 'USA';
