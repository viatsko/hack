def square_of_sum (my_array, proc_square, proc_sum)
  sum = proc_sum.call(my_array)
  proc_square.call(sum)
end

proc_square_number = proc {|x| x ** 2}
proc_sum_array     = proc {|array| array.inject(0){|sum,x| sum + x }}
my_array = gets.split.map(&:to_i)

puts square_of_sum(my_array, proc_square_number, proc_sum_array)
