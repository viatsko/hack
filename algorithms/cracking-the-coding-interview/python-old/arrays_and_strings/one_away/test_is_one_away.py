from .__main__ import is_one_away


def test_1():
    assert is_one_away('pale', 'ple') == True


def test_2():
    assert is_one_away('pales', 'pale') == True


def test_3():
    assert is_one_away('pale', 'bale') == True


def test_4():
    assert is_one_away('pale', 'bake') == False
