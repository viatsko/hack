from .__main__ import urlify


def test_1():
    assert urlify('much ado about nothing          ', 22) == 'much%20ado%20about%20nothing'


def test_2():
    assert urlify('Mr John Smith       ', 13) == 'Mr%20John%20Smith'
