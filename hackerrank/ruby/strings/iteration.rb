def count_multibyte_char(n)
  cnt = 0

  n.each_char{|x| cnt += 1 if x.bytesize > 1}

  cnt
end