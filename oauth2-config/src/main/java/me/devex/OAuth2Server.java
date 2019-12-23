package me.devex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "me.devex.config")
public class OAuth2Server {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Server.class, args);
       /* Dracula dracula=new Alucard();
        System.out.println( dracula.name+" "+dracula.getName());
        System.out.println(dracula.metamorphsis());
        */
    }

    static class Dracula {
        String name = "Dracula";

       public static String metamorphsis() {
            return "wae";
        }

        public String getName() {
            return name;
        }
    }

    static class Alucard extends Dracula {
        String name = "Alucard";

        public  static String metamorphsis() {
            return "pat";
        }

        public String getName() {
            return name;
        }
    }
}

