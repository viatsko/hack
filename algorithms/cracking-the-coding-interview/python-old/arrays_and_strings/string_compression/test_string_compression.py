from .__main__ import compress


def test_1():
    assert compress("aaaaabbbbaaaabbddc") == "a5b4a4b2d2c1"


def test_2():
    assert compress("vhwbkwhfhhhfksbvmbvbbbaaaaaaaaaxx") == "vhwbkwhfhhhfksbvmbvbbbaaaaaaaaaxx"
