package p.hh.topics.tryaspectjload;

public class Main {
    public static void main(String[] args) {
        final NamedService namedService = new NamedService();
        namedService.setName("UserService");
        namedService.getName();
        System.out.println("Done");
    }
}
