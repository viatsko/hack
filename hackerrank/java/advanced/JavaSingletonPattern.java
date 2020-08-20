/* Nested to be able to have multiple classes in one project */
/* Just for convenience within this particular repo */
public class JavaSingletonPattern {
    static class Singleton{
        public String str;

        private static Singleton instance = new Singleton();

        private Singleton() {

        }

        public static Singleton getSingleInstance() {
            return instance;
        }
    }
}
