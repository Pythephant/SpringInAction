package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class SimpleSpittleRepository implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {

		List<Spittle> list = new ArrayList<>();
		list.add(new Spittle("FirstSpittle", new Date(System.currentTimeMillis())));
		list.add(new Spittle("SecondSp", new Date(System.currentTimeMillis())));
		return list;
	}

}
