// Solution 3: Gaming Application
// Pattern: Flyweight

import java.util.HashMap;

// Flyweight
class GameObject {
    private String type;
    private String texture;
    private String color;

    GameObject(String type, String texture, String color) {
        this.type    = type;
        this.texture = texture;
        this.color   = color;
    }

    void display(int x, int y) {
        System.out.println(type + " displayed at (" + x + "," + y + ")");
    }
}

// Flyweight Factory
class GameObjectFactory {
    private static HashMap<String, GameObject> objects = new HashMap<>();

    static GameObject getObject(String type) {
        if (!objects.containsKey(type)) {
            objects.put(type, new GameObject(type, "DefaultTexture", "Green"));
        }
        return objects.get(type);
    }
}

// Client
public class FlyweightGameDemo {
    public static void main(String[] args) {
        GameObject tree1 = GameObjectFactory.getObject("Tree");
        tree1.display(10, 20);

        GameObject tree2 = GameObjectFactory.getObject("Tree");
        tree2.display(30, 40); // reused object

        GameObject rock = GameObjectFactory.getObject("Rock");
        rock.display(50, 60);
    }
}
