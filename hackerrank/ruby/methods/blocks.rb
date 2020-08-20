def factorial
  puts (1..yield).inject(:*)
end

n = gets.to_i
factorial do
  n
end
