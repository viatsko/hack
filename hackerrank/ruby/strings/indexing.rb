def serial_average(str)
  s = str[0, 3]
  x = str[4, 5].to_f
  y = str[10, 5].to_f

  [s, ((x + y) / 2).round(2).to_s].join('-')
end