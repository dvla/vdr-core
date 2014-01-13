package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.*;
import uk.gov.dvla.messages.*;
import uk.gov.dvla.servicebus.core.Bus;
import uk.gov.dvla.services.common.HttpRequestHelper;
import uk.gov.dvla.services.common.ServiceDateFormat;
import uk.gov.dvla.services.utils.J2S;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class AuditorService {

    private Bus serviceBus;

    public AuditorService(Bus serviceBus) {

        this.serviceBus = serviceBus;
    }

    public void send(AuditMessage msg) {
        serviceBus.send(msg);
    }

    public void auditPostcodeBlank(String dln, String searchedPostcode, HttpServletRequest request,
                                   DateTime requestTime) {
        send(new CustomerPostcodeIsBlank(dln, searchedPostcode, requestTime,
                new DateTime(), HttpRequestHelper.getIpAddress(request)));
    }

    public void auditPostcodeContainsSpecialCharacter(String dln, String searchedPostcode,
                                                      HttpServletRequest request, DateTime requestTime) {
        send(new CustomerPostcodeContainsSpecialCharacter(dln, searchedPostcode, requestTime,
                new DateTime(), HttpRequestHelper.getIpAddress(request)));
    }

    public void auditPostcodeMismatch(String dln, String searchedPostcode, HttpServletRequest request,
                                      DateTime requestTime) {
        send(new CustomerPostcodeNotMatched(dln, searchedPostcode, requestTime, new DateTime(),
                HttpRequestHelper.getIpAddress(request)));
    }

    public void auditDlnSuppression(RulesDriver result, String dln, HttpServletRequest request,
                                    DateTime requestSent) {

        if (isDriverFullySuppressed(result)) {
            send(new CustomerDlnSuppressed(dln, requestSent, new DateTime(),
                    HttpRequestHelper.getIpAddress(request), result.getRuleApplied()));
        }
    }

    public void auditDetailsSuppression(RulesDriver result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request,
                                        DateTime requestSent) throws ParseException {

        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);

            send(new CustomerPersonalDetailsSuppressed(forenames, surname, new DateTime(parsedDob),
                    gender, postcode, requestSent, new DateTime(), HttpRequestHelper.getIpAddress(request),
                    result.getRuleApplied()));
        }
    }

    public void auditDVLADlnSuppression(RulesDriver result, String dln, DateTime requestSent,
                                        String contactChannel, List<String> enquiryReasons, HttpServletRequest request) {
        if (isDriverFullySuppressed(result)) {
            send(new DvlaDlnSuppressed(dln, requestSent, new DateTime(),
                    result.getRuleApplied(), contactChannel, J2S.list(enquiryReasons),
                    HttpRequestHelper.getIpAddress(request)));
        }
    }

    public void auditDVLADetailsSuppression(RulesDriver result, String dln, String forenames, String surname,
                                            String dob, Integer gender, String postcode, DateTime requestSent,
                                            String contactChannel, List<String> enquiryReasons,
                                            HttpServletRequest request) throws ParseException {
        if (isDriverFullySuppressed(result)) {
            Date parsedDob = ServiceDateFormat.DEFAULT.parse(dob);

            send(new DvlaPersonalDetailsSuppressed(dln, forenames, surname, new DateTime(parsedDob),
                    gender, postcode, requestSent, new DateTime(), result.getRuleApplied(),
                    contactChannel, J2S.list(enquiryReasons), HttpRequestHelper.getIpAddress(request)));
        }

    }

    public void auditNINOAuthenticateSuccess(String dln, String coreMatch,
                                             String coreAndAddressMatch, String deceased,
                                             DateTime requestSent, HttpServletRequest request) {
        send(new NINOAuthenticateSuccess(dln,
                coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime(),
                HttpRequestHelper.getIpAddress(request)));
    }

    public void auditNINOAuthenticateFailure(String dln, String coreMatch,
                                             String coreAndAddressMatch, String deceased,
                                             DateTime requestSent, HttpServletRequest request) {
        send(new NINOAuthenticateFailure(dln,
                coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime(),
                HttpRequestHelper.getIpAddress(request)));
    }

    public void auditNINOAuthenticateDeceased(String dln, String coreMatch,
                                              String coreAndAddressMatch, String deceased,
                                              DateTime requestSent, HttpServletRequest request) {
        send(new NINOAuthenticateDeceased(dln,
                coreMatch, coreAndAddressMatch, deceased, requestSent, new DateTime(),
                HttpRequestHelper.getIpAddress(request)));
    }

    public void auditNINOAuthenticateServiceMaintenance(String dln, DateTime requestSent, HttpServletRequest request) {
        send(new NINOAuthenticateServiceMaintenance(dln, requestSent, new DateTime(),
                HttpRequestHelper.getIpAddress(request)));
    }

    public void auditNINOAuthenticateServiceError(String dln, DateTime requestSent, HttpServletRequest request) {
        send(new NINOAuthenticateServiceError(dln, requestSent, new DateTime(),
                HttpRequestHelper.getIpAddress(request)));
    }

    public void auditIDAMatch(String matchId, DateTime requestReceived, String matchingOutcome, String matchingBasis, String pid) {
        send(new IDAMatchRequest(matchId, requestReceived, matchingOutcome, matchingBasis, pid));
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
