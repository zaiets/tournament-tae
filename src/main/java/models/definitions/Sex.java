package models.definitions;

/**
 * Created by Levsha on 15.02.2016.
 */
public enum Sex {
    MALE('ч'),
    FEMALE('ж');

    private Character value;

    Sex(Character sex) {
        value = sex;
    }

    public Character getValue() {
        return value;
    }

    public static Sex defineSex(Character s) {
        Sex sex;
        if (s == 'w' || s == 'ж' || s == 'W' || s == 'Ж') {
            sex = Sex.FEMALE;
        } else if (s == 'm' || s == 'ч' || s == 'M' || s == 'Ч') {
            sex = Sex.MALE;
        } else sex = null;
        return sex;
    }
}
