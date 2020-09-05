def short(f):
    def wrapper(*args):
        print '{} {} {}'.format('Ms.' if args[0].gender == 'F' else 'Mr.', args[0].first_name, args[0].last_name)
        return f(*args)

    return wrapper


class Person:
    def __init__(self, first_name, last_name, age, gender):
        self.first_name = first_name
        self.last_name = last_name
        self.age = int(age)
        self.gender = gender

    @short
    def print_short_info(self):
        return 'name'


persons = list()

N = int(raw_input())

for i in range(0, N):
    person_data = raw_input().strip().split(' ')
    person = Person(person_data[0], person_data[1], person_data[2], person_data[3])
    persons.append(person)

persons.sort(key=lambda x: x.age)

for person in persons:
    person.print_short_info()
