SELECT ROUND(SQRT(MIN((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y))), 2) AS shortest
FROM point_2d p1 JOIN point_2d p2 ON p1.x != p2.x OR p1.y != p2.y
