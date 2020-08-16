bool tennisSet(int score1, int score2) {
  return (
    (score1 >= 5 && score1 < 7 && score2 == 7) ||
    (score2 >= 5 && score2 < 7 && score1 == 7) ||
    (score1 == 6 && score2 < 5) ||
    (score2 == 6 && score1 < 5)
  );
}
