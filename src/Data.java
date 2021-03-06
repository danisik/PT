public class Data {
    /**Mnozstvi dat*/
    private short amount;
    /**Cilovy router*/
    private final short targetRouterId;
    /**ID dat*/
    private final Integer dataId;

    /**
     * Vytvori 'datovy paket' s mnozstvim dat, ktere prenasi a id routeru kam.
     *
     * @param dataAmount mnozstvi prenasenych dat
     * @param routerId id ciloveho routeru
     * @param theDataId id dat
     */
    public Data(short dataAmount, short routerId, Integer theDataId) {
        amount = dataAmount;
        targetRouterId = routerId;
        dataId = theDataId;
    }

    /**
     * Vraci id dat
     * @return data id
     */
    public Integer getDataId() {
        return dataId;
    }

    /**
     * Vraci nam id routeru, do ktereho posilame data
     * @return id target routeru
     */
    public short getTargetRouterId() {
        return targetRouterId;
    }

}
