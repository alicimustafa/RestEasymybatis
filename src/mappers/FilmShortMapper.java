package mappers;

import java.util.List;

import com.mustafa.app.dto.Page;
import com.mustafa.app.entity.FilmShort;

public interface FilmShortMapper {
	List<FilmShort> AllpageOrder(Page page);
	List<FilmShort> AllpageOrderRatingAsc(int page);
	List<FilmShort> AllpageOrderRatingDesc(int page);
	
}
