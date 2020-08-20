from .__main__ import check_permutation


def test_1():
    assert check_permutation('test', 'estt') == True


def test_2():
    assert check_permutation('apple pie', 'applie pii') == False
