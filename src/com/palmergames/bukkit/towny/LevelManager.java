package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;

/**
 * Author: Chris H (Zren / Shade)
 * Date: 7/10/12
 */
public class LevelManager {
	private static TownLevel DEFAULT_TOWN_LEVEL =  new TownLevel();
	private static NationLevel DEFAULT_NATION_LEVEL =  new NationLevel();

	private static LevelManager instance;

	static {
		newInstance();
	}

	public static LevelManager getInstance() {
		return instance;
	}

	public static void newInstance() {
		instance = new LevelManager();
		instance.getTownLevelSet().addLevel(DEFAULT_TOWN_LEVEL);
		instance.getNationLevelSet().addLevel(DEFAULT_NATION_LEVEL);
	}

	private LevelSet<TownLevel> townLevelSet = new LevelSet<TownLevel>(TownLevel.class);
	private LevelSet<NationLevel> nationLevelSet = new LevelSet<NationLevel>(NationLevel.class);

	/* Town */

	public TownLevel getTownLevel(Town town) {
		int n = town.getNumResidents();
		return townLevelSet.getLevel(n);
	}

	public LevelSet<TownLevel> getTownLevelSet() {
		return townLevelSet;
	}

	/* Nation */

	public NationLevel getNationLevel(Nation nation) {
		int n = nation.getNumResidents();
		return nationLevelSet.getLevel(n);
	}

	public LevelSet<NationLevel> getNationLevelSet() {
		return nationLevelSet;
	}
}
