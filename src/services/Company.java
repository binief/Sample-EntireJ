package services;

import java.math.BigDecimal;
import java.util.HashMap;

import org.entirej.framework.core.EJFieldName;

import services.Company.FieldNames;

public class Company {
	private HashMap<FieldNames<?>, Object> _initialValues = new HashMap<FieldNames<?>, Object>();

	private String _district;
	private BigDecimal _authorisedcapital;
	private String _cin;
	private String _contactemail;
	private String _city;
	private String _companyname;
	private String _country;
	private String _industry;

	@EJFieldName("district")
	public String getDistrict() {
		return _district;
	}

	@EJFieldName("district")
	public void setDistrict(String district) {
		_district = district;
		if (!_initialValues.containsKey(FieldNames.district)) {
			_initialValues.put(FieldNames.district, district);
		}
	}

	@EJFieldName("authorisedcapital")
	public BigDecimal getAuthorisedcapital() {
		return _authorisedcapital;
	}

	@EJFieldName("authorisedcapital")
	public void setAuthorisedcapital(BigDecimal authorisedcapital) {
		_authorisedcapital = authorisedcapital;
		if (!_initialValues.containsKey(FieldNames.authorisedcapital)) {
			_initialValues.put(FieldNames.authorisedcapital, authorisedcapital);
		}
	}

	@EJFieldName("cin")
	public String getCin() {
		return _cin;
	}

	@EJFieldName("cin")
	public void setCin(String cin) {
		_cin = cin;
		if (!_initialValues.containsKey(FieldNames.cin)) {
			_initialValues.put(FieldNames.cin, cin);
		}
	}

	@EJFieldName("contactemail")
	public String getContactemail() {
		return _contactemail;
	}

	@EJFieldName("contactemail")
	public void setContactemail(String contactemail) {
		_contactemail = contactemail;
		if (!_initialValues.containsKey(FieldNames.contactemail)) {
			_initialValues.put(FieldNames.contactemail, contactemail);
		}
	}

	@EJFieldName("city")
	public String getCity() {
		return _city;
	}

	@EJFieldName("city")
	public void setCity(String city) {
		_city = city;
		if (!_initialValues.containsKey(FieldNames.city)) {
			_initialValues.put(FieldNames.city, city);
		}
	}

	@EJFieldName("companyname")
	public String getCompanyname() {
		return _companyname;
	}

	@EJFieldName("companyname")
	public void setCompanyname(String companyname) {
		_companyname = companyname;
		if (!_initialValues.containsKey(FieldNames.companyname)) {
			_initialValues.put(FieldNames.companyname, companyname);
		}
	}

	@EJFieldName("country")
	public String getCountry() {
		return _country;
	}

	@EJFieldName("country")
	public void setCountry(String country) {
		_country = country;
		if (!_initialValues.containsKey(FieldNames.country)) {
			_initialValues.put(FieldNames.country, country);
		}
	}

	@EJFieldName("industry")
	public String getIndustry() {
		return _industry;
	}

	@EJFieldName("industry")
	public void setIndustry(String industry) {
		_industry = industry;
		if (!_initialValues.containsKey(FieldNames.industry)) {
			_initialValues.put(FieldNames.industry, industry);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getInitialValue(FieldNames<T> fieldName) {
		if (_initialValues.containsKey(fieldName)) {
			return (T) _initialValues.get(fieldName);
		} else {

			if (fieldName.equals(FieldNames.district)) {
				return (T) getDistrict();
			}
			if (fieldName.equals(FieldNames.authorisedcapital)) {
				return (T) getAuthorisedcapital();
			}
			if (fieldName.equals(FieldNames.cin)) {
				return (T) getCin();
			}
			if (fieldName.equals(FieldNames.contactemail)) {
				return (T) getContactemail();
			}
			if (fieldName.equals(FieldNames.city)) {
				return (T) getCity();
			}
			if (fieldName.equals(FieldNames.companyname)) {
				return (T) getCompanyname();
			}
			if (fieldName.equals(FieldNames.country)) {
				return (T) getCountry();
			}
			if (fieldName.equals(FieldNames.industry)) {
				return (T) getIndustry();
			}

			return null;
		}
	}

	public void clearInitialValues() {
		_initialValues.clear();

		_initialValues.put(FieldNames.district, _district);

		_initialValues.put(FieldNames.authorisedcapital, _authorisedcapital);

		_initialValues.put(FieldNames.cin, _cin);

		_initialValues.put(FieldNames.contactemail, _contactemail);

		_initialValues.put(FieldNames.city, _city);

		_initialValues.put(FieldNames.companyname, _companyname);

		_initialValues.put(FieldNames.country, _country);

		_initialValues.put(FieldNames.industry, _industry);
	}

	public static class FieldNames<T> {

		public static final FieldNames<java.lang.String> district = new FieldNames<>();
		public static final FieldNames<java.math.BigDecimal> authorisedcapital = new FieldNames<>();
		public static final FieldNames<java.lang.String> cin = new FieldNames<>();
		public static final FieldNames<java.lang.String> contactemail = new FieldNames<>();
		public static final FieldNames<java.lang.String> city = new FieldNames<>();
		public static final FieldNames<java.lang.String> companyname = new FieldNames<>();
		public static final FieldNames<java.lang.String> country = new FieldNames<>();
		public static final FieldNames<java.lang.String> industry = new FieldNames<>();
		T type;
	}

}
