def convert_temp(v, input_scale: '', output_scale: '')
  if input_scale == 'celsius' and output_scale == 'fahrenheit'
    k = 9.0 * v / 5 + 32.0
  elsif input_scale == 'celsius' and output_scale == 'kelvin'
    k = v + 273.15
  elsif input_scale == 'kelvin' and output_scale == 'fahrenheit'
    k = 9.0 * (v - 273.15) / 5.0 + 32.0
  elsif input_scale == 'kelvin' and output_scale == 'celsius'
    k = v - 273.15
  elsif input_scale == 'fahrenheit' and output_scale == 'celsius'
    k = 5.0 * (v - 32) / 9.0
  elsif input_scale == 'fahrenheit' and output_scale == 'kelvin'
    k = 5.0 * (v - 32) / 9.0 + 273.15
  else
    k = v
  end

  k
end