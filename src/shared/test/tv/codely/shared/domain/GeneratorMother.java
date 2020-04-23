package tv.codely.shared.domain;

import com.github.javafaker.Faker;

public class GeneratorMother {
    public static final Faker FAKER = new Faker();

    public static Faker generator() {
        return FAKER;
    }
}