package minicraft.level.tile;

import minicraft.Game;
import minicraft.entity.Entity;
import minicraft.entity.ItemEntity;
import minicraft.entity.Mob;
import minicraft.entity.Player;
import minicraft.gfx.Color;
import minicraft.gfx.Screen;
import minicraft.item.Item;
import minicraft.item.ResourceItem;
import minicraft.item.ToolItem;
import minicraft.item.ToolType;
import minicraft.item.resource.Resource;
import minicraft.level.Level;
import minicraft.sound.Sound;

public class WoodDoorClosedTile extends Tile {
	public WoodDoorClosedTile(int id) {
		super(id);
	}

	public void render(Screen screen, Level level, int x, int y) {

		int col0 = Color.get(210, 320, 100, 320);

		int col1 = Color.get(320, 430, 210, 430);

		int col2 = Color.get(210, 320, 100, 320);

		int col3 = Color.get(100, 210, 000, 210);

		int col4 = Color.get(320, 430, 210, 430);

		if (level.dirtColor == 322) {

			if (Game.time == 0) {

				int col = col0;
				screen.render(x * 16 + 0, y * 16 + 0, 2 + 22 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 0, 3 + 22 * 32, col, 0);
				screen.render(x * 16 + 0, y * 16 + 8, 2 + 23 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 8, 3 + 23 * 32, col, 0);
			}
			if (Game.time == 1) {

				int col = col1;
				screen.render(x * 16 + 0, y * 16 + 0, 2 + 22 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 0, 3 + 22 * 32, col, 0);
				screen.render(x * 16 + 0, y * 16 + 8, 2 + 23 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 8, 3 + 23 * 32, col, 0);
			}
			if (Game.time == 2) {

				int col = col2;
				screen.render(x * 16 + 0, y * 16 + 0, 2 + 22 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 0, 3 + 22 * 32, col, 0);
				screen.render(x * 16 + 0, y * 16 + 8, 2 + 23 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 8, 3 + 23 * 32, col, 0);
			}
			if (Game.time == 3) {

				int col = col3;
				screen.render(x * 16 + 0, y * 16 + 0, 2 + 22 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 0, 3 + 22 * 32, col, 0);
				screen.render(x * 16 + 0, y * 16 + 8, 2 + 23 * 32, col, 0);
				screen.render(x * 16 + 8, y * 16 + 8, 3 + 23 * 32, col, 0);
			}
		}
		if (level.dirtColor == 222) {
			int col = col4;
			screen.render(x * 16 + 0, y * 16 + 0, 0 + 22 * 32, col, 0);
			screen.render(x * 16 + 8, y * 16 + 0, 1 + 22 * 32, col, 0);
			screen.render(x * 16 + 0, y * 16 + 8, 0 + 23 * 32, col, 0);
			screen.render(x * 16 + 8, y * 16 + 8, 1 + 23 * 32, col, 0);
		}
	}

	public boolean interact(Level level, int xt, int yt, Player player, Item item, int attackDir) {
		if (item instanceof ToolItem) {
			ToolItem tool = (ToolItem) item;
			if (tool.type == ToolType.axe) {
				if (player.payStamina(4 - tool.level)) {
					level.setTile(xt, yt, Tile.plank, 0);
					level.add(
							new ItemEntity(
									new ResourceItem(Resource.wdoor),
									xt * 16 + random.nextInt(10) + 3,
									yt * 16 + random.nextInt(10) + 3));
					Sound.monsterHurt.play();
					return true;
				}
			}
			if (tool.type == ToolType.hatchet) {
				if (player.payStamina(4 - tool.level)) {
					level.setTile(xt, yt, Tile.plank, 0);
					level.add(
							new ItemEntity(
									new ResourceItem(Resource.wdoor),
									xt * 16 + random.nextInt(10) + 3,
									yt * 16 + random.nextInt(10) + 3));
					Sound.monsterHurt.play();
					return true;
				}
			}
		}
		return false;
	}

	public void hurt(Level level, int x, int y, Mob source, int dmg, int attackDir) {
		level.setTile(x, y, Tile.wdo, 0);
	}

	public boolean mayPass(Level level, int x, int y, Entity e) {
		return false;
	}
}