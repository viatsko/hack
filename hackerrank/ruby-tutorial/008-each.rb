def scoring(array)
  array.each {|user| user.update_score()}
end