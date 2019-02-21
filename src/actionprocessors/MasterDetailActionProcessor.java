package actionprocessors;

import org.entirej.framework.core.EJActionProcessorException;
import org.entirej.framework.core.EJBlock;
import org.entirej.framework.core.EJForm;
import org.entirej.framework.core.EJItem;
import org.entirej.framework.core.EJRecord;
import org.entirej.framework.core.actionprocessor.EJDefaultFormActionProcessor;
import org.entirej.framework.core.enumerations.EJScreenType;

import forms.constants.F_MASTER_DETAIL;

public class MasterDetailActionProcessor extends EJDefaultFormActionProcessor {

	@Override
	public void executeActionCommand(EJForm form, String blockName, String command, EJScreenType screenType)
			throws EJActionProcessorException {

		if (blockName != null && ((blockName.equals(F_MASTER_DETAIL.B_DETAIL.ID))
				|| blockName.equals(F_MASTER_DETAIL.B_ADDTOOLBAR.ID))) {

			if (F_MASTER_DETAIL.AC_TOOLBAR_NEW.equals(command)) {
				form.getBlock(F_MASTER_DETAIL.B_DETAIL.ID).enterInsert(false);
				return;
			}

			if (F_MASTER_DETAIL.AC_TOOLBAR_EDIT.equals(command)) {
				form.getBlock(F_MASTER_DETAIL.B_DETAIL.ID).enterUpdate();
				return;
			}

			if (F_MASTER_DETAIL.AC_TOOLBAR_DELETE.equals(command)
					&& form.getBlock(F_MASTER_DETAIL.B_DETAIL.ID).getFocusedRecord() != null) {
				form.getBlock(F_MASTER_DETAIL.B_DETAIL.ID)
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

		form.getBlock(F_MASTER_DETAIL.B_MASTER.ID).executeQuery();
	}

	@Override
	public void postBlockQuery(EJForm form, EJBlock block) throws EJActionProcessorException {
		// super.postBlockQuery(form, block);

		EJBlock masterBlock = form.getBlock(F_MASTER_DETAIL.B_MASTER.ID);
		EJRecord masterRecord = masterBlock.getFocusedRecord();

		/*EJItem id = masterRecord.getItem(F_MASTER_DETAIL.B_MASTER.I_ID);

		if (id == null)*/
			//form.getBlock(F_MASTER_DETAIL.B_ADDTOOLBAR.ID)block.
		/*
		 * else form.getBlock(F_MASTER_DETAIL.B_ADDTOOLBAR.I_NEW).setDisplayProperty(
		 * "Visible", "true");
		 */

	}

	@Override
	public void postItemChanged(EJForm form, String blockName, String itemName, EJScreenType screenType)
			throws EJActionProcessorException {
		
		System.out.println(itemName);
		super.postItemChanged(form, blockName, itemName, screenType);
	}
	
	

}
