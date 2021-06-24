package p.hh.topics.tryaspectj;

public class Main {
    public static void main(String[] args) {
        final NamedService namedService = new NamedService();
        namedService.setName("UserService");
        namedService.getName();
    }
}
