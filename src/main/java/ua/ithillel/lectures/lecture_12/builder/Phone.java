package ua.ithillel.lectures.lecture_12.builder;

public class Phone {
    //    required fields
    private String model;
    private String manufacture;
    //    optional fields
    private boolean isUsed;
    private int storage;
    private int pixels;
    private int year;

    public Phone(PhoneBuilder phoneBuilder){
        this.model = phoneBuilder.model;
        this.manufacture = phoneBuilder.manufacture;
        this.isUsed = phoneBuilder.isUsed;
        this.pixels = phoneBuilder.pixels;
        this.storage = phoneBuilder.storage;
        this.year= phoneBuilder.year;
    }


    //   Builder class
    public static class PhoneBuilder {
        //    required fields
        private String model;
        private String manufacture;
        //    optional fields
        private boolean isUsed;
        private int storage;
        private int pixels;
        private int year;

        public PhoneBuilder(String model, String manufacture) {
            this.model = model;
            this.manufacture = manufacture;
        }

        public PhoneBuilder isUsed(boolean isUsed) {
            this.isUsed = isUsed;
            return this;
        }
        public PhoneBuilder storage(int storage){
            this.storage = storage;
            return this;
        }
        public PhoneBuilder pixels(int pixels){
            this.pixels = pixels;
            return this;
        }
        public PhoneBuilder year(int year){
            this.year = year;
            return this;
        }

        public Phone build(){
            Phone phone = new Phone(this);
            return phone;
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", isUsed=" + isUsed +
                ", storage=" + storage +
                ", pixels=" + pixels +
                ", year=" + year +
                '}';
    }
}
