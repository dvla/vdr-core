package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.messages.*;
import uk.gov.dvla.servicebus.core.Bus;
import uk.gov.dvla.services.common.HttpHelperService;
import uk.gov.dvla.services.common.ServiceDateFormat;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AuditorServiceImpl implements AuditorService {

    private Bus serviceBus;
    private HttpHelperService httpHelperService;

    public AuditorServiceImpl(Bus serviceBus, HttpHelperService httpHelperService) {

        this.serviceBus = serviceBus;
        this.httpHelperService = httpHelperService;
    }

    @Override
    public void auditPostcodeBlank(String dln, String searchedPostcode, HttpServletRequest request,
                                   DateTime requestTime) {
        this.serviceBus.send(new CustomerPostcodeIsBlank(dln, searchedPostcode, requestTime,
                new DateTime(), httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditPostcodeContainsSpecialCharacter(String dln, String searchedPostcode,
                                                      HttpServletRequest request, DateTime requestTime) {
        this.serviceBus.send(new CustomerPostcodeContainsSpecialCharacter(dln, searchedPostcode, requestTime,
                new DateTime(), httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditPostcodeMismatch(String dln, String searchedPostcode, HttpServletRequest request,
                                      DateTime requestTime) {
        this.serviceBus.send(new CustomerPostcodeNotMatched(dln, searchedPostcode, requestTime, new DateTime(),
                httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditDlnSuppression(RulesDriver result, String dln, HttpServletRequest request,
                                    DateTime requestSent) {

        if (isDriverFullySuppressed(result)) {
            this.serviceBus.send(new CustomerDlnSuppressed(dln, requestSent, new DateTime(),
                    httpHelperService.getIpAddress(request), result.getRuleApplied()));
        }
    }

    @Override
    public void auditDetailsSuppression(RulesDriver result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request,
                                        DateTime requestSent) throws ParseException {

        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);

            this.serviceBus.send(new CustomerPersonalDetailsSuppressed(forenames, surname, new DateTime(parsedDob),
                    gender, postcode, requestSent, new DateTime(), httpHelperService.getIpAddress(request),
                    result.getRuleApplied()));
        }
    }

    @Override
    public void auditDVLADlnSuppression(RulesDriver result, String dln, DateTime requestSent,
                                        String contactChannel, List<String> enquiryReasons, HttpServletRequest request) {
        if (isDriverFullySuppressed(result)) {
            this.serviceBus.send(new DvlaDlnSuppressed(dln, requestSent, new DateTime(),
                    result.getRuleApplied(), contactChannel, asScala(enquiryReasons), httpHelperService.getIpAddress(request)));
        }
    }

    @Override
    public void auditDVLADetailsSuppression(RulesDriver result, String dln, String forenames, String surname,
                                            String dob, Integer gender, String postcode, DateTime requestSent,
                                            String contactChannel, List<String> enquiryReasons,
                                            HttpServletRequest request) throws ParseException {
        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);

            this.serviceBus.send(new DvlaPersonalDetailsSuppressed(dln, forenames, surname, new DateTime(parsedDob),
                    gender, postcode, requestSent, new DateTime(), result.getRuleApplied(),
                    contactChannel, asScala(enquiryReasons), httpHelperService.getIpAddress(request)));
        }

    }

    private scala.collection.immutable.List<String> asScala(java.util.List<String> list) {
        return scala.collection.JavaConversions.asScalaBuffer(list).toList();
    }

    @Override
    public void auditMibRealTimeInvalidDetails(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                               HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeMissingMandatoryFields(enquiryId, dln, postcode, requestSent,
                new DateTime(), httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeDlnNotFound(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                            HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeDlnNotFound(enquiryId, dln, postcode, requestSent, new DateTime(),
                httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeInvalidDln(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                           HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeDlnNotValid(enquiryId, dln, postcode, requestSent, new DateTime(),
                httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeServerError(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                            HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeServerError(enquiryId, dln, postcode, requestSent, new DateTime(),
                httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeRecordSuppression(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                                  String ruleApplied, HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeRecordSuppression(enquiryId, dln, postcode, requestSent, new DateTime(),
                ruleApplied, httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeEnquirySuccessful(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                                  HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeEnquirySuccessful(enquiryId, dln, postcode, requestSent, new DateTime(),
                httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeNoEntitlements(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                               HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeNoEntitlements(enquiryId, dln, postcode, requestSent, new DateTime(),
                httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditMibRealTimeEnquiryMessageReturned(UUID enquiryId, String dln, String postcode,
                                                       DateTime requestSent, String message,
                                                       HttpServletRequest request) {
        this.serviceBus.send(new MibRealTimeEnquiryMessageReturned(enquiryId, dln, postcode, requestSent,
                new DateTime(), httpHelperService.getIpAddress(request), message));
    }

    @Override
    public void auditNINOAuthenticateSuccess(String dln, String coreMatch,
                                             String coreAndAddressMatch, String deceased,
                                             DateTime requestSent, HttpServletRequest request) {
        this.serviceBus.send(new NINOAuthenticateSuccess(dln,
                coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime(), httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditNINOAuthenticateFailure(String dln, String coreMatch,
                                             String coreAndAddressMatch, String deceased,
                                             DateTime requestSent, HttpServletRequest request) {
        this.serviceBus.send(new NINOAuthenticateFailure(dln,
                coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime(), httpHelperService.getIpAddress(request)));
    }

    @Override
    public void auditNINOAuthenticateDeceased(String dln, String coreMatch,
                                              String coreAndAddressMatch, String deceased,
                                              DateTime requestSent, HttpServletRequest request) {
        this.serviceBus.send(new NINOAuthenticateDeceased(dln,
                coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime(), httpHelperService.getIpAddress(request)));
    }


    private boolean isDriverFullySuppressed(RulesDriver driverResult) {
        boolean isFullySuppressed = false;

        if (driverResult != null && driverResult.getMessages() != null) {
            for (Message message : driverResult.getMessages()) {
                if (message.getType() == MessageType.SuppressFullRecord.getMessageType()) {
                    isFullySuppressed = true;
                }
            }
        }
        return isFullySuppressed;
    }
}
