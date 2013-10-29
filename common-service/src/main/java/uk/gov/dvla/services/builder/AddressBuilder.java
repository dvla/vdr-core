package uk.gov.dvla.services.builder;

import uk.gov.dvla.domain.Address;

public class AddressBuilder {

    private String postcode;
    private String buildNo;
    private String tfare;
    private String postTown;

    public Address build(){

        Address add = new Address();
        add.setBuildingName(buildNo);
        add.setDdtfare(tfare);
        add.setPostTown(postTown);
        add.setPostCode(postcode);
        add.setType("UK");
        return add;
    }

    public AddressBuilder houseNumber(int houseNo){

        buildNo = String.valueOf(houseNo);
        return this;
    }

    public AddressBuilder thoroughfare(String name, String type){

        StringBuffer addressLine = new StringBuffer(name);
        addressLine.append(" ");
        addressLine.append(type);
        tfare = addressLine.toString();
        return this;
    }

    public AddressBuilder postTown(String postTown1){
        postTown = postTown1;
        return this;
    }

    public AddressBuilder postcode(String postcode1){
        this.postcode = postcode1;
        return this;
    }
}
