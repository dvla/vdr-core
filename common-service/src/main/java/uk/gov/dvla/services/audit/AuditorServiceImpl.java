package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.Message;
import uk.gov.dvla.domain.MessageType;
import uk.gov.dvla.domain.ServiceResult;
import uk.gov.dvla.messages.*;
import uk.gov.dvla.servicebus.core.Bus;
import uk.gov.dvla.services.common.HttpHelperService;
import uk.gov.dvla.services.common.PostcodeHelper;
import uk.gov.dvla.services.common.ServiceDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
    public void auditPostcodeMismatch(Driver driver, String dln, String searchedPostcode, HttpServletRequest request,
                                        DateTime requestTime) {

        if (PostcodeHelper.hasSpecialChars(driver.getAddress().getPostCode())) {
            this.serviceBus.send(new CustomerPostcodeContainsSpecialCharacter(dln, searchedPostcode, requestTime,
                                        new DateTime(), httpHelperService.getIpAddress(request)));
        }
        else {
            if (PostcodeHelper.postcodeMismatch(driver.getAddress().getPostCode(),searchedPostcode,dummyPostcodes)) {
                this.serviceBus.send(new CustomerPostcodeNotMatched(dln, searchedPostcode, requestTime, new DateTime(),
                        httpHelperService.getIpAddress(request)));

                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        }
    }

    @Override
    public void auditDlnSuppression(ServiceResult<Driver> result, String dln, HttpServletRequest request,
                                    DateTime requestSent) {

        if (isDriverFullySuppressed(result))  {
            this.serviceBus.send(new CustomerDlnSuppressed(dln, requestSent, new DateTime(),
                    httpHelperService.getIpAddress(request), result.getRuleApplied()));
        }
    }

    @Override
    public void auditDetailsSuppression(ServiceResult<Driver> result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request,
                                        DateTime requestSent) throws ParseException {

        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);

            this.serviceBus.send(new CustomerPersonalDetailsSuppressed(forenames, surname, new DateTime(parsedDob), gender,
                    postcode, requestSent, new DateTime(), httpHelperService.getIpAddress(request), result.getRuleApplied()));
        }
    }

    @Override
    public void auditDVLADlnSuppression(ServiceResult<Driver> result, String dln, DateTime requestSent,
                                        String contactChannel, String enquiryReason, HttpServletRequest request) {
        if (isDriverFullySuppressed(result)) {
            this.serviceBus.send(new DvlaDlnSuppressed(dln, requestSent, new DateTime(),
                    result.getRuleApplied(), contactChannel, enquiryReason, httpHelperService.getIpAddress(request)));
        }
    }

    @Override
    public void auditDVLADetailsSuppression(ServiceResult<Driver> result, String dln, String forenames, String surname, String dob,
                                            Integer gender, String postcode, DateTime requestSent, String contactChannel,
                                            String enquiryReason, HttpServletRequest request) throws ParseException {
        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);
            this.serviceBus.send(new DvlaPersonalDetailsSuppressed(dln, forenames, surname, new DateTime(parsedDob),
                    gender, postcode, requestSent, new DateTime(), result.getRuleApplied(),
                   contactChannel, enquiryReason, httpHelperService.getIpAddress(request)));
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
