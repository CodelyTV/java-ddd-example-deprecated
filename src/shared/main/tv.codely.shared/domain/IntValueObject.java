package tv.codely.shared.domain;

import java.util.Objects;

abstract public class IntValueObject {
    private final Integer value;

    public IntValueObject(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntValueObject)) return false;
        IntValueObject that = (IntValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
