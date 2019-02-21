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

public class DetailService implements EJBlockService<Detail> {
	private final EJStatementExecutor _statementExecutor = new EJStatementExecutor();
	private String _selectStatement = "SELECT address,id,master_id FROM detail";

	@Override
	public List<Detail> executeQuery(EJForm form, EJQueryCriteria queryCriteria) {
		return _statementExecutor.executeQuery(Detail.class, form, _selectStatement, queryCriteria);
	}

	@Override
	public void executeInsert(EJForm form, List<Detail> newRecords) {

		int recordsProcessed = 0;
		for (Detail record : newRecords) {
			// Initialise the value list
			List<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();
			parameters.add(new EJStatementParameter("address", String.class, record.getAddress()));
			parameters.add(new EJStatementParameter("id", Integer.class, record.getId()));
			parameters.add(new EJStatementParameter("master_id", Integer.class, record.getMasterId()));
			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeInsert(form, "detail", parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != newRecords.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in insert. Expected: "
					+ newRecords.size() + ". Inserted: " + recordsProcessed);
		}
	}

	@Override
	public void executeUpdate(EJForm form, List<Detail> updateRecords) {

		int recordsProcessed = 0;
		for (Detail record : updateRecords) {
			List<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();

			// First add the new values
			parameters.add(new EJStatementParameter("address", String.class, record.getAddress()));
			parameters.add(new EJStatementParameter("id", Integer.class, record.getId()));
			parameters.add(new EJStatementParameter("master_id", Integer.class, record.getMasterId()));

			EJStatementCriteria criteria = new EJStatementCriteria();

			if (record.getInitialValue(Detail.FieldNames.address) == null) {
				criteria.add(EJRestrictions.isNull("address"));
			} else {
				criteria.add(EJRestrictions.equals("address", record.getInitialValue(Detail.FieldNames.address)));
			}
			if (record.getInitialValue(Detail.FieldNames.id) == null) {
				criteria.add(EJRestrictions.isNull("id"));
			} else {
				criteria.add(EJRestrictions.equals("id", record.getInitialValue(Detail.FieldNames.id)));
			}
			if (record.getInitialValue(Detail.FieldNames.master_id) == null) {
				criteria.add(EJRestrictions.isNull("master_id"));
			} else {
				criteria.add(EJRestrictions.equals("master_id", record.getInitialValue(Detail.FieldNames.master_id)));
			}

			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeUpdate(form, "detail", criteria,
					parameters.toArray(paramArray));
			record.clearInitialValues();
		}
		if (recordsProcessed != updateRecords.size()) {
			throw new EJApplicationException("Unexpected amount of records processed in update. Expected: "
					+ updateRecords.size() + ". Updated: " + recordsProcessed);
		}
	}

	@Override
	public void executeDelete(EJForm form, List<Detail> recordsToDelete) {
		ArrayList<EJStatementParameter> parameters = new ArrayList<EJStatementParameter>();

		int recordsProcessed = 0;
		for (Detail record : recordsToDelete) {

			EJStatementCriteria criteria = new EJStatementCriteria();

			if (record.getInitialValue(Detail.FieldNames.address) == null) {
				criteria.add(EJRestrictions.isNull("address"));
			} else {
				criteria.add(EJRestrictions.equals("address", record.getInitialValue(Detail.FieldNames.address)));
			}
			if (record.getInitialValue(Detail.FieldNames.id) == null) {
				criteria.add(EJRestrictions.isNull("id"));
			} else {
				criteria.add(EJRestrictions.equals("id", record.getInitialValue(Detail.FieldNames.id)));
			}
			if (record.getInitialValue(Detail.FieldNames.master_id) == null) {
				criteria.add(EJRestrictions.isNull("master_id"));
			} else {
				criteria.add(EJRestrictions.equals("master_id", record.getInitialValue(Detail.FieldNames.master_id)));
			}

			EJStatementParameter[] paramArray = new EJStatementParameter[parameters.size()];
			recordsProcessed += _statementExecutor.executeDelete(form, "detail", criteria,
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
