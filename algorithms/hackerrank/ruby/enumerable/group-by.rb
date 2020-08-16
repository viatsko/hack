def group_by_marks(marks, n)
  return marks.group_by do |name, mark|
    if mark < n
      "Failed"
    else
      "Passed"
    end
  end
end
