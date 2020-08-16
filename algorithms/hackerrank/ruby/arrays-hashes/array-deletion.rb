def end_arr_delete(arr)
  # delete the element from the end of the array and return the deleted element
  return arr.pop()
end

def start_arr_delete(arr)
  # delete the element at the beginning of the array and return the deleted element

  return arr.shift()
end

def delete_at_arr(arr, index)
  # delete the element at the position #index

  return arr.delete_at(index)
end

def delete_all(arr, val)
  # delete all the elements of the array where element = val
  return arr.delete(val)
end
