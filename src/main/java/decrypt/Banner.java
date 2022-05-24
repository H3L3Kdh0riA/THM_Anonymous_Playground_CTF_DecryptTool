package decrypt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

public class Banner {

	private static enum Color {
		BLUE_BLACK("\033[0;34m", "\033[40m"), RED_BLACK("\033[0;31m", "\033[40m");

		String font;
		String background;

		Color(String font, String background) {
			this.font = font;
			this.background = background;
		}

	}

	private static final String charcaters = "#*$*";

	private static final String RESET = "\033[0m";
	private static final int width = 130;
	private static final int height = 30;

	public void print() {

		try {
			Color color = getColor();
			System.out.print(color.background);
			System.out.print(color.font);

			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics graphcs = bufferedImage.getGraphics();
			Graphics2D graphics = (Graphics2D) graphcs;
			graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			graphics.drawString("H3L3Kdh0riA", 10, 20);
			String character = getCharacter();
			printAscii(bufferedImage, character);
		} catch (Exception e) {
			System.out.println("H3L3Kdh0riA Decrypt Tool");
		} finally {
			System.out.print(RESET);
			System.out.println();
		}
	}

	private void printAscii(BufferedImage bufferedImage, String character) {
		for (int yPos = 0; yPos < height; yPos++) {
			StringBuilder stringbuilder = new StringBuilder();
			for (int xPos = 0; xPos < width; xPos++) {
				stringbuilder.append(bufferedImage.getRGB(xPos, yPos) == -16777216 ? " " : character);

			}

			if (!stringbuilder.toString().isBlank()) {
				System.out.println(stringbuilder);
			}

		}
	}

	private Color getColor() {
		int index = new SecureRandom().nextInt(Color.values().length);
		return Color.values()[index];
	}

	private String getCharacter() {
		int index = new SecureRandom().nextInt(charcaters.length());
		return charcaters.substring(index, index + 1);
	}
}
