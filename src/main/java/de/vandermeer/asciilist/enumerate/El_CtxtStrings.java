package de.vandermeer.asciilist.enumerate;

import de.vandermeer.asciilist.AL_CtxtStrings;

public class El_CtxtStrings extends AL_CtxtStrings{

	/** A string to separate numbers, default is dot "'.'". */
	protected String numberingSeparator = ".";

	public El_CtxtStrings(){
		super();
	}

	/**
	 * Returns the numbering separator string.
	 * @return numbering separator string
	 */
	public String getNumberingSeparator() {
		return numberingSeparator;
	}

	/**
	 * Sets the numbering separator string.
	 * @param numberingSeparator label separator string
	 */
	public void setNumberingSeparator(String numberingSeparator) {
		this.numberingSeparator = numberingSeparator;
	}

	/**
	 * Copies all settings from the given object.
	 * @param object the object to copy settings from
	 */
	public void copySettings(El_CtxtStrings strings){
		this.numberingSeparator = strings.numberingSeparator;
	}

}
