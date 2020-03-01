public class SimulationData {
    /** Cas, kdy se maji data poslat*/
    private Integer time;
    /** Router, odkud vedou data*/
    private Router routerFrom;
    /** Router, kam vedou data*/
    private Router routerTo;
    /** Pocet posilanych dat*/
    private int dataAmount;

    public SimulationData(Integer time, Router routerFrom, Router routerTo, int dataAmount) {
        this.time = time;
        this.routerFrom = routerFrom;
        this.routerTo = routerTo;
        this.dataAmount = dataAmount;
    }

    public Integer getTime() {
        return time;
    }

    public Router getRouterFrom() {
        return routerFrom;
    }

    public Router getRouterTo() {
        return routerTo;
    }

    public int getDataAmount() {
        return dataAmount;
    }

    @Override
    public String toString() {
        return "Time = " + time
                + ", From = " + routerFrom.getId()
                + ", To = " + routerTo.getId()
                + ", Data = " + dataAmount;
    }
}
