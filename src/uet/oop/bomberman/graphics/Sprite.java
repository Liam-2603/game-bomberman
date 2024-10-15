package uet.oop.bomberman.graphics;

import javafx.scene.image.*;

import java.awt.image.BufferedImage;
import java.nio.IntBuffer;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {
	
	public static final int DEFAULT_SIZE = 16;
	public static final int SCALED_SIZE = DEFAULT_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00ff;
	public final int SIZE;
	private int _x, _y;
	public int[] _pixels;
	protected int _realWidth;
	protected int _realHeight;
	private SpriteSheet _sheet;

	/*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
	public static Sprite grass = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite brick = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite wall = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite portal = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 14, 14);
	
	/*
	|--------------------------------------------------------------------------
	| Bomber Sprites
	|--------------------------------------------------------------------------
	 */
	public static Sprite player_up = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 12, 16);
	public static Sprite player_down = new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 12, 15);
	public static Sprite player_left = new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 10, 15);
	public static Sprite player_right = new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 10, 16);
	
	public static Sprite player_up_1 = new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.tiles, 12, 16);
	public static Sprite player_up_2 = new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.tiles, 12, 15);
	
	public static Sprite player_down_1 = new Sprite(DEFAULT_SIZE, 2, 1, SpriteSheet.tiles, 12, 15);
	public static Sprite player_down_2 = new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.tiles, 12, 16);
	
	public static Sprite player_left_1 = new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.tiles, 11, 16);
	public static Sprite player_left_2 = new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.tiles, 12 ,16);
	
	public static Sprite player_right_1 = new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 11, 16);
	public static Sprite player_right_2 = new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.tiles, 12, 16);
	
	public static Sprite player_dead1 = new Sprite(DEFAULT_SIZE, 4, 2, SpriteSheet.tiles, 14, 16);
	public static Sprite player_dead2 = new Sprite(DEFAULT_SIZE, 5, 2, SpriteSheet.tiles, 13, 15);
	public static Sprite player_dead3 = new Sprite(DEFAULT_SIZE, 6, 2, SpriteSheet.tiles, 16, 16);


	/*
	|--------------------------------------------------------------------------
	| Character
	|--------------------------------------------------------------------------
	 */
	//BALLOM
	public static Sprite balloom_left1 = new Sprite(DEFAULT_SIZE, 9, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite balloom_left2 = new Sprite(DEFAULT_SIZE, 9, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite balloom_left3 = new Sprite(DEFAULT_SIZE, 9, 2, SpriteSheet.tiles, 16, 16);
	
	public static Sprite balloom_right1 = new Sprite(DEFAULT_SIZE, 10, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite balloom_right2 = new Sprite(DEFAULT_SIZE, 10, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite balloom_right3 = new Sprite(DEFAULT_SIZE, 10, 2, SpriteSheet.tiles, 16, 16);
	
	public static Sprite balloom_dead = new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 16);
	
	//ONEAL
	public static Sprite oneal_left1 = new Sprite(DEFAULT_SIZE, 11, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite oneal_left2 = new Sprite(DEFAULT_SIZE, 11, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite oneal_left3 = new Sprite(DEFAULT_SIZE, 11, 2, SpriteSheet.tiles, 16, 16);
	
	public static Sprite oneal_right1 = new Sprite(DEFAULT_SIZE, 12, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite oneal_right2 = new Sprite(DEFAULT_SIZE, 12, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite oneal_right3 = new Sprite(DEFAULT_SIZE, 12, 2, SpriteSheet.tiles, 16, 16);
	
	public static Sprite oneal_dead = new Sprite(DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16);
	
	//Doll
	public static Sprite doll_left1 = new Sprite(DEFAULT_SIZE, 13, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite doll_left2 = new Sprite(DEFAULT_SIZE, 13, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite doll_left3 = new Sprite(DEFAULT_SIZE, 13, 2, SpriteSheet.tiles, 16, 16);
	
	public static Sprite doll_right1 = new Sprite(DEFAULT_SIZE, 14, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite doll_right2 = new Sprite(DEFAULT_SIZE, 14, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite doll_right3 = new Sprite(DEFAULT_SIZE, 14, 2, SpriteSheet.tiles, 16, 16);
	
	public static Sprite doll_dead = new Sprite(DEFAULT_SIZE, 13, 3, SpriteSheet.tiles, 16, 16);
	
	//Minvo
	public static Sprite minvo_left1 = new Sprite(DEFAULT_SIZE, 8, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite minvo_left2 = new Sprite(DEFAULT_SIZE, 8, 6, SpriteSheet.tiles, 16, 16);
	public static Sprite minvo_left3 = new Sprite(DEFAULT_SIZE, 8, 7, SpriteSheet.tiles, 16, 16);
	
	public static Sprite minvo_right1 = new Sprite(DEFAULT_SIZE, 9, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite minvo_right2 = new Sprite(DEFAULT_SIZE, 9, 6, SpriteSheet.tiles, 16, 16);
	public static Sprite minvo_right3 = new Sprite(DEFAULT_SIZE, 9, 7, SpriteSheet.tiles, 16, 16);
	
	public static Sprite minvo_dead = new Sprite(DEFAULT_SIZE, 8, 8, SpriteSheet.tiles, 16, 16);
	
	//Kondoria
	public static Sprite kondoria_left1 = new Sprite(DEFAULT_SIZE, 10, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite kondoria_left2 = new Sprite(DEFAULT_SIZE, 10, 6, SpriteSheet.tiles, 16, 16);
	public static Sprite kondoria_left3 = new Sprite(DEFAULT_SIZE, 10, 7, SpriteSheet.tiles, 16, 16);
	
	public static Sprite kondoria_right1 = new Sprite(DEFAULT_SIZE, 11, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite kondoria_right2 = new Sprite(DEFAULT_SIZE, 11, 6, SpriteSheet.tiles, 16, 16);
	public static Sprite kondoria_right3 = new Sprite(DEFAULT_SIZE, 11, 7, SpriteSheet.tiles, 16, 16);
	
	public static Sprite kondoria_dead = new Sprite(DEFAULT_SIZE, 10, 8, SpriteSheet.tiles, 16, 16);
	
	//ALL
	public static Sprite mob_dead1 = new Sprite(DEFAULT_SIZE, 15, 0, SpriteSheet.tiles, 16, 16);
	public static Sprite mob_dead2 = new Sprite(DEFAULT_SIZE, 15, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite mob_dead3 = new Sprite(DEFAULT_SIZE, 15, 2, SpriteSheet.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Bomb Sprites
	|--------------------------------------------------------------------------
	 */
	public static Sprite bomb = new Sprite(DEFAULT_SIZE, 0, 3, SpriteSheet.tiles, 15, 15);
	public static Sprite bomb_1 = new Sprite(DEFAULT_SIZE, 1, 3, SpriteSheet.tiles, 13, 15);
	public static Sprite bomb_2 = new Sprite(DEFAULT_SIZE, 2, 3, SpriteSheet.tiles, 12, 14);
	
	/*
	|--------------------------------------------------------------------------
	| FlameSegment Sprites
	|--------------------------------------------------------------------------
	 */
	public static Sprite bomb_exploded = new Sprite(DEFAULT_SIZE, 0, 4, SpriteSheet.tiles, 16, 16);
	public static Sprite bomb_exploded1 = new Sprite(DEFAULT_SIZE, 0, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite bomb_exploded2 = new Sprite(DEFAULT_SIZE, 0, 6, SpriteSheet.tiles, 16, 16);
	
	public static Sprite explosion_vertical = new Sprite(DEFAULT_SIZE, 1, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_vertical1 = new Sprite(DEFAULT_SIZE, 2, 5, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_vertical2 = new Sprite(DEFAULT_SIZE, 3, 5, SpriteSheet.tiles, 16, 16);
	
	public static Sprite explosion_horizontal = new Sprite(DEFAULT_SIZE, 1, 7, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_horizontal1 = new Sprite(DEFAULT_SIZE, 1, 8, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_horizontal2 = new Sprite(DEFAULT_SIZE, 1, 9, SpriteSheet.tiles, 16, 16);
	
	public static Sprite explosion_horizontal_left_last = new Sprite(DEFAULT_SIZE, 0, 7, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_horizontal_left_last1 = new Sprite(DEFAULT_SIZE, 0, 8, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_horizontal_left_last2 = new Sprite(DEFAULT_SIZE, 0, 9, SpriteSheet.tiles, 16, 16);
	
	public static Sprite explosion_horizontal_right_last = new Sprite(DEFAULT_SIZE, 2, 7, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_horizontal_right_last1 = new Sprite(DEFAULT_SIZE, 2, 8, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_horizontal_right_last2 = new Sprite(DEFAULT_SIZE, 2, 9, SpriteSheet.tiles, 16, 16);
	
	public static Sprite explosion_vertical_top_last = new Sprite(DEFAULT_SIZE, 1, 4, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_vertical_top_last1 = new Sprite(DEFAULT_SIZE, 2, 4, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_vertical_top_last2 = new Sprite(DEFAULT_SIZE, 3, 4, SpriteSheet.tiles, 16, 16);
	
	public static Sprite explosion_vertical_down_last = new Sprite(DEFAULT_SIZE, 1, 6, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_vertical_down_last1 = new Sprite(DEFAULT_SIZE, 2, 6, SpriteSheet.tiles, 16, 16);
	public static Sprite explosion_vertical_down_last2 = new Sprite(DEFAULT_SIZE, 3, 6, SpriteSheet.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Brick FlameSegment
	|--------------------------------------------------------------------------
	 */
	public static Sprite brick_exploded = new Sprite(DEFAULT_SIZE, 7, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite brick_exploded1 = new Sprite(DEFAULT_SIZE, 7, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite brick_exploded2 = new Sprite(DEFAULT_SIZE, 7, 3, SpriteSheet.tiles, 16, 16);
	
	/*
	|--------------------------------------------------------------------------
	| Powerups
	|--------------------------------------------------------------------------
	 */
	public static Sprite powerup_bombs = new Sprite(DEFAULT_SIZE, 0, 10, SpriteSheet.tiles, 16, 16);
	public static Sprite powerup_flames = new Sprite(DEFAULT_SIZE, 1, 10, SpriteSheet.tiles, 16, 16);
	public static Sprite powerup_speed = new Sprite(DEFAULT_SIZE, 2, 10, SpriteSheet.tiles, 16, 16);
	public static Sprite powerup_wallpass = new Sprite(DEFAULT_SIZE, 3, 10, SpriteSheet.tiles, 16, 16);
	public static Sprite powerup_detonator = new Sprite(DEFAULT_SIZE, 4, 10, SpriteSheet.tiles, 16, 16);
	public static Sprite powerup_bombpass = new Sprite(DEFAULT_SIZE, 5, 10, SpriteSheet.tiles, 16, 16);
	public static Sprite powerup_flamepass = new Sprite(DEFAULT_SIZE, 6, 10, SpriteSheet.tiles, 16, 16);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
		SIZE = size;
		_pixels = new int[SIZE * SIZE];
		_x = x * SIZE;
		_y = y * SIZE;
		_sheet = sheet;
		_realWidth = rw;
		_realHeight = rh;
		load();
	}

	public Sprite() {
		SIZE = 0;
	}

	public static Sprite sprite(String s) {
		switch (s) {
			case "balloom_dead":
				return balloom_dead;
			case "balloom_left1":
				return balloom_left1;
			case "balloom_left2":
				return balloom_left2;
			case "balloom_left3":
				return balloom_left3;
			case "balloom_right1":
				return balloom_right1;
			case "balloom_right2":
				return balloom_right2;
			case "balloom_right3":
				return balloom_right3;
			case "bomb":
				return bomb;
			case "bomb_1":
				return bomb_1;
			case "bomb_2":
				return bomb_2;
			case "bomb_exploded":
				return bomb_exploded;
			case "bomb_exploded1":
				return bomb_exploded1;
			case "bomb_exploded2":
				return bomb_exploded2;
			case "brick":
				return brick;
			case "brick_exploded":
				return brick_exploded;
			case "brick_exploded1":
				return brick_exploded1;
			case "brick_exploded2":
				return brick_exploded2;
			case "doll_dead":
				return doll_dead;
			case "doll_left1":
				return doll_left1;
			case "doll_left2":
				return doll_left2;
			case "doll_left3":
				return doll_left3;
			case "doll_right1":
				return doll_right1;
			case "doll_right2":
				return doll_right2;
			case "doll_right3":
				return doll_right3;
			case "explosion_horizontal":
				return explosion_horizontal;
			case "explosion_horizontal1":
				return explosion_horizontal1;
			case "explosion_horizontal2":
				return explosion_horizontal2;
			case "explosion_horizontal_left_last":
				return explosion_horizontal_left_last;
			case "explosion_horizontal_left_last1":
				return explosion_horizontal_left_last1;
			case "explosion_horizontal_left_last2":
				return explosion_horizontal_left_last2;
			case "explosion_horizontal_right_last":
				return explosion_horizontal_right_last;
			case "explosion_horizontal_right_last1":
				return explosion_horizontal_right_last1;
			case "explosion_horizontal_right_last2":
				return explosion_horizontal_right_last2;
			case "explosion_vertical":
				return explosion_vertical;
			case "explosion_vertical1":
				return explosion_vertical1;
			case "explosion_vertical2":
				return explosion_vertical2;
			case "explosion_vertical_down_last":
				return explosion_vertical_down_last;
			case "explosion_vertical_down_last1":
				return explosion_vertical_down_last1;
			case "explosion_vertical_down_last2":
				return explosion_vertical_down_last2;
			case "explosion_vertical_top_last":
				return explosion_vertical_top_last;
			case "explosion_vertical_top_last1":
				return explosion_vertical_top_last1;
			case "explosion_vertical_top_last2":
				return explosion_vertical_top_last2;
			case "grass":
				return grass;
			case "kondoria_dead":
				return kondoria_dead;
			case "kondoria_left1":
				return kondoria_left1;
			case "kondoria_left2":
				return kondoria_left2;
			case "kondoria_left3":
				return kondoria_left3;
			case "kondoria_right1":
				return kondoria_right1;
			case "kondoria_right2":
				return kondoria_right2;
			case "kondoria_right3":
				return kondoria_right3;
			case "minvo_dead":
				return minvo_dead;
			case "minvo_left1":
				return minvo_left1;
			case "minvo_left2":
				return minvo_left2;
			case "minvo_left3":
				return minvo_left3;
			case "minvo_right1":
				return minvo_right1;
			case "minvo_right2":
				return minvo_right2;
			case "minvo_right3":
				return minvo_right3;
			case "mob_dead1":
				return mob_dead1;
			case "mob_dead2":
				return mob_dead2;
			case "mob_dead3":
				return mob_dead3;
			case "oneal_dead":
				return oneal_dead;
			case "oneal_left1":
				return oneal_left1;
			case "oneal_left2":
				return oneal_left2;
			case "oneal_left3":
				return oneal_left3;
			case "oneal_right1":
				return oneal_right1;
			case "oneal_right2":
				return oneal_right2;
			case "oneal_right3":
				return oneal_right3;
			case "player_dead1":
				return player_dead1;
			case "player_dead2":
				return player_dead2;
			case "player_dead3":
				return player_dead3;
			case "player_down":
				return player_down;
			case "player_down_1":
				return player_down_1;
			case "player_down_2":
				return player_down_2;
			case "player_left":
				return player_left;
			case "player_left_1":
				return player_left_1;
			case "player_left_2":
				return player_left_2;
			case "player_right":
				return player_right;
			case "player_right_1":
				return player_right_1;
			case "player_right_2":
				return player_right_2;
			case "player_up":
				return player_up;
			case "player_up_1":
				return player_up_1;
			case "player_up_2":
				return player_up_2;
			case "portal":
				return portal;
			case "powerup_bombpass":
				return powerup_bombpass;
			case "powerup_bombs":
				return powerup_bombs;
			case "powerup_detonator":
				return powerup_detonator;
			case "powerup_flamepass":
				return powerup_flamepass;
			case "powerup_flames":
				return powerup_flames;
			case "powerup_speed":
				return powerup_speed;
			case "powerup_wallpass":
				return powerup_wallpass;
			case "wall":
				return wall;
		}
		return null;
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		_pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < _pixels.length; i++) {
			_pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				_pixels[x + y * SIZE] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
			}
		}
	}
	
	public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int time) {
		int calc = animate % time;
		int diff = time / 3;
		
		if(calc < diff) {
			return normal;
		}
			
		if(calc < diff * 2) {
			return x1;
		}
			
		return x2;
	}
	
	public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
		int diff = time / 2;
		return (animate % time > diff) ? x1 : x2; 
	}
	
	public int getSize() {
		return SIZE;
	}

	public int getPixel(int i) {
		return _pixels[i];
	}

	public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE, SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if ( _pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                }
                else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input, SCALED_SIZE / DEFAULT_SIZE);
    }

	private Image resample(Image input, int scaleFactor) {
		final int W = (int) input.getWidth();
		final int H = (int) input.getHeight();
		final int S = scaleFactor;

		WritableImage output = new WritableImage(
				W * S,
				H * S
		);

		PixelReader reader = input.getPixelReader();
		PixelWriter writer = output.getPixelWriter();

		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				final int argb = reader.getArgb(x, y);
				for (int dy = 0; dy < S; dy++) {
					for (int dx = 0; dx < S; dx++) {
						writer.setArgb(x * S + dx, y * S + dy, argb);
					}
				}
			}
		}

		return output;
	}
}
