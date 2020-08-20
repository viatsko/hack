def func_any(hash)
  # Check and return true if any key object within the hash is of the type Integer
  # If not found, return false.
  hash.any? {|key, value| key.is_a? Integer}
end

def func_all(hash)
  # Check and return true if all the values within the hash are Integers and are < 10
  # If not all values satisfy this, return false.
  hash.all? {|key, value| value.is_a? Integer and value < 10}
end

def func_none(hash)
  # Check and return true if none of the values within the hash are nil
  # If any value contains nil, return false.
  hash.none? {|key, value| value.nil?}
end

def func_find(hash)
  # Check and return the first object that satisfies either of the following properties:
  #   1. There is a [key, value] pair where the key and value are both Integers and the value is < 20 
  #   2. There is a [key, value] pair where the key and value are both Strings and the value starts with `a`.
  hash.find {|key, value| (key.is_a? Integer and value.is_a? Integer and value < 20) || (key.is_a? String and value.is_a? String and value.start_with? 'a')}
end