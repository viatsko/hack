from .__main__ import check_palindrome_permutation


def test_1():
    assert check_palindrome_permutation('Tact Coa') == True


def test_2():
    assert check_palindrome_permutation('jhsabckuj ahjsbckj') == True


def test_3():
    assert check_palindrome_permutation('Able was I ere I saw Elba') == True


def test_4():
    assert check_palindrome_permutation('So patient a nurse to nurse a patient so') == False


def test_5():
    assert check_palindrome_permutation('Random Words') == False


def test_6():
    assert check_palindrome_permutation('Not a Palindrome') == False
