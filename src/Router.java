import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routery v sidi ridici komunikaci.
 */
public class Router implements Comparable<Router> {

    /**Data ulozena v routeru*/
    private short data = 0;
    /**Router pracuje*/
    private boolean up = true;
    /**ID routeru*/
    private final Integer id;
    /**Pamet routeru - maximalni mnozstvi dat, ktere dokaze uchovavat*/
    private static final short MEMORY = 100;
    /** List hran vedoucích z routeru*/
    private List<Link> paths;
    /** Maximální propustnost hrany*/
    private double minDistance = Double.POSITIVE_INFINITY;
    /** Nazev routeru*/
    private final String name;
    /** predchuzce bodu*/
    private Router previous;

    public Router(int id) {
        this.id = id;
        this.name = "Router" + id;
        paths = new ArrayList<>();
        previous = null;

    }

    public void addPath(Link path) {
        this.paths.add(path);
    }

    public void setPaths(List<Link> links) {
        this.paths = links;
    }

    public List<Link> getPaths() {
        return paths;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setData(Link link, Data data) {

    }

    public void setPrevious(Router previous) {
        this.previous = previous;
    }

    public Router getPrevious() {

        return previous;
    }

    public boolean isUp() {
        return up;
    }

    public String getName() {
        return name;
    }

    public short getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }

    public static byte getMEMORY() {
        return MEMORY;
    }

    public int compareTo(Router other) {
        return Double.compare(minDistance, other.getMinDistance());
    }

    @Override
    public String toString() {
        return "Router{" +
                "id = " + id +
                ", name = " + name +
                ", data = " + data +
                '}';
    }
}
