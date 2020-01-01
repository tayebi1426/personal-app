package me.dev;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc()
@SpringBootApplication(scanBasePackages = "me.dev")
public class PersonalAccountServer {

    public static void main(String[] args) {
        SpringApplication.run(PersonalAccountServer.class, args);
        //System.out.println(JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Nzc0MzU0MDcsInVzZXJfbmFtZSI6IkFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImIwYzdkMWJiLTRkZTgtNGE3YS04N2JjLWE1MWIyNTVkY2Y3ZSIsImNsaWVudF9pZCI6ImNsaWVudF9pZCIsInNjb3BlIjpbInVzZXJfaW5mbyJdfQ.R_hQKZwvi3Tv0aH5pc7MfG2rjNnHNJ9DnpKGQaiv1_8GwkQBmKL3qoxcdD3kUkw5CVbA_-EEDGZRl2SFeOjiWENvtnAz5rGMAlyB02JaeLtdyEnX4YSMdNodaTKabHOWB-stMOExiLGq2C7ZYxL3TYvC6yputvgcA5VBrnJmu5FEuGd9Cbj6Sxn6wHaam82TdmuH3PPm9bm1FbzjJmBFB9vHUYYwJY9MAPA0QSJ9FtWAsCRUbMa0JbpvjLeQB6UbiZZH0hI3JjlL7ErOhp9_TpyZFGGO9I6mOOTe2N4CxtKZrzSYjHUpcK0_K-jqh5yAXEE5iO45W3TGJKXk3sRkmw"));
    }

}

