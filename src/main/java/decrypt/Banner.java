package decrypt;

import java.awt.Font;
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

	private static final String BANNER_TITLE = "H3L3Kdh0riA";

	private static final String BANNER_SUBITITLE = "THM DecryPt";
	private static final String BANNER_SUBITITLE2 = "Tool";
	private static final String charcaters = "#$";

	private static final String RESET = "\033[0m";
	private static final int width = 150;
	private static final int height_banner = 30;
	private static final int height_subbanner = 20;
	private static final int fontsize_banner = 12;
	private static final int fontsize_subbanner = 15;

	public void print() {

		try {
			String character = getCharacter();
			Color color = getColor();
			System.out.print(color.background);
			System.out.print(color.font);
			printBanner(BANNER_TITLE, width, height_banner, fontsize_banner, character);
			System.out.println();
			printBanner(BANNER_SUBITITLE, width, height_subbanner, fontsize_subbanner, character);
			System.out.println();
			printBanner(BANNER_SUBITITLE2, width, height_subbanner, fontsize_subbanner, character);
		} catch (Exception e) {
			System.out.println(BANNER_TITLE + " " + BANNER_SUBITITLE + " " + BANNER_TITLE);
		} finally {
			System.out.print(RESET);
			System.out.println();
		}
	}

	private void printBanner(String text, int width, int height, int fontsize, String character) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics graphics = bufferedImage.getGraphics();
		graphics.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, fontsize));
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2d.drawString(text, 10, 20);

		printAscii(bufferedImage, character, height);
	}

	private void printAscii(BufferedImage bufferedImage, String character, int height) {
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
