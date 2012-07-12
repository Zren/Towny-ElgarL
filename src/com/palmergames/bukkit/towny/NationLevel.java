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
public class NationLevel extends Level {
	@Node(key="numResidents")
	private int minNumResidentsRequired = 0;

	@Node(key="namePrefix")
	private String namePrefix = "";

	@Node(key="namePostfix")
	private String nameSuffix = "";

	@Node(key="capitalPrefix")
	private String capitalNamePrefix = "";

	@Node(key="capitalPostfix")
	private String capitalNameSuffix = "";

	@Node(key="kingPrefix")
	private String kingNamePrefix = "";

	@Node(key="kingPostfix")
	private String kingNameSuffix = "";

	@Node(key="townBlockLimitBonus")
	private int bonusTownBlockLimit = 0;

	@Node(key="upkeepModifier")
	private double serverUpkeepModifier = 0;

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

	public String getCapitalNamePrefix() {
		return capitalNamePrefix;
	}

	public void setCapitalNamePrefix(String capitalNamePrefix) {
		this.capitalNamePrefix = capitalNamePrefix;
	}

	public String getCapitalNameSuffix() {
		return capitalNameSuffix;
	}

	public void setCapitalNameSuffix(String capitalNameSuffix) {
		this.capitalNameSuffix = capitalNameSuffix;
	}

	public String getKingNamePrefix() {
		return kingNamePrefix;
	}

	public void setKingNamePrefix(String kingNamePrefix) {
		this.kingNamePrefix = kingNamePrefix;
	}

	public String getKingNameSuffix() {
		return kingNameSuffix;
	}

	public void setKingNameSuffix(String kingNameSuffix) {
		this.kingNameSuffix = kingNameSuffix;
	}

	public int getBonusTownBlockLimit() {
		return bonusTownBlockLimit;
	}

	public void setBonusTownBlockLimit(int bonusTownBlockLimit) {
		this.bonusTownBlockLimit = bonusTownBlockLimit;
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

	public static NationLevel deserialize(Map<String, Object> args) {
		return (NationLevel) ConfigUtil.deserialize(NationLevel.class, args);
	}

	public static Set<NationLevel> DEFAULT_NATION_LEVELS = new HashSet<NationLevel>();

	@Override
	public Set<? extends Level> getDefaults() {
		return DEFAULT_NATION_LEVELS;
	}

	static {
		{
			NationLevel nationLevel = new NationLevel();
			nationLevel.setMinNumResidentsRequired(0);
			nationLevel.setNamePrefix("Land of ");
			nationLevel.setNameSuffix(" (Nation)");
			nationLevel.setCapitalNamePrefix("");
			nationLevel.setCapitalNameSuffix("");
			nationLevel.setKingNamePrefix("Leader ");
			nationLevel.setKingNameSuffix("");
			nationLevel.setBonusTownBlockLimit(10);
			nationLevel.setServerUpkeepModifier(1.0);
			DEFAULT_NATION_LEVELS.add(nationLevel);
		}
		{
			NationLevel nationLevel = new NationLevel();
			nationLevel.setMinNumResidentsRequired(10);
			nationLevel.setNamePrefix("Federation of ");
			nationLevel.setNameSuffix(" (Nation)");
			nationLevel.setCapitalNamePrefix("");
			nationLevel.setCapitalNameSuffix("");
			nationLevel.setKingNamePrefix("Count ");
			nationLevel.setKingNameSuffix("");
			nationLevel.setBonusTownBlockLimit(20);
			nationLevel.setServerUpkeepModifier(1.0);
			DEFAULT_NATION_LEVELS.add(nationLevel);
		}
		{
			NationLevel nationLevel = new NationLevel();
			nationLevel.setMinNumResidentsRequired(20);
			nationLevel.setNamePrefix("Dominion of ");
			nationLevel.setNameSuffix(" (Nation)");
			nationLevel.setCapitalNamePrefix("");
			nationLevel.setCapitalNameSuffix("");
			nationLevel.setKingNamePrefix("Duke ");
			nationLevel.setKingNameSuffix("");
			nationLevel.setBonusTownBlockLimit(40);
			nationLevel.setServerUpkeepModifier(1.0);
			DEFAULT_NATION_LEVELS.add(nationLevel);
		}
		{
			NationLevel nationLevel = new NationLevel();
			nationLevel.setMinNumResidentsRequired(30);
			nationLevel.setNamePrefix("Kingdom of ");
			nationLevel.setNameSuffix(" (Nation)");
			nationLevel.setCapitalNamePrefix("");
			nationLevel.setCapitalNameSuffix("");
			nationLevel.setKingNamePrefix("King ");
			nationLevel.setKingNameSuffix("");
			nationLevel.setBonusTownBlockLimit(60);
			nationLevel.setServerUpkeepModifier(1.0);
			DEFAULT_NATION_LEVELS.add(nationLevel);
		}
		{
			NationLevel nationLevel = new NationLevel();
			nationLevel.setMinNumResidentsRequired(40);
			nationLevel.setNamePrefix("The ");
			nationLevel.setNameSuffix(" Empire");
			nationLevel.setCapitalNamePrefix("");
			nationLevel.setCapitalNameSuffix("");
			nationLevel.setKingNamePrefix("Emperor ");
			nationLevel.setKingNameSuffix("");
			nationLevel.setBonusTownBlockLimit(100);
			nationLevel.setServerUpkeepModifier(1.0);
			DEFAULT_NATION_LEVELS.add(nationLevel);
		}
		{
			NationLevel nationLevel = new NationLevel();
			nationLevel.setMinNumResidentsRequired(60);
			nationLevel.setNamePrefix("The ");
			nationLevel.setNameSuffix(" Realm");
			nationLevel.setCapitalNamePrefix("");
			nationLevel.setCapitalNameSuffix("");
			nationLevel.setKingNamePrefix("God Emperor ");
			nationLevel.setKingNameSuffix("");
			nationLevel.setBonusTownBlockLimit(140);
			nationLevel.setServerUpkeepModifier(1.0);
			DEFAULT_NATION_LEVELS.add(nationLevel);
		}
	}
}
