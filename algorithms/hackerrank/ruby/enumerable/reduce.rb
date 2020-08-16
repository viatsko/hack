def sum_terms(n)
  (1..n).reduce(0) do |x, i|
    x + i ** 2 + 1
  end
end
