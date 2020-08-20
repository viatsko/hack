from .__main__ import is_string_rotation


def test_1():
    assert is_string_rotation('apple', 'pleap') == True


def test_2():
    assert is_string_rotation('waterbottle', 'erbottlewat') == True


def test_3():
    assert is_string_rotation('camera', 'macera') == False
