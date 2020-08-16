int lineUp(std::string commands) {
  int result = 0;

  bool right = true;

  for (std::string::size_type i = 0; i < commands.size(); i++) {
    if (commands[i] == 'L' || commands[i] == 'R') {
      right = !right;
    }

    if (right) {
      result++;
    }
  }

  return result;
}
