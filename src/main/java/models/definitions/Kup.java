package models.definitions;

import org.springframework.stereotype.Component;

@Component
public enum Kup {
    KUP_10(1, "10 куп"),
    KUP_9(2, "9 куп"),
    KUP_8(3, "8 куп"),
    KUP_7(4, "7 куп"),
    KUP_6(5, "6 куп"),
    KUP_5(6, "5 куп"),
    KUP_4(7, "4 куп"),
    KUP_3(8, "3 куп"),
    KUP_2(9, "2 куп"),
    KUP_1(10, "1 куп"),
    DAN_1(11, "1 дан"),
    DAN_2(12, "2 дан"),
    DAN_3(13, "3 дан"),
    DAN_4(14, "4 дан");

    private int rating;
    private String name;

    Kup(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public static Kup defineKup(String name) {
        for (Kup k : Kup.values()) {
            if (k.getName().equals(name)) return k;
        }
        return null;
    }

}
