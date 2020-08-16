import java.util.*;

public class JavaPriorityQueue {
    static class Priorities {
        public List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> queue = new PriorityQueue<>(
                    Comparator.comparing(Student::getCgpa).reversed()
                            .thenComparing(Student::getName)
                            .thenComparing(Student::getId)
            );

            for (String event : events) {
                String[] parts = event.split(" ");
                if (parts.length == 1) {
                    queue.poll();
                } else {
                    queue.add(new Student(Integer.valueOf(parts[3]), parts[1], Double.valueOf(parts[2])));
                }
            }

            List<Student> result = new ArrayList<>();

            while (!queue.isEmpty()) {
                result.add(queue.poll());
            }

            return result;
        }
    }

    static class Student {
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            super();
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }
    }

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
