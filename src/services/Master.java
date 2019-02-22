package services;

import java.util.HashMap;

import org.entirej.framework.core.EJFieldName;

public class Master {
	private HashMap<FieldNames<?>, Object> _initialValues = new HashMap<FieldNames<?>, Object>();

	private String _name;
	private Integer _id;
	private Double _votes;

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

	@EJFieldName("votes")
	public Double getVotes() {
		return _votes;
	}

	@EJFieldName("votes")
	public void setVotes(Double votes) {
		_votes = votes;
		if (!_initialValues.containsKey(FieldNames.votes)) {
			_initialValues.put(FieldNames.votes, votes);
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
			if (fieldName.equals(FieldNames.votes)) {
				return (T) getVotes();
			}

			return null;
		}
	}

	public void clearInitialValues() {
		_initialValues.clear();

		_initialValues.put(FieldNames.name, _name);

		_initialValues.put(FieldNames.id, _id);

		_initialValues.put(FieldNames.votes, _votes);
	}

	public static class FieldNames<T> {

		public static final FieldNames<java.lang.String> name = new FieldNames<>();
		public static final FieldNames<java.lang.Integer> id = new FieldNames<>();
		public static final FieldNames<java.lang.Double> votes = new FieldNames<>();
		T type;
	}

}
