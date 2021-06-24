package p.hh.topics.tryagent;

public class AgentDemo {
    public static void main(String[] args) {
        final MyUtil myUtil = new MyUtil();
        try {
            myUtil.concatString("Hello", "World");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            myUtil.concatString("Hello", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            myUtil.concatString("Hello", "World", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            myUtil.concatString(null, "Hello", "World");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
