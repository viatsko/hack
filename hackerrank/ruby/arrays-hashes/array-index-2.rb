def neg_pos(arr, index)
  # return the element of the array at the position `index` from the end of the list
  # Clue : arr[-index]
  return arr[-index]
end

def first_element(arr)
  # return the first element of the array
  # arr.first
  return arr.first
end

def last_element(arr)
  # return the last element of the array
  # arr.last
  return arr.last
end

def first_n(arr, n)
  # return the first n elements of the array
  return arr.first(n)
end

def drop_n(arr, n)
  # drop the first n elements of the array and return the rest
  return arr.drop(n)
end
