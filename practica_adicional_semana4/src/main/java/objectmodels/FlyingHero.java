package objectmodels;

import java.util.Arrays;

public class FlyingHero extends Flyer {
	private byte age;
	private String[] abilities;
	private String birthday;
	private String actionGroup;
	
	public FlyingHero(String aName, SpatialPosition aSpatialPos, float aSpeed, String aSustType, byte age,
			String[] abilities, String birthday, String actionGroup) {
		super(aName, aSpatialPos, aSpeed, aSustType);
		this.age = age;
		this.abilities = abilities;
		this.birthday = birthday;
		this.actionGroup = actionGroup;
	}

	/**
	 * @return the actionGroup
	 */
	public String getActionGroup() {
		return actionGroup;
	}

	/**
	 * @param actionGroup the actionGroup to set
	 */
	public void setActionGroup(String actionGroup) {
		this.actionGroup = actionGroup;
	}

	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * @return the abilities
	 */
	public String[] getAbilities() {
		return abilities;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return "FlyingHero [toString()=" + super.toString() + ", age=" + age + ", abilities="
				+ Arrays.toString(abilities) + ", birthday=" + birthday + ", actionGroup=" + actionGroup + "]";
	}

}
