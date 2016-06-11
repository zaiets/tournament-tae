package models.definitions;

/**
 * Created by Levsha on 15.02.2016.
 */
public enum AgeCategoryTODO {

    //TODO разобрать на классы и методы

    GIRLS_7_TO_8(new int[]{-22, -25, -28, -31, -34, -37, 37}, 7, 8, Sex.FEMALE, "девочки 7...8"),
    GIRLS_9_TO_10(new int[]{-26, -30, -34, -38, -42, -46, 46}, 9, 10, Sex.FEMALE, "девочки 9...10"),
    GIRLS_11_TO_13(new int[]{-30, -35, -40, -45, -50, -55, 55}, 11, 13, Sex.FEMALE, "девочки 11...13"),
    GIRLS_14_TO_15(new int[]{-40, -46, -52, -58, -64, -70, 70}, 14, 15, Sex.FEMALE, "девочки 14...15"),
    GIRLS_16_TO_17(new int[]{-40, -46, -52, -58, -64, -70, 70}, 16, 17, Sex.FEMALE, "девочки 16...17"),
    BOYS_7_TO_8(new int[]{-22, -25, -28, -31, -34, -37, 37}, 7, 8, Sex.MALE, "мальчики 7...8"),
    BOYS_9_TO_10(new int[]{-26, -30, -34, -38, -42, -46, 46}, 9, 10, Sex.MALE, "мальчики 9...10"),
    BOYS_11_TO_13(new int[]{-35, -40, -45, -50, -55, -60, 60}, 11, 13, Sex.MALE, "мальчики 11...13"),
    BOYS_14_TO_15(new int[]{-45, -51, -57, -63, -69, -75, 75}, 14, 15, Sex.MALE, "мальчики 14...15"),
    BOYS_16_TO_17(new int[]{-45, -51, -57, -63, -69, -75, 75}, 16, 17, Sex.MALE, "мальчики 16...17");

    private final int[] weightRangeDelimiter;
    private final int minAge;
    private final int maxAge;
    private Sex sex;
    private String name;

    AgeCategoryTODO(int[] weightRangeDelimiter, int minAge, int maxAge, Sex sex, String name) {
        this.weightRangeDelimiter = weightRangeDelimiter;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.sex = sex;
        this.name = name;
    }

    public static AgeCategoryTODO defineAgeCategory(int age, Sex sex) {
        AgeCategoryTODO ageCategory;
        /*
        int age = date.toLocalDate().until(LocalDate.parse(zzz.getProperties().getProperty("TournamentDate"), DateTimeFormatter.ISO_DATE)).getYears();
        в будущем можно использовать расчет исходя из даты соревнования
         */
        if (sex == Sex.FEMALE) {
            if (ageInRange(GIRLS_7_TO_8, age)) {
                ageCategory = GIRLS_7_TO_8;}
            else if (ageInRange(GIRLS_9_TO_10, age)) {
                ageCategory = GIRLS_9_TO_10;}
            else if (ageInRange(GIRLS_11_TO_13, age)) {
                ageCategory = GIRLS_11_TO_13;}
            else if (ageInRange(GIRLS_14_TO_15, age)) {
                ageCategory = GIRLS_14_TO_15;}
            else if (ageInRange(GIRLS_16_TO_17, age)) {
                ageCategory = GIRLS_16_TO_17;}
            else throw new Error("Age category is out of range");
        } else {
            if (ageInRange(BOYS_7_TO_8, age)) {
                ageCategory = BOYS_7_TO_8;}
            else if (ageInRange(BOYS_9_TO_10, age)) {
                ageCategory = BOYS_9_TO_10;}
            else if (ageInRange(BOYS_11_TO_13, age)) {
                ageCategory = BOYS_11_TO_13;}
            else if (ageInRange(BOYS_14_TO_15, age)) {
                ageCategory = BOYS_14_TO_15;}
            else if (ageInRange(BOYS_16_TO_17, age)) {
                ageCategory = BOYS_16_TO_17;}
            else throw new Error("Age category is out of range");
        }
        return ageCategory;
    }

    public static int defineWeightGroup (int weight, AgeCategoryTODO category) {
        if (weight < category.weightRangeDelimiter[0]) {
            return category.weightRangeDelimiter[0];
        }
        for (int i = 1; i < 6; i ++) {
            if (weight < Math.abs(category.weightRangeDelimiter[i]) && weight > Math.abs(category.weightRangeDelimiter[i-1])) {
                return category.weightRangeDelimiter[i];
            }
        }
        return category.weightRangeDelimiter[6];
    }


    public static boolean ageInRange (AgeCategoryTODO ageCategory, int i) {
        return (i >= ageCategory.minAge && i <= ageCategory.maxAge);
    }

    public int[] getWeightRangeDelimiter() {
        return weightRangeDelimiter.clone();
    }

    public Sex getSex() {
        return sex;
    }

    public String getName(){
        return name;
    }

    //TODO переписать в виде таблицы в БД и методов её обработки
}
