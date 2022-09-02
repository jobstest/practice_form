package docs;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerExamples {

    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println(faker.aquaTeenHungerForce().character());
        System.out.println(faker.backToTheFuture().date());
        System.out.println(faker.lebowski().actor());

        Faker fakerDe = new Faker(new Locale("de"));
        System.out.println(fakerDe.address().fullAddress());
    }
}
