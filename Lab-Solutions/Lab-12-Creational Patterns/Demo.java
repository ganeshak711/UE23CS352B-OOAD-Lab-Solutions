// Solution 2: Travel Itinerary Generation System
// Pattern: Builder Pattern + Singleton Configuration Manager

class ConfigManager {
    private static ConfigManager instance;
    private ConfigManager() {}
    public static ConfigManager getInstance() {
        if (instance == null)
            instance = new ConfigManager();
        return instance;
    }
    public int getBudget() { return 5000; }
}

class Itinerary {
    String hotel;
    String transport;
    void show() {
        System.out.println("Hotel: " + hotel);
        System.out.println("Transport: " + transport);
    }
}

abstract class ItineraryBuilder {
    Itinerary i = new Itinerary();
    abstract void buildHotel();
    abstract void buildTransport();
    Itinerary getItinerary() { return i; }
}

class LuxuryItineraryBuilder extends ItineraryBuilder {
    void buildHotel()     { i.hotel     = "5 Star Hotel"; }
    void buildTransport() { i.transport = "Flight";       }
}

class BudgetItineraryBuilder extends ItineraryBuilder {
    void buildHotel()     { i.hotel     = "3 Star Hotel"; }
    void buildTransport() { i.transport = "Bus";          }
}

class TravelDirector {
    ItineraryBuilder builder;
    TravelDirector(ItineraryBuilder builder) { this.builder = builder; }
    Itinerary construct() {
        builder.buildHotel();
        builder.buildTransport();
        return builder.getItinerary();
    }
}

class Demo {
    public static void main(String[] args) {
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("Budget: " + config.getBudget());

        TravelDirector d1 = new TravelDirector(new LuxuryItineraryBuilder());
        d1.construct().show();

        System.out.println();

        TravelDirector d2 = new TravelDirector(new BudgetItineraryBuilder());
        d2.construct().show();
    }
}
