package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.config.ConfigUtil;
import com.palmergames.bukkit.config.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: Chris H (Zren / Shade)
 * Date: 7/10/12
 */
public class TownLevel extends Level {
	@Node(key="numResidents")
	private int minNumResidentsRequired = 0;

	@Node(key="namePrefix")
	private String namePrefix = "";

	@Node(key="namePostfix")
	private String nameSuffix = "";

	@Node(key="mayorPrefix")
	private String mayorNamePrefix = "";

	@Node(key="mayorPostfix")
	private String mayorNameSuffix = "";

	@Node(key="townBlockLimit")
	private int townBlockLimit = 0;

	@Node(key="upkeepModifier")
	private double serverUpkeepModifier = 1.0;

	public int getMinNumResidentsRequired() {
		return minNumResidentsRequired;
	}

	public void setMinNumResidentsRequired(int minNumResidentsRequired) {
		this.minNumResidentsRequired = minNumResidentsRequired;
	}

	public String getNamePrefix() {
		return namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getMayorNamePrefix() {
		return mayorNamePrefix;
	}

	public void setMayorNamePrefix(String mayorNamePrefix) {
		this.mayorNamePrefix = mayorNamePrefix;
	}

	public String getMayorNameSuffix() {
		return mayorNameSuffix;
	}

	public void setMayorNameSuffix(String mayorNameSuffix) {
		this.mayorNameSuffix = mayorNameSuffix;
	}

	public int getTownBlockLimit() {
		return townBlockLimit;
	}

	public void setTownBlockLimit(int townBlockLimit) {
		this.townBlockLimit = townBlockLimit;
	}

	public double getServerUpkeepModifier() {
		return serverUpkeepModifier;
	}

	public void setServerUpkeepModifier(double serverUpkeepModifier) {
		this.serverUpkeepModifier = serverUpkeepModifier;
	}

	@Override
	public int getLevel() {
		return getMinNumResidentsRequired();
	}

	public static TownLevel deserialize(Map<String, Object> args) {
		return (TownLevel) ConfigUtil.deserialize(TownLevel.class, args);
	}

	public static Set<TownLevel> DEFAULT_TOWN_LEVELS = new HashSet<TownLevel>();

	@Override
	public Set<? extends Level> getDefaults() {
		return DEFAULT_TOWN_LEVELS;
	}

	static {
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(0);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" Ruins");
			townLevel.setMayorNamePrefix("Spirit ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(1);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(1);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Settlement)");
			townLevel.setMayorNamePrefix("Hermit ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(16);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(2);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Hamlet)");
			townLevel.setMayorNamePrefix("Chief ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(32);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(6);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Village)");
			townLevel.setMayorNamePrefix("Baron Von ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(96);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(10);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Town)");
			townLevel.setMayorNamePrefix("Viscount ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(160);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(14);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Large Town)");
			townLevel.setMayorNamePrefix("Count Von ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(224);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(20);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (City)");
			townLevel.setMayorNamePrefix("Earl ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(320);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(24);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Large City)");
			townLevel.setMayorNamePrefix("Duke ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(384);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}

		{
			TownLevel townLevel = new TownLevel();
			townLevel.setMinNumResidentsRequired(28);
			townLevel.setNamePrefix("");
			townLevel.setNameSuffix(" (Metropolis)");
			townLevel.setMayorNamePrefix("Lord ");
			townLevel.setMayorNameSuffix("");
			townLevel.setTownBlockLimit(448);
			townLevel.setServerUpkeepModifier(1.0);
			DEFAULT_TOWN_LEVELS.add(townLevel);
		}
	}
}
