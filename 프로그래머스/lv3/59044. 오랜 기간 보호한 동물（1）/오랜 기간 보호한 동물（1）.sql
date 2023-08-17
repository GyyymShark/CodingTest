SELECT
    INS.NAME, 
    INS.DATETIME
FROM 
    ANIMAL_INS INS
LEFT JOIN
    ANIMAL_OUTS OUTS USING (ANIMAL_ID)
WHERE 
    OUTS.DATETIME IS NULL
ORDER BY
    INS.DATETIME
LIMIT 3;