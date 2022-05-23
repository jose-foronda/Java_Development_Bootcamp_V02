package entities;

import java.util.Objects;

public class Document {
	
	private String type;
	private String number;
	
	public Document(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type is the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the document number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number is the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		return Objects.equals(number, other.number) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
//		return "Document [type=" + type + ", number=" + number + "]";
		return "" + type + number;
	}
	
}
