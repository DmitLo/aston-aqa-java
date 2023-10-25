import java.util.Arrays;

/**
 * Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
 * времени их работы и стоимости.
 */
public class Park {
    private Attraction[] attractions;

    public static class Attraction {
        private String name;
        private String operatingTime;
        private double cost;

        public Attraction(String name, String operatingTime, double cost) {
            this.name = name;
            this.operatingTime = operatingTime;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOperatingTime() {
            return operatingTime;
        }

        public void setOperatingTime(String operatingTime) {
            this.operatingTime = operatingTime;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", operatingTime='" + operatingTime + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }

    public Park() {
        attractions = new Attraction[5];
        attractions[0] = new Attraction("Roller Coaster", "10:00 AM - 8:00 PM", 10.0);
        attractions[1] = new Attraction("Ferris Wheel", "11:00 AM - 9:00 PM", 5.0);
        attractions[2] = new Attraction("Carousel", "9:00 AM - 7:00 PM", 3.0);
        attractions[3] = new Attraction("Bumper Cars", "12:00 PM - 10:00 PM", 7.0);
        attractions[4] = new Attraction("Haunted House", "6:00 PM - 12:00 AM", 12.0);
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Park{" +
                "attractions=" + Arrays.toString(attractions) +
                '}';
    }
}
