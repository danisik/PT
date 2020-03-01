import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

/**
 * Spojeni mezi jednotlivymi routery.
 */
public class Link {
    /**Mnozstvi dat, ktere protekly tuto sekundu jednim smerem*/
    private short data1to2;
    /**Mnozstvi dat, ktere protekly tuto sekundu druhym smerem*/
    private short data2to1;

    /** Prvni router*/
    private Router r1;
    /** Druhy router*/
    private Router r2;
    /**Maximalni propustnost*/
    private final float throughtput;
    /**Spolehlivost spojeni - procento z maximalni propustnosti dat, ktere se odesle bezeztraty*/
    private final float reliability;
    /**Maximalni bezeztratova propustnost*/
    private final int maxThroughtput;

    /**
     * Spojeni mezi jednotlivymi routery
     *
     * @param maxThroughtput maximalni propustnost dat
     * @param reliability procento z max. propustnosti dat, ktere se odesle bezeztraty
     * @param r1 router 1
     * @param r2 router 2
     */
    public Link(float maxThroughtput, float reliability, Router r1, Router r2) {
        this.throughtput = maxThroughtput;
        this.reliability = reliability;
        this.r1 = r1;
        this.r2 = r2;
        r1.addPath(this);
        r2.addPath(this);

        this.maxThroughtput = (int)(throughtput * this.reliability);
    }

    public Router getNeighbour(Router x) {
        if(x == r1) {
            return r2;
        }
        else if(x == r2) {
            return r1;
        }
        return null;
    }

    public void sendDataDir1(short data, Router r) {

    }

    public short getData1to2() {
        return data1to2;
    }

    public void setData1to2(short data1to2) {
        this.data1to2 = data1to2;
    }

    public short getData2to1() {
        return data2to1;
    }

    public void setData2to1(short data2to1) {
        this.data2to1 = data2to1;
    }

    public float getThroughtput() {
        return throughtput;
    }

    public float getReliability() {
        return reliability;
    }

    public int getMaxThroughtput() {
        return maxThroughtput;
    }

    public Router getR1() {
        return r1;
    }

    public Router getR2() {
        return r2;
    }

    @Override
    public String toString() {
        return "Link {" +
                this.r1.getId() + " ~ " + this.r2.getId() +
                        ", throughtput = " + this.getMaxThroughtput()
                + "}";
    }

}
