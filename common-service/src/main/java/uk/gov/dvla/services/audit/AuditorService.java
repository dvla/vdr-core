package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.UUID;

public interface AuditorService {

    public void auditPostcodeBlank(String dln, String postcode, HttpServletRequest request, DateTime requestSent);

    public void auditPostcodeContainsSpecialCharacter(String dln, String postcode, HttpServletRequest request,
                                                      DateTime requestSent);

    public void auditPostcodeMismatch(String dln, String postcode, HttpServletRequest request, DateTime requestSent);

    public void auditDlnSuppression(ServiceResult<Driver> driver, String dln, HttpServletRequest request,
                                    DateTime requestSent);

    public void auditDetailsSuppression(ServiceResult<Driver> result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request,
                                        DateTime requestSent) throws ParseException;

    public void auditDVLADlnSuppression(ServiceResult<Driver> driver, String dln, DateTime requestSent, String
            contactChannel, String enquiryReason, HttpServletRequest request);

    public void auditDVLADetailsSuppression(ServiceResult<Driver> driver, String dln, String forenames,
                                            String surname, String dob, Integer gender, String postcode,
                                            DateTime requestSent, String contactChannel,
                                            String enquiryReason, HttpServletRequest request) throws ParseException;

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
}
