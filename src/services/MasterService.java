package services;

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

public class MasterService implements EJBlockService<Master> {
	private final EJStatementExecutor _statementExecutor = new EJStatementExecutor();
	private String _selectStatement = "SELECT id,name,votes FROM master";

	@Override
	public List<Master> executeQuery(EJForm form, EJQueryCriteria queryCriteria) {
		return _statementExecutor.executeQuery(Master.class, form, _selectStatement, queryCriteria);
	}

	@Override
	public void executeInsert(EJForm form, List<Master> newRecords) {

		int recordsProcessed = 0;
		for (Master record : newRecords) {
			// Initialise the value list
			List<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();
			parameters.add(new EJStatementParameter("id", Integer.class, record.getId()));
			parameters.add(new EJStatementParameter("name", String.class, record.getName()));
			parameters.add(new EJStatementParameter("votes", Double.class, record.getVotes()));
			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeInsert(form, "master", parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != newRecords.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in insert. Expected: "
					+ newRecords.size() + ". Inserted: " + recordsProcessed);
		}
	}

	@Override
	public void executeUpdate(EJForm form, List<Master> updateRecords) {

		int recordsProcessed = 0;
		for (Master record : updateRecords) {
			List<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();

			// First add the new values
			parameters.add(new EJStatementParameter("id", Integer.class, record.getId()));
			parameters.add(new EJStatementParameter("name", String.class, record.getName()));
			parameters.add(new EJStatementParameter("votes", Double.class, record.getVotes()));

			EJStatementCriteria criteria = new EJStatementCriteria();

			if (record.getInitialValue(Master.FieldNames.id) == null) {
				criteria.add(EJRestrictions.isNull("id"));
			} else {
				criteria.add(EJRestrictions.equals("id", record.getInitialValue(Master.FieldNames.id)));
			}
			if (record.getInitialValue(Master.FieldNames.name) == null) {
				criteria.add(EJRestrictions.isNull("name"));
			} else {
				criteria.add(EJRestrictions.equals("name", record.getInitialValue(Master.FieldNames.name)));
			}
			if (record.getInitialValue(Master.FieldNames.votes) == null) {
				criteria.add(EJRestrictions.isNull("votes"));
			} else {
				criteria.add(EJRestrictions.equals("votes", record.getInitialValue(Master.FieldNames.votes)));
			}

			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeUpdate(form, "master", criteria,
					parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != updateRecords.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in update. Expected: "
					+ updateRecords.size() + ". Updated: " + recordsProcessed);
		}
	}

	@Override
	public void executeDelete(EJForm form, List<Master> recordsToDelete) {
		ArrayList<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();

		int recordsProcessed = 0;
		for (Master record : recordsToDelete) {

			EJStatementCriteria criteria = new EJStatementCriteria();

			if (record.getInitialValue(Master.FieldNames.id) == null) {
				criteria.add(EJRestrictions.isNull("id"));
			} else {
				criteria.add(EJRestrictions.equals("id", record.getInitialValue(Master.FieldNames.id)));
			}
			if (record.getInitialValue(Master.FieldNames.name) == null) {
				criteria.add(EJRestrictions.isNull("name"));
			} else {
				criteria.add(EJRestrictions.equals("name", record.getInitialValue(Master.FieldNames.name)));
			}
			if (record.getInitialValue(Master.FieldNames.votes) == null) {
				criteria.add(EJRestrictions.isNull("votes"));
			} else {
				criteria.add(EJRestrictions.equals("votes", record.getInitialValue(Master.FieldNames.votes)));
			}

			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeDelete(form, "master", criteria,
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
