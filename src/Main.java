import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    /**Mapa routeru*/
    public static Map<Integer, Router> router = new HashMap<>();
    /**Mapa spoju mezi routery*/
    private static List<Link> links = new ArrayList<>();
    /**List s daty pro simulaci*/
    private static List<SimulationData> simulationData = new ArrayList<>();
    /**Cesta k vstupnimu souboru s daty*/
    private static final String DATA_INPUT_FILE = "test_input.txt";
    /** Cesta k souboru se simulacnimy daty*/
    private static final String DATA_SIMULATION_FILE = "test_simulace.txt";
    private static final String DATA_SIMULATION_FILE2 = "test_simulace2.txt";
    /** ID poslednich dat*/
    private static Integer dataID;
    /** Pomocna promenna pro cyklus*/
    private static boolean run = false;

    public static void main(String[] args) {
        loadData();
        loadSimulationData();

        /*
        Iterator<SimulationData> it = simulationData.listIterator();
        while(run) {

        }
        */

        Dijkstra.computePath(router.get(3));
        List<Router> path = Dijkstra.getShortestPathTo(router.get(8));

        System.out.println(path);

        Dijkstra.computePath(router.get(0));
        path = Dijkstra.getShortestPathTo(router.get(7));

        System.out.println(path);



    }

    public static void loadData() {
        String sCurrentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_INPUT_FILE))) {
            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine = sCurrentLine.replace(" ", "");
                sCurrentLine = sCurrentLine.replace("\t", "");
                sCurrentLine = sCurrentLine.replace("-","-");
                String[] currLine = sCurrentLine.split("-");

                Integer r1 = Integer.parseInt(currLine[0]);
                Integer r2 = Integer.parseInt(currLine[1]);
                float maxThroughtput = Float.parseFloat(currLine[2]);
                float reliability = Float.parseFloat(currLine[3]);

                Router router1 = new Router(r1);
                Router router2 = new Router(r2);
                router.putIfAbsent(r1, router1);
                router.putIfAbsent(r2, router2);
                Link link = new Link(maxThroughtput, reliability, router.get(r1), router.get(r2));
                links.add(link);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSimulationData() {
        String sCurrentLine;
        //try (BufferedReader br = new BufferedReader(new FileReader(DATA_SIMULATION_FILE2))) {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_SIMULATION_FILE))) {
            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine = sCurrentLine.replace(" ", "");
                sCurrentLine = sCurrentLine.replace("\t", "");
                sCurrentLine = sCurrentLine.replace("-","-");
                String[] currLine = sCurrentLine.split("-");

                Integer time = Integer.parseInt(currLine[0]);
                Router routerFrom = new Router(Integer.parseInt(currLine[1]));
                Router routerTo = new Router(Integer.parseInt(currLine[2]));
                int dataAmount = Integer.parseInt(currLine[3]);
                SimulationData tmp = new SimulationData(time, routerFrom, routerTo, dataAmount);
                simulationData.add(tmp);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printRouters(int id) {
        System.out.println("Routery");
        for (Map.Entry<Integer, Router> router : router.entrySet()) {
            if (id == -1) System.out.println(router.getKey() + " - " + router.getValue());
            else if (id == router.getKey()) System.out.println(router.getKey() + " - " + router.getValue());
        }
    }
    public static void printRouters() {
        printRouters(-1);
    }

    public static void printLinks(int from, int to) {
        System.out.println("Linky");
        for (int i = 0; i < links.size(); i++) {
            if (from == -1 && to == -1) System.out.println(links.get(i).toString());
            else if ((from == links.get(i).getR1().getId() && to ==  links.get(i).getR2().getId())
                    || (from == links.get(i).getR2().getId() && to ==  links.get(i).getR1().getId()))
                System.out.println(links.get(i).toString());
        }
    }

    public  static void printLinks() {
        printLinks(-1, -1);
    }

    public  static void printLinks(int from) {
        printLinks(from, -1);
    }

    public static void printSimulationData() {
        for (Iterator<SimulationData> it = simulationData.listIterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

}
