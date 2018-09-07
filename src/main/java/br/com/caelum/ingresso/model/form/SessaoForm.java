package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	private Integer salaId;
	
	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;

	@NotNull
	private Integer filmeId;
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao){
			
		return new Sessao(horario, filmeDao.findOne(filmeId), salaDao.findOne(salaId));
	}

}