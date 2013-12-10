package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.RulesDriver;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface AuditorService {

    public void auditPostcodeBlank(String dln, String postcode, HttpServletRequest request, DateTime requestSent);

    public void auditPostcodeContainsSpecialCharacter(String dln, String postcode, HttpServletRequest request,
                                                      DateTime requestSent);

    public void auditPostcodeMismatch(String dln, String postcode, HttpServletRequest request, DateTime requestSent);

    public void auditDlnSuppression(RulesDriver driver, String dln, HttpServletRequest request,
                                    DateTime requestSent);

    public void auditDetailsSuppression(RulesDriver result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request,
                                        DateTime requestSent) throws ParseException;

    public void auditDVLADlnSuppression(RulesDriver driver, String dln, DateTime requestSent, String
            contactChannel, List<String> enquiryReasons, HttpServletRequest request);

    public void auditDVLADetailsSuppression(RulesDriver driver, String dln, String forenames,
                                            String surname, String dob, Integer gender, String postcode,
                                            DateTime requestSent, String contactChannel,
                                            List<String> enquiryReasons, HttpServletRequest request) throws ParseException;

    public void auditMibRealTimeInvalidDetails(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                               HttpServletRequest request);

    public void auditMibRealTimeDlnNotFound(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                            HttpServletRequest request);

    public void auditMibRealTimeInvalidDln(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                           HttpServletRequest request);

    public void auditMibRealTimeServerError(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                            HttpServletRequest request);

    public void auditMibRealTimeRecordSuppression(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                                  String ruleApplied, HttpServletRequest request);

    public void auditMibRealTimeEnquirySuccessful(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                                  HttpServletRequest request);

    public void auditMibRealTimeNoEntitlements(UUID enquiryId, String dln, String postcode, DateTime requestSent,
                                               HttpServletRequest request);

    public void auditMibRealTimeEnquiryMessageReturned(UUID enquiryId, String dln, String postcode,
                                                       DateTime requestSent, String message,
                                                       HttpServletRequest request);

    public void auditNINOAuthenticateSuccess(String dln,
                                             String coreMatch,
                                             String coreAndAddressMatch,
                                             String deceased,
                                             DateTime requestSent,
                                             HttpServletRequest request);

    public void auditNINOAuthenticateFailure(String dln,
                                             String coreMatch,
                                             String coreAndAddressMatch,
                                             String deceased,
                                             DateTime requestSent,
                                             HttpServletRequest request);

    public void auditNINOAuthenticateDeceased(String dln,
                                              String coreMatch,
                                              String coreAndAddressMatch,
                                              String deceased,
                                              DateTime requestSent,
                                              HttpServletRequest request);

    public void auditNINOAuthenticateServiceMaintenance(String dln,
                                              DateTime requestSent,
                                              HttpServletRequest request);

    public void auditNINOAuthenticateServiceError(String dln,
                                                        DateTime requestSent,
                                                        HttpServletRequest request);

    public void auditIDAMatch(String matchId, DateTime requestReceived, String matchingOutcome, String matchingBasis, String pid);
}
