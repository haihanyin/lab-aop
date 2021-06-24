package p.hh.topics.tryaspectj;

public aspect LoggingAspect {
    before(): set(* NamedService.*) {
        System.out.println("Before set");
    }

    before(): get(* NamedService.*) {
        System.out.println("Before get");
    }
}