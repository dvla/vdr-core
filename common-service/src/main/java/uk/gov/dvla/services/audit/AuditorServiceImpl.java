package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Message;
import uk.gov.dvla.domain.MessageType;
import uk.gov.dvla.domain.ServiceResult;
import uk.gov.dvla.messages.*;
import uk.gov.dvla.services.common.HttpHelperService;
import uk.gov.dvla.services.common.ServiceDateFormat;
import uk.gov.dvla.servicebus.core.Bus;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class AuditorServiceImpl implements AuditorService {

    private Bus serviceBus;
    private HttpHelperService httpHelperService;
    private List<String> dummyPostcodes;

    public AuditorServiceImpl(Bus serviceBus, HttpHelperService httpHelperService, List<String> dummyPostcodes) {

        this.serviceBus = serviceBus;
        this.httpHelperService = httpHelperService;
        this.dummyPostcodes = dummyPostcodes;
    }

    public AuditorServiceImpl(Bus serviceBus, HttpHelperService httpHelperService) {

        this.serviceBus = serviceBus;
        this.httpHelperService = httpHelperService;
    }

    @Override
    public void auditMultipleFound(List<Driver> drivers, HttpServletRequest request, DateTime requestSent,
                                   String forenames, String surname, Date parsedDob, Integer gender, String postcode) {
        if (drivers.size() > 1) {

            serviceBus.send(new CustomerMultipleFound(forenames, surname, new DateTime(parsedDob), gender,
                    postcode, requestSent, new DateTime(), httpHelperService.getIpAddress(request)));

            throw new WebApplicationException(Response.Status.CONFLICT);
        }
    }

    @Override
    public void auditPostcodeMismatch(Driver driver, String dln, String searchedPostcode, HttpServletRequest request, DateTime requestSent) {

        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        searchedPostcode = searchedPostcode.replace(" ", "");
        String actualPostcode = driver.getAddress().getPostCode().replace(" ", "");
        boolean hasSpecialChar = p.matcher(actualPostcode).find();

        if (hasSpecialChar) {
            this.serviceBus.send(new CustomerPostcodeContainsSpecialCharacter(dln, searchedPostcode, requestSent,
                    new DateTime(), httpHelperService.getIpAddress(request)));
        }
        else {
            if (searchedPostcode != null && !searchedPostcode.equals("")) {
                if (!dummyPostcodes.contains(actualPostcode)) {
                    // Valid searchedPostcode - make sure it matches what is stored in the db
                    if (!searchedPostcode.equalsIgnoreCase(actualPostcode)) {
                        this.serviceBus.send(new CustomerPostcodeNotMatched(dln, searchedPostcode, requestSent, new DateTime(),
                                httpHelperService.getIpAddress(request)));

                        throw new WebApplicationException(Response.Status.NOT_FOUND);
                    }
                }
            }
        }
    }

    @Override
    public void auditDlnSuppression(ServiceResult<Driver> result, String dln, HttpServletRequest request, DateTime requestSent) {

        if (isDriverFullySuppressed(result))  {
            this.serviceBus.send(new CustomerDlnSuppressed(dln, requestSent, new DateTime(),
                    httpHelperService.getIpAddress(request), result.getRuleApplied()));
        }
    }

    @Override
    public void auditDetailsSuppression(ServiceResult<Driver> result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request, DateTime requestSent) throws ParseException {

        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);

            this.serviceBus.send(new CustomerPersonalDetailsSuppressed(forenames, surname, new DateTime(parsedDob), gender,
                    postcode, requestSent, new DateTime(), httpHelperService.getIpAddress(request), result.getRuleApplied()));
        }
    }

    @Override
    public void auditDVLADlnSuppression(ServiceResult<Driver> result, String dln, DateTime requestSent) {
        if (isDriverFullySuppressed(result)) {
            this.serviceBus.send(new DVLADlnSuppressed(dln, requestSent, new DateTime(), result.getRuleApplied(), "Contact Channel TODO", "Enquiry Reason TODO", "LAN ID TODO"));
        }
    }

    private boolean isDriverFullySuppressed(ServiceResult<Driver> driverResult) {
        boolean isFullySuppressed = false;

        if (driverResult.hasMessages()){
            for (Message message : driverResult.getMessages()){
                if (message.getType() == MessageType.SuppressFullRecord.getMessageType()) {
                    isFullySuppressed = true;
                }
            }
        }
        return isFullySuppressed;
    }
}
