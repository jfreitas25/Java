/*
 * Project Euler #116
 * http://projecteuler.net/problem=116
 * 
 * "A row of five black square tiles is to have a number of its tiles replaced with coloured oblong 
 * tiles chosen from red (length two), green (length three), or blue (length four).
 * 
 * Assuming that colours cannot be mixed there are 7 + 3 + 2 = 12 ways of replacing the black tiles 
 * in a row measuring five units in length.
 * 
 * How many different ways can the black tiles in a row measuring fifty units in length be replaced 
 * if colours cannot be mixed and at least one coloured tile must be used?"
 */

package rgbtiles116;

public class RGBTiles {
	
	public static double factorial(double x) {
		double result;
		if(x == 0) {
			result = 1;
		}
		else {
			result = x * factorial(x-1); 
		}
		return result;
	}
	
	public static double choose(double n,double r) {
		double result;
		result = factorial(n)/(factorial(r)*factorial(n-r));
		return result;
	}
	
	public static double redTiles(int n) {
		double reds = 0;
		int i = 1;
		n -= 1;
		while(i <= n){
			reds += choose(n, i);
			n -= 1;
			i++;
		}
		return reds;
	}
	
	public static double greenTiles(int n) {
		double greens = 0;
		n -= 2;
		int i = 1;
		while(i <= n){
			greens += choose(n, i);
			n -= 2;
			i++;
		}
		return greens;
	}
	
	public static double blueTiles(int n) {
		double blues = 0;
		n -= 3;
		int i = 1;
		while(i <= n){
			blues += choose(n, i);
			n -= 3;
			i++;
		}
		return blues;
	}
	
	public static double rgbTiles(int n){
		double tiles = redTiles(n) + blueTiles(n) + greenTiles(n);
		return tiles;
	}

	public static void main(String[] args){
		int target = 50;
		System.out.println(rgbTiles(target));
	}
	
}