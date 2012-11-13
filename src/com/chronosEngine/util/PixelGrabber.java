package com.chronosEngine.util;

public class PixelGrabber {
	public static int grabPixel(int rr, int gg, int bb){
		return (0xff << 24 | rr << 16 | gg << 8 | bb);
	}
}
