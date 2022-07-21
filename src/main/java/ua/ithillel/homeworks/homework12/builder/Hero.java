package ua.ithillel.homeworks.homework12.builder;

public class Hero {
    private  String name;
    private  int level;
    private  Profession profession;
    private final Weapon weapon;
    private final Armor armor;
    private final HairColor hairColor;

    public Hero(HeroBuilder heroBuilder) {
        this.name = heroBuilder.name;
        this.level = heroBuilder.level;
        this.profession = heroBuilder.profession;
        this.weapon = heroBuilder.weapon;
        this.armor = heroBuilder.armor;
        this.hairColor = heroBuilder.hairColor;
    }

    public static class HeroBuilder {
        private final String name;
        private final int level;
        private Profession profession;
        private Weapon weapon;
        private Armor armor;
        private HairColor hairColor;

        public HeroBuilder(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public HeroBuilder profession(Profession profession) {
            this.profession = profession;
            return this;
        }

        public HeroBuilder weapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public HeroBuilder armor(Armor armor) {
            this.armor = armor;
            return this;
        }

        public HeroBuilder hairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Hero build() {
            Hero hero = new Hero(this);
            return hero;
        }
    }

    @Override
    public String toString() {
        return "Hero " + name + ", level : " + level +
                ", profession - " + profession +
                ", weapon - " + weapon +
                ", armor - " + armor +
                ", hair color - " + hairColor;
    }
}
