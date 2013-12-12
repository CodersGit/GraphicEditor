package graphiceditor;


import java.net.URI;


public class Util
{
	public static String getPlatform() {
		return System.getProperty("os.name");
	}

	public static void openLink(URI uri) {
	try {
	Object o = Class.forName("java.awt.Desktop").getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
	o.getClass().getMethod("browse", new Class[] { URI.class }).invoke(o, new Object[] { uri });
	} catch (Throwable e) {
	out("Failed to open link " + uri.toString());
	}
	}
	private static int c = 0;
	public static void out(String mes) {
		c++;
		if (Constants.debug) System.out.println(c + "\t" + mes);
	}
}