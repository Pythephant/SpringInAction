package spittr.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spittr.domain.Spittle;

public class SpittleUtil {
	public static List<Spittle> createTestSpittle(long max, int count) {
		List<Spittle> spittleList = new ArrayList<Spittle>();
		for (long i = max - 2 * count; i < max; i++) {
			spittleList.add(new Spittle(i, "Spittle id " + i, new Date()));
		}
		// System.out.println(spittleList);
		return spittleList;
	}

	public static void main(String[] args) {
		List<Spittle> list = SpittleUtil.createTestSpittle(Long.MAX_VALUE, 20);
		for (Spittle sp : list) {
			System.out.println(sp);
		}
	}
}
