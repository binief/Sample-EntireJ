package services;

import java.util.HashMap;

import org.entirej.framework.core.EJFieldName;

public class Master {
	private HashMap<FieldNames<?>, Object> _initialValues = new HashMap<FieldNames<?>, Object>();

	private String _name;
	private Integer _id;

	@EJFieldName("name")
	public String getName() {
		return _name;
	}

	@EJFieldName("name")
	public void setName(String name) {
		_name = name;
		if (!_initialValues.containsKey(FieldNames.name)) {
			_initialValues.put(FieldNames.name, name);
		}
	}

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

	@SuppressWarnings("unchecked")
	public <T> T getInitialValue(FieldNames<T> fieldName) {
		if (_initialValues.containsKey(fieldName)) {
			return (T) _initialValues.get(fieldName);
		} else {

			if (fieldName.equals(FieldNames.name)) {
				return (T) getName();
			}
			if (fieldName.equals(FieldNames.id)) {
				return (T) getId();
			}

			return null;
		}
	}

	public void clearInitialValues() {
		_initialValues.clear();

		_initialValues.put(FieldNames.name, _name);

		_initialValues.put(FieldNames.id, _id);
	}

	public static class FieldNames<T> {

		public static final FieldNames<java.lang.String> name = new FieldNames<>();
		public static final FieldNames<java.lang.Integer> id = new FieldNames<>();
		T type;
	}

}
