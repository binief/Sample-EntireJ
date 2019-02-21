package actionprocessors;

import java.math.BigDecimal;
import java.util.List;

import org.entirej.framework.core.EJActionProcessorException;
import org.entirej.framework.core.EJApplicationException;
import org.entirej.framework.core.EJForm;
import org.entirej.framework.core.EJRecord;
import org.entirej.framework.core.actionprocessor.EJDefaultFormActionProcessor;
import org.entirej.framework.core.service.EJSelectResult;
import org.entirej.framework.core.service.EJStatementExecutor;

public class CompanyActionProcesser extends EJDefaultFormActionProcessor {

	@Override
	public void postInsert(EJForm form, EJRecord record) throws EJActionProcessorException {
		/*
		 * EJStatementExecutor statementExecutor=new EJStatementExecutor();
		 * List<EJSelectResult> results=statementExecutor.executeQuery(form,
		 * "SELECT ID_SEQ.NEXTVAl AS NEXTVAL"); if(results==null || results.size()==0) {
		 * throw new EJApplicationException("Unable to select next val"); } Object
		 * nextValOb=results.get(0).getItemValue("NEXTVAL"); BigDecimal nextVal=new
		 * BigDecimal((Long) nextValOb); record.setValue("ID", nextVal);
		 * super.postInsert(form, record);
		 */
	}

	
}
