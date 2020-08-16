def prime?(n)
  if n == 1
    return false
  end

  is_prime = true

  (2..n-1).each { |i|
    if n % i == 0
      is_prime = false
    end
  }

  is_prime
end