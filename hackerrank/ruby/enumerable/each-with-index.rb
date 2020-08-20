def skip_animals(animals, skip)
  arr = []
  animals.each_with_index { |item, index|
    if index >= skip
      arr.push("#{index}:#{item}")
    end
  }
  return arr
end
