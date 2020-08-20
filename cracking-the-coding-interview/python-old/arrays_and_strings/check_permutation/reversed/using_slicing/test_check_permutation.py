from .__main__ import check_permutation_reversed


def test_1():
    assert check_permutation_reversed('test', 'tset') == True


def test_2():
    assert check_permutation_reversed('test', 'test') == False
