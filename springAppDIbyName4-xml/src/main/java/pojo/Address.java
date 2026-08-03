package pojo;

public class Address {
    private int houseNO;
    private int roadNo;
    private String street;


    @Override
    public String toString() {
        return "Address{" +
                "houseNO=" + houseNO +
                ", roadNo=" + roadNo +
                ", street='" + street + '\'' +
                '}';
    }



    public int getHouseNO() {
        return houseNO;
    }

    public void setHouseNO(int houseNO) {
        this.houseNO = houseNO;
    }

    public int getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(int roadNo) {
        this.roadNo = roadNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address(int houseNO, int roadNo, String street) {
        this.houseNO = houseNO;
        this.roadNo = roadNo;
        this.street = street;
    }
    public Address(){

    }


}
