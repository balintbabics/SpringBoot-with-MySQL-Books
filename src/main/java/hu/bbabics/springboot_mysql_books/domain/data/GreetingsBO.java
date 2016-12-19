package hu.bbabics.springboot_mysql_books.domain.data;

public class GreetingsBO {

    private String greeting;
    private String name;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
