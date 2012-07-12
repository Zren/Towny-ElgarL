package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.config.ConfigUtil;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.Map;
import java.util.Set;

/**
 * Author: Chris H (Zren / Shade)
 * Date: 7/10/12
 */
public abstract class Level implements Comparable<Level>, ConfigurationSerializable {
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public int compareTo(Level aThat) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		// This optimization is usually worthwhile, and can always be added
		if (this == aThat) return EQUAL;

		// Primitive numbers follow this form
		if (this.getLevel() < aThat.getLevel()) return BEFORE;
		if (this.getLevel() > aThat.getLevel()) return AFTER;

		// All comparisons have yielded equality
		// Verify that compareTo is consistent with equals (optional)

		//
		//assert this.equals(aThat) : "compareTo inconsistent with equals.";

		return EQUAL;
	}

	public abstract int getLevel();

	@Override
	public Map<String, Object> serialize() {
		return ConfigUtil.serialize(this);
	}

	public abstract Set<? extends Level> getDefaults();
}
