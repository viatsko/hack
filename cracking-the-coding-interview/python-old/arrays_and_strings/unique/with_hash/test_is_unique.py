from .__main__ import is_unique


def test_1():
    assert is_unique('test') == False


def test_2():
    assert is_unique('apple pie') == False


def test_3():
    assert is_unique('hacker') == True


def test_4():
    assert is_unique('genius') == True


def test_5():
    assert is_unique('lorem ipsum dolor sit amet') == False
