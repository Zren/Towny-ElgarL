package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.config.ConfigUtil;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

/**
 * Author: Chris H (Zren / Shade)
 * Date: 7/12/12
 */
public class LevelSet<T extends Level> {
	SortedSet<T> levels = new TreeSet<T>(Collections.reverseOrder());
	Class<T> clazz;

	public LevelSet(Class<T> clazz) {
		this.clazz = clazz;
	}

	public LevelSet(Class<T> clazz, List<Map<String, Object>> mapList) {
		this(clazz);
		deserialize(mapList);
	}

	public void addLevel(T level) {
		// Since equals() only checks the calculated level, and not all fields, the objects are considered the same.
		// So we need to manually remove the old one first, otherwise .add() won't do anything.
		//if (levels.contains(level))
		//	levels.remove(level);
		levels.add(level);
	}

	public T getLevel(int n) {
		for (T level : levels)
			if (n >= level.getLevel())
				return level;


		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public SortedSet<T> getLevels() {
		return levels;
	}

	public List<Map<String, Object>> serialize() {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		// Use new instance of TreeSet to serialize in ascending order.
		for (Level level : new TreeSet<Level>(levels)) {
			mapList.add(ConfigUtil.serialize(level));
		}
		return mapList;
	}

	private void deserialize(List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			addLevel(clazz.cast(ConfigUtil.deserialize(clazz, map)));
		}
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
