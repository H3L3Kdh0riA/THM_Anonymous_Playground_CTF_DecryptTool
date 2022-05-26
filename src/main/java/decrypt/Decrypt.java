package decrypt;

import java.util.regex.Pattern;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class Decrypt {

	private static final String chars = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {

		new Banner().print();
		try {
			if (args.length != 1) {
				System.out.println("usage: ciphertext (encrypteduser::encryptedpassword)");
			}

			String ciphertext = args[0];
			if (ciphertext == null) {
				throw new NullPointerException("ciphertext is null");
			}

			String[] ciphertexts = ciphertext.toLowerCase().split("[:][:]");

			StringBuffer sb = new StringBuffer();
			boolean first = true;
			for (String part : ciphertexts) {
				if (first) {
					first = false;
				} else {
					sb.append(":");
				}
				sb.append(decode(part.trim()));
			}

			System.out.println("result: " + sb.toString());
		} catch (Exception e) {
			System.out.println();
		}
	}

	private static String decode(String ciphertext) throws InvalidAttributeIdentifierException, Exception {
		if (ciphertext.length() % 2 != 0) {
			throw new InvalidAttributeIdentifierException("Ciphertext size must be even");
		}

		Pattern p = Pattern.compile("^[0-9]+$");
		if (p.matcher(ciphertext).matches()) {
			throw new InvalidAttributeIdentifierException("Ciphertext must only consist of characters");
		}
		StringBuffer sb = new StringBuffer();
		int pointer = 0;

		while (pointer < ciphertext.length()) {

			char character1 = ciphertext.charAt(pointer);
			int intValue1 = chars.indexOf(character1);
			if (intValue1 < 0) {
				throw new Exception("Invalid character '" + character1 + "'at pos " + pointer);
			}

			pointer++;
			char character2 = ciphertext.charAt(pointer);
			int intValue2 = chars.indexOf(character2);

			if (intValue2 < 0) {
				throw new Exception("Invalid character '" + character2 + "'at pos " + pointer);
			}
			pointer++;

			int position = (intValue1 + intValue2 + 1) % chars.length();

			sb.append(chars.charAt(position));
		}
		return sb.toString();
	}

}
