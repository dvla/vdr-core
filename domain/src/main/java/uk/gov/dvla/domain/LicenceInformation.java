package uk.gov.dvla.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class LicenceInformation {

    public String typeCode;
    public String typeName;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
