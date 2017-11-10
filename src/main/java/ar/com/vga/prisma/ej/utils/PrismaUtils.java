package ar.com.vga.prisma.ej.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrismaUtils {

	private static final String DATE_PATTERN = "dd/MM/yyyy";

	public static DateFormat sdf() {
		return new SimpleDateFormat(DATE_PATTERN);
	}

	public static String format(Date date) {
		if (date != null) {
			return sdf().format(date);
		}
		return null;
	}

}
