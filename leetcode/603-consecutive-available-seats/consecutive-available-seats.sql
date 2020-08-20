SELECT mid.seat_id FROM cinema mid
LEFT JOIN cinema left_seat ON mid.seat_id - left_seat.seat_id = 1
LEFT JOIN cinema right_seat ON right_seat.seat_id - mid.seat_id = 1
WHERE mid.free = 1 AND (left_seat.free = 1 OR right_seat.free = 1)
ORDER BY mid.seat_id
