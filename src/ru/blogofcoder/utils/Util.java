package ru.blogofcoder.utils;

import graphiceditor.Constants;

import java.net.URI;

public class Util {
	public static String getOS() {
		return System.getProperty("os.name");
	}

	public static class Math {
		public static int exponentiation(int a, int i) {
			int r = 1;
			for (; i > 0; i--)
				r *= a;
			return r;
		}

		public static int ex(int a, int i) {
			return exponentiation(a, i);
		}
	}

	public static void openLink(URI uri) {
		try {
			Object o = Class.forName("java.awt.Desktop")
					.getMethod("getDesktop", new Class[0])
					.invoke(null, new Object[0]);
			o.getClass().getMethod("browse", new Class[] { URI.class })
					.invoke(o, new Object[] { uri });
		} catch (Throwable e) {
			out("Failed to open link " + uri.toString());
		}
	}

	private static int c = 0;

	public static void out(String mes) {
		c++;
		if (Constants.debug)
			System.out.println(c + "\t" + mes);
	}
}