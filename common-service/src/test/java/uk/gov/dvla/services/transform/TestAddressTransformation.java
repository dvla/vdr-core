package uk.gov.dvla.services.transform;

import org.junit.Assert;
import org.junit.Test;
import uk.gov.dvla.domain.Address;
import uk.gov.dvla.domain.portal.PortalDTO;

import java.util.Arrays;

public class TestAddressTransformation {
    @Test
    public void testUnstructured() {
        Address address = new Address();
        address.setType("UN");
        address.setuLine(Arrays.asList("123", "White Lane", "Swansea"));
        address.setuPostCode("SA2 8JK");

        PortalDTO.Address result = AddressTransformer.apply(address);
        Assert.assertEquals("address line", "123 White Lane Swansea", result.getAddrLine());
        Assert.assertEquals("post code", "SA2 8JK", result.getPostCode());
    }

    @Test
    public void testStructured() {
        Address address = new Address();
        address.setType("UK");
        address.setSubBuildingName("Flat 6");
        address.setBuildingName("Ocean Towers");
        address.setBuildingNumber("1");
        address.setDtfare("Gorse View");
        address.setTfare("School Road");
        address.setDdLocality("Netherthong");
        address.setPostTown("HUDDERSFIELD");
        address.setPostCode("HD7 2UQ");

        PortalDTO.Address result = AddressTransformer.apply(address);
        Assert.assertEquals("Flat 6 Ocean Towers 1 Gorse View School Road Netherthong HUDDERSFIELD", result.getAddrLine());
        Assert.assertEquals("post code", "HD7 2UQ", result.getPostCode());
    }
}
