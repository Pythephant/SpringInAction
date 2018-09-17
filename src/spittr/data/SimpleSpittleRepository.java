package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;
import spittr.util.SpittleUtil;

@Repository
public class SimpleSpittleRepository implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {

		List<Spittle> list = SpittleUtil.createTestSpittle(max, count);
		List<Spittle> returnSpittles = new ArrayList<>();
//		System.out.println(list.size());
		for (int i = list.size() - 1; i >= list.size() - count; i--) {
			returnSpittles.add(list.get((int) i));
		}
//		System.out.println(returnSpittles.size());
		return returnSpittles;
	}

}
