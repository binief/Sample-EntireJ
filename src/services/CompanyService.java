package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.entirej.framework.core.EJApplicationException;
import org.entirej.framework.core.EJForm;
import org.entirej.framework.core.service.EJBlockService;
import org.entirej.framework.core.service.EJQueryCriteria;
import org.entirej.framework.core.service.EJRestrictions;
import org.entirej.framework.core.service.EJStatementCriteria;
import org.entirej.framework.core.service.EJStatementExecutor;
import org.entirej.framework.core.service.EJStatementParameter;

public class CompanyService implements EJBlockService<Company> {
	private final EJStatementExecutor _statementExecutor = new EJStatementExecutor();
	private String _selectStatement = "SELECT authorisedcapital,cin,city,companyname,contactemail,country,district,industry FROM company";

	@Override
	public List<Company> executeQuery(EJForm form, EJQueryCriteria queryCriteria) {
		return _statementExecutor.executeQuery(Company.class, form, _selectStatement, queryCriteria);
	}

	@Override
	public void executeInsert(EJForm form, List<Company> newRecords) {

		int recordsProcessed = 0;
		for (Company record : newRecords) {
			// Initialise the value list
			List<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();
			parameters.add(
					new EJStatementParameter("authorisedcapital", BigDecimal.class, record.getAuthorisedcapital()));
			parameters.add(new EJStatementParameter("cin", String.class, record.getCin()));
			parameters.add(new EJStatementParameter("city", String.class, record.getCity()));
			parameters.add(new EJStatementParameter("companyname", String.class, record.getCompanyname()));
			parameters.add(new EJStatementParameter("contactemail", String.class, record.getContactemail()));
			parameters.add(new EJStatementParameter("country", String.class, record.getCountry()));
			parameters.add(new EJStatementParameter("district", String.class, record.getDistrict()));
			parameters.add(new EJStatementParameter("industry", String.class, record.getIndustry()));
			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeInsert(form, "company", parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != newRecords.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in insert. Expected: "
					+ newRecords.size() + ". Inserted: " + recordsProcessed);
		}
	}

	@Override
	public void executeUpdate(EJForm form, List<Company> updateRecords) {

		int recordsProcessed = 0;
		for (Company record : updateRecords) {
			List<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();

			// First add the new values
			parameters.add(
					new EJStatementParameter("authorisedcapital", BigDecimal.class, record.getAuthorisedcapital()));
			parameters.add(new EJStatementParameter("cin", String.class, record.getCin()));
			parameters.add(new EJStatementParameter("city", String.class, record.getCity()));
			parameters.add(new EJStatementParameter("companyname", String.class, record.getCompanyname()));
			parameters.add(new EJStatementParameter("contactemail", String.class, record.getContactemail()));
			parameters.add(new EJStatementParameter("country", String.class, record.getCountry()));
			parameters.add(new EJStatementParameter("district", String.class, record.getDistrict()));
			parameters.add(new EJStatementParameter("industry", String.class, record.getIndustry()));

			EJStatementCriteria criteria = new EJStatementCriteria();

			if (record.getInitialValue(Company.FieldNames.authorisedcapital) == null) {
				criteria.add(EJRestrictions.isNull("authorisedcapital"));
			} else {
				criteria.add(EJRestrictions.equals("authorisedcapital",
						record.getInitialValue(Company.FieldNames.authorisedcapital)));
			}
			if (record.getInitialValue(Company.FieldNames.cin) == null) {
				criteria.add(EJRestrictions.isNull("cin"));
			} else {
				criteria.add(EJRestrictions.equals("cin", record.getInitialValue(Company.FieldNames.cin)));
			}
			if (record.getInitialValue(Company.FieldNames.city) == null) {
				criteria.add(EJRestrictions.isNull("city"));
			} else {
				criteria.add(EJRestrictions.equals("city", record.getInitialValue(Company.FieldNames.city)));
			}
			if (record.getInitialValue(Company.FieldNames.companyname) == null) {
				criteria.add(EJRestrictions.isNull("companyname"));
			} else {
				criteria.add(
						EJRestrictions.equals("companyname", record.getInitialValue(Company.FieldNames.companyname)));
			}
			if (record.getInitialValue(Company.FieldNames.contactemail) == null) {
				criteria.add(EJRestrictions.isNull("contactemail"));
			} else {
				criteria.add(
						EJRestrictions.equals("contactemail", record.getInitialValue(Company.FieldNames.contactemail)));
			}
			if (record.getInitialValue(Company.FieldNames.country) == null) {
				criteria.add(EJRestrictions.isNull("country"));
			} else {
				criteria.add(EJRestrictions.equals("country", record.getInitialValue(Company.FieldNames.country)));
			}
			if (record.getInitialValue(Company.FieldNames.district) == null) {
				criteria.add(EJRestrictions.isNull("district"));
			} else {
				criteria.add(EJRestrictions.equals("district", record.getInitialValue(Company.FieldNames.district)));
			}
			if (record.getInitialValue(Company.FieldNames.industry) == null) {
				criteria.add(EJRestrictions.isNull("industry"));
			} else {
				criteria.add(EJRestrictions.equals("industry", record.getInitialValue(Company.FieldNames.industry)));
			}

			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeUpdate(form, "company", criteria,
					parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != updateRecords.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in update. Expected: "
					+ updateRecords.size() + ". Updated: " + recordsProcessed);
		}
	}

	@Override
	public void executeDelete(EJForm form, List<Company> recordsToDelete) {
		ArrayList<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();

		int recordsProcessed = 0;
		for (Company record : recordsToDelete) {

			EJStatementCriteria criteria = new EJStatementCriteria();

			if (record.getInitialValue(Company.FieldNames.authorisedcapital) == null) {
				criteria.add(EJRestrictions.isNull("authorisedcapital"));
			} else {
				criteria.add(EJRestrictions.equals("authorisedcapital",
						record.getInitialValue(Company.FieldNames.authorisedcapital)));
			}
			if (record.getInitialValue(Company.FieldNames.cin) == null) {
				criteria.add(EJRestrictions.isNull("cin"));
			} else {
				criteria.add(EJRestrictions.equals("cin", record.getInitialValue(Company.FieldNames.cin)));
			}
			if (record.getInitialValue(Company.FieldNames.city) == null) {
				criteria.add(EJRestrictions.isNull("city"));
			} else {
				criteria.add(EJRestrictions.equals("city", record.getInitialValue(Company.FieldNames.city)));
			}
			if (record.getInitialValue(Company.FieldNames.companyname) == null) {
				criteria.add(EJRestrictions.isNull("companyname"));
			} else {
				criteria.add(
						EJRestrictions.equals("companyname", record.getInitialValue(Company.FieldNames.companyname)));
			}
			if (record.getInitialValue(Company.FieldNames.contactemail) == null) {
				criteria.add(EJRestrictions.isNull("contactemail"));
			} else {
				criteria.add(
						EJRestrictions.equals("contactemail", record.getInitialValue(Company.FieldNames.contactemail)));
			}
			if (record.getInitialValue(Company.FieldNames.country) == null) {
				criteria.add(EJRestrictions.isNull("country"));
			} else {
				criteria.add(EJRestrictions.equals("country", record.getInitialValue(Company.FieldNames.country)));
			}
			if (record.getInitialValue(Company.FieldNames.district) == null) {
				criteria.add(EJRestrictions.isNull("district"));
			} else {
				criteria.add(EJRestrictions.equals("district", record.getInitialValue(Company.FieldNames.district)));
			}
			if (record.getInitialValue(Company.FieldNames.industry) == null) {
				criteria.add(EJRestrictions.isNull("industry"));
			} else {
				criteria.add(EJRestrictions.equals("industry", record.getInitialValue(Company.FieldNames.industry)));
			}

			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeDelete(form, "company", criteria,
					parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != recordsToDelete.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in delete. Expected: "
					+ recordsToDelete.size() + ". Deleted: " + recordsProcessed);
		}
	}

	@Override
	public boolean canQueryInPages() {
		return false;
	}
}
