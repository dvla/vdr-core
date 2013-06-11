package uk.gov.dvla.services.audit;

import org.joda.time.DateTime;
import uk.gov.dvla.domain.Driver;
import uk.gov.dvla.domain.ServiceResult;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface AuditorService {
    public void auditMultipleFound(List<Driver> drivers, HttpServletRequest request, DateTime requestSent,
                                   String forenames, String surname, Date parsedDob, Integer gender, String postcode);

    public void auditPostcodeMismatch(Driver driver, String dln, String postcode, HttpServletRequest request, DateTime requestSent);

    public void auditDlnSuppression(ServiceResult<Driver> driver, String dln, HttpServletRequest request, DateTime requestSent);

    public void auditDetailsSuppression(ServiceResult<Driver> result, String forenames, String surname, String dob,
                                        Integer gender, String postcode, HttpServletRequest request, DateTime requestSent) throws ParseException;

    public void auditDVLADlnSuppression(ServiceResult<Driver> driver, String dln, DateTime requestSent);
}
