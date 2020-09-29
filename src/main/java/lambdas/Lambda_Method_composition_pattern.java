package lambdas;

import java.util.function.Consumer;


class Mailer {
    public Mailer from(String addr) { System.out.println("from " + addr); return this; }
    public Mailer to(String addr) { System.out.println("to " + addr); return this; }
    public Mailer subject(String subjectLine) { System.out.println("subject " + subjectLine); return this; }
    public Mailer body(String message) { System.out.println("body " + message); return this; }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending...");
    }
}

public class Lambda_Method_composition_pattern {
    public static void main(String[] args) {
        Mailer.send(mailer -> {
            mailer.from("builder@agiledeveloper.com")
                    .to("venkats@agiledeveloper.com")
                    .subject("Your code sucks")
                    .body("...");
        });
    }
}