package actionprocessors;

import org.entirej.framework.core.EJActionProcessorException;
import org.entirej.framework.core.EJBlock;
import org.entirej.framework.core.EJForm;
import org.entirej.framework.core.EJRecord;
import org.entirej.framework.core.actionprocessor.EJDefaultFormActionProcessor;
import org.entirej.framework.core.enumerations.EJScreenType;
import org.entirej.framework.core.service.EJQueryCriteria;
import org.entirej.framework.core.service.EJQuerySort;

import forms.constants.F_MASTER_DETAIL;

public class MasterDetailActionProcessor extends EJDefaultFormActionProcessor {

	Double currentValue = 0d;

	@Override
	public void executeActionCommand(EJForm form, String blockName, String command, EJScreenType screenType)
			throws EJActionProcessorException {

		if (blockName != null && ((blockName.equals(F_MASTER_DETAIL.B_DETAILS.ID))
				|| blockName.equals(F_MASTER_DETAIL.B_ADDTOOLBAR.ID))) {

			if (F_MASTER_DETAIL.AC_TOOLBAR_NEW.equals(command)) {

				EJBlock masterBlock = form.getBlock(F_MASTER_DETAIL.B_MASTER.ID);
				EJRecord masterRecord = masterBlock.getFocusedRecord();

				form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID).enterInsert(false);
				return;
			}

			if (F_MASTER_DETAIL.AC_TOOLBAR_EDIT.equals(command)) {
				form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID).enterUpdate();
				return;
			}

			if (F_MASTER_DETAIL.AC_TOOLBAR_DELETE.equals(command)
					&& form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID).getFocusedRecord() != null) {
				form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID)
						.askToDeleteCurrentRecord("Are you sure you want to delete this detail?");
				return;
			}

		} else {
			if (F_MASTER_DETAIL.AC_TOOLBAR_NEW.equals(command)) {
				form.getBlock(F_MASTER_DETAIL.B_MASTER.ID).enterInsert(false);
				return;
			}

			if (F_MASTER_DETAIL.AC_TOOLBAR_EDIT.equals(command)) {
				form.getBlock(F_MASTER_DETAIL.B_MASTER.ID).enterUpdate();
				return;
			}

			if (F_MASTER_DETAIL.AC_TOOLBAR_DELETE.equals(command)
					&& form.getBlock(F_MASTER_DETAIL.B_MASTER.ID).getFocusedRecord() != null) {
				form.getBlock(F_MASTER_DETAIL.B_MASTER.ID)
						.askToDeleteCurrentRecord("Are you sure you want to delete this master?");
				return;
			}
		}
	}

	@Override
	public void newFormInstance(EJForm form) throws EJActionProcessorException {
		super.newFormInstance(form);
		
		EJQueryCriteria crit=new EJQueryCriteria();
		crit.add(EJQuerySort.DESC(F_MASTER_DETAIL.B_MASTER.I_ID));

		form.getBlock(F_MASTER_DETAIL.B_MASTER.ID).executeQuery(crit);
	}

	@Override
	public void postBlockQuery(EJForm form, EJBlock block) throws EJActionProcessorException {
		// super.postBlockQuery(form, block);

		EJBlock masterBlock = form.getBlock(F_MASTER_DETAIL.B_MASTER.ID);
		EJRecord masterRecord = masterBlock.getFocusedRecord();

		/*
		 * EJItem id = masterRecord.getItem(F_MASTER_DETAIL.B_MASTER.I_ID);
		 * 
		 * if (id == null)
		 */
		// form.getBlock(F_MASTER_DETAIL.B_ADDTOOLBAR.ID)block.
		/*
		 * else form.getBlock(F_MASTER_DETAIL.B_ADDTOOLBAR.I_NEW).setDisplayProperty(
		 * "Visible", "true");
		 */

	}

	@Override
	public void postItemChanged(EJForm form, String blockName, String itemName, EJScreenType screenType)
			throws EJActionProcessorException {

		super.postItemChanged(form, blockName, itemName, screenType);
		/*
		 * Double totalVote = 0d;
		 * 
		 * if (blockName.equals(form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID).getName()))
		 * {
		 * 
		 * Collection<EJRecord> records =
		 * form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID).getBlockRecords(); for (EJRecord
		 * r : records) { EJItem vote = r.getItem(F_MASTER_DETAIL.B_DETAILS.I_VOTE);
		 * 
		 * totalVote = totalVote + Double.parseDouble(vote.getValue().toString()); }
		 * 
		 * EJBlock masterBlock = form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID); EJRecord
		 * masterRecord = masterBlock.getFocusedRecord();
		 * 
		 * Double curValue = (Double)
		 * masterRecord.getValue(F_MASTER_DETAIL.B_DETAILS.I_VOTE);
		 * 
		 * // totalVote = totalVote - curValue; }
		 * 
		 * totalVote = totalVote + currentValue;
		 * 
		 * EJBlock masterBlock = form.getBlock(F_MASTER_DETAIL.B_MASTER.ID); EJRecord
		 * masterRecord = masterBlock.getFocusedRecord();
		 * masterRecord.setValue(F_MASTER_DETAIL.B_MASTER.I_VOTES, totalVote);
		 */
	}

	@Override
	public void validateItem(EJForm form, String blockName, String itemName, EJScreenType screenType,
			EJRecord newValues) throws EJActionProcessorException {

		super.validateItem(form, blockName, itemName, screenType, newValues);

		Double totalVote = 0d;

		if (blockName.equals(form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID).getName())) {
			EJBlock masterBlock = form.getBlock(F_MASTER_DETAIL.B_MASTER.ID);
			EJRecord masterRecord = masterBlock.getFocusedRecord();

			if (masterRecord.getItem(F_MASTER_DETAIL.B_MASTER.I_VOTES) != null
					&& masterRecord.getItem(F_MASTER_DETAIL.B_MASTER.I_VOTES).getValue() != null)
				totalVote = Double
						.valueOf(masterRecord.getItem(F_MASTER_DETAIL.B_MASTER.I_VOTES).getValue().toString());

			if (screenType.name().equals("UPDATE")) {
				EJBlock detailBlock = form.getBlock(F_MASTER_DETAIL.B_DETAILS.ID);
				EJRecord detailRecord = detailBlock.getFocusedRecord();

				Double previousValue = 0d;

				if (detailRecord.getItem(F_MASTER_DETAIL.B_DETAILS.I_VOTE) != null
						&& detailRecord.getItem(F_MASTER_DETAIL.B_DETAILS.I_VOTE).getValue() != null)
					previousValue = Double
							.valueOf(detailRecord.getItem(F_MASTER_DETAIL.B_DETAILS.I_VOTE).getValue().toString());

				totalVote = totalVote - previousValue;

				if (totalVote < 0)
					totalVote = 0d;

				if (newValues.getValue(F_MASTER_DETAIL.B_DETAILS.I_VOTE) != null)
					totalVote = totalVote
							+ Double.valueOf(newValues.getValue(F_MASTER_DETAIL.B_DETAILS.I_VOTE).toString());
			} else {
				if (newValues.getValue(F_MASTER_DETAIL.B_DETAILS.I_VOTE) != null)
					totalVote = totalVote
							+ Double.valueOf(newValues.getValue(F_MASTER_DETAIL.B_DETAILS.I_VOTE).toString());
			}

			masterRecord.setValue(F_MASTER_DETAIL.B_MASTER.I_VOTES, totalVote);

			masterBlock.updateRecord(masterRecord);

		}
	}

	@Override
	public void postFormSave(EJForm form) throws EJActionProcessorException {
		super.postFormSave(form);

		form.getBlock(F_MASTER_DETAIL.B_MASTER.ID).executeQuery();
	}

}
