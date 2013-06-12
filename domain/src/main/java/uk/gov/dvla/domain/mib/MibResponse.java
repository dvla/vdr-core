package uk.gov.dvla.domain.mib;

import uk.gov.dvla.domain.Licence;
import uk.gov.dvla.domain.Person;

import java.util.List;

public class MibResponse {

    public class Driver extends Person {

        private Licence licence;
        private List<Integer> stopMarker;
        private List<Integer> restrictionKey;
        private List<String> caseType;
        private List<String> errorCode;
        private Boolean endorsementAmountExcess;
        private String statusCode = null;

        private String currentDriverNumber = null;

        public void setLicence(Licence lics) {
            licence = lics;
        }

        public Licence getLicence() {
            return this.licence;
        }

        public List<Integer> getStopMarker() {
            return stopMarker;
        }

        public void setStopMarker(List<Integer> markers) {
            this.stopMarker = markers;
        }

        public List<Integer> getRestrictionKey() {
            return restrictionKey;
        }

        public void setRestrictionKey(List<Integer> keys) {
            this.restrictionKey = keys;
        }

        public List<String> getCaseType() {
            return this.caseType;
        }

        public void setCaseType(List<String> caseTypes) {
            this.caseType = caseTypes;
        }

        public List<String> getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(List<String> errorCodes) {
            this.errorCode = errorCodes;
        }

        public void setCurrentDriverNumber(String dln) {
            this.currentDriverNumber = dln;
        }

        public String getCurrentDriverNumber() {
            return this.currentDriverNumber;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public Boolean getEndorsementAmountExcess() {
            return endorsementAmountExcess;
        }

        public void setEndorsementAmountExcess(Boolean endorsmentAmountExcess) {
            this.endorsementAmountExcess = endorsmentAmountExcess;
        }
    }
}


