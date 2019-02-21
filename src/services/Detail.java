package services;

import java.util.HashMap;

import org.entirej.framework.core.EJFieldName;

public class Detail {
	private HashMap<FieldNames<?>, Object> _initialValues = new HashMap<FieldNames<?>, Object>();

	private Integer _id;
	private Integer _masterId;
	private String _address;

	@EJFieldName("id")
	public Integer getId() {
		return _id;
	}

	@EJFieldName("id")
	public void setId(Integer id) {
		_id = id;
		if (!_initialValues.containsKey(FieldNames.id)) {
			_initialValues.put(FieldNames.id, id);
		}
	}

	@EJFieldName("master_id")
	public Integer getMasterId() {
		return _masterId;
	}

	@EJFieldName("master_id")
	public void setMasterId(Integer masterId) {
		_masterId = masterId;
		if (!_initialValues.containsKey(FieldNames.master_id)) {
			_initialValues.put(FieldNames.master_id, masterId);
		}
	}

	@EJFieldName("address")
	public String getAddress() {
		return _address;
	}

	@EJFieldName("address")
	public void setAddress(String address) {
		_address = address;
		if (!_initialValues.containsKey(FieldNames.address)) {
			_initialValues.put(FieldNames.address, address);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getInitialValue(FieldNames<T> fieldName) {
		if (_initialValues.containsKey(fieldName)) {
			return (T) _initialValues.get(fieldName);
		} else {

			if (fieldName.equals(FieldNames.id)) {
				return (T) getId();
			}
			if (fieldName.equals(FieldNames.master_id)) {
				return (T) getMasterId();
			}
			if (fieldName.equals(FieldNames.address)) {
				return (T) getAddress();
			}

			return null;
		}
	}

	public void clearInitialValues() {
		_initialValues.clear();

		_initialValues.put(FieldNames.id, _id);

		_initialValues.put(FieldNames.master_id, _masterId);

		_initialValues.put(FieldNames.address, _address);
	}

	public static class FieldNames<T> {

		public static final FieldNames<java.lang.Integer> id = new FieldNames<>();
		public static final FieldNames<java.lang.Integer> master_id = new FieldNames<>();
		public static final FieldNames<java.lang.String> address = new FieldNames<>();
		T type;
	}

}
