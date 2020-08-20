
SELECT MIN(ABS(x1.x - x2.x)) AS shortest FROM point x1, point x2 WHERE x1.x != x2.x;
