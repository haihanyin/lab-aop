package p.hh.topics.tryaspectjbin;

public aspect LoggingAspect {
    before(): execution(* org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(..)) {
        System.out.println("Before RandomStringUtils.randomAlphabetic is executed");
    }
}