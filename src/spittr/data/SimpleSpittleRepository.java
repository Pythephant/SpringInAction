package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;
import spittr.util.SpittleUtil;

@Repository
public class SimpleSpittleRepository implements SpittleRepository {

	private static ArrayList<Spittle> spittleRepo;

	static {
		spittleRepo = new ArrayList<>();
		/**
		 * assume the repository has 111 spittles from id 0 to 110
		 */
		for (int i = 0; i < 111; i++)
			spittleRepo.add(new Spittle((long) i, "Spittle " + i, new Date()));
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {

		List<Spittle> returnSpittles = new ArrayList<>();
//		System.out.println(list.size());
		int maxIndex = spittleRepo.size() - 1;
		for (; maxIndex >= 0; maxIndex--) {
			if (spittleRepo.get((int) maxIndex).getId() <= max)
				break;
		}
		for (int i = maxIndex; i > maxIndex - count && i >= 0; i--)
			returnSpittles.add(spittleRepo.get(i));
//		System.out.println(returnSpittles.size());
		return returnSpittles;
	}

	@Override
	public Spittle findOne(long id) {
		int lo = 0;
		int hi = spittleRepo.size() - 1;
		Spittle result = null;
		while (true) {
			int current = (lo + hi) / 2;
			if (current < lo || current > hi)
				break;
			long curId = spittleRepo.get(current).getId();
			if (curId == id)
				return spittleRepo.get(current);
			else if (curId < id)
				lo = current + 1;
			else
				hi = current - 1;
		}
		return result;
	}

}
