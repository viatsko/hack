combination = ->(n) do
  n_fact = (1..n).inject(:*) || 1
  ->(r) do
    r_fact = (1..r).inject(:*) || 1
    n_fact / (r_fact * ((1..(n - r)).inject(:*) || 1))
  end
end

n = gets.to_i
r = gets.to_i
nCr = combination.(n)
puts nCr.(r)
