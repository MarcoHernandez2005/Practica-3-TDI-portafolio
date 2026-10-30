package com.ejemplo.portafolio.repository;

import com.ejemplo.portafolio.model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProyectoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Proyecto> rowMapper = new RowMapper<Proyecto>() {
        @Override
        public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Proyecto(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("tecnologias"),
                    rs.getString("enlace_github")
            );
        }
    };

    public List<Proyecto> findAll() {
        String sql = "SELECT * FROM proyecto";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Proyecto findById(Integer id) {
        String sql = "SELECT * FROM proyecto WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public int save(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (titulo, descripcion, tecnologias, enlace_github) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, proyecto.getTitulo(), proyecto.getDescripcion(), 
                                   proyecto.getTecnologias(), proyecto.getEnlaceGithub());
    }

    public int update(Proyecto proyecto) {
        String sql = "UPDATE proyecto SET titulo = ?, descripcion = ?, tecnologias = ?, enlace_github = ? WHERE id = ?";
        return jdbcTemplate.update(sql, proyecto.getTitulo(), proyecto.getDescripcion(), 
                                   proyecto.getTecnologias(), proyecto.getEnlaceGithub(), proyecto.getId());
    }

    public int deleteById(Integer id) {
        String sql = "DELETE FROM proyecto WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}