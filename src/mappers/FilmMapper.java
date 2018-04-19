package mappers;

import java.util.List;

import com.mustafa.app.entity.Film;

public interface FilmMapper {

	Film selectById(int id);
	List<Film> getAll();
}
