package fr.tp.isima.BurgerQueen.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.tp.isima.BurgerQueen.Note;

@Entity(name = "Burger")
@Table(name = "Burger")
public class BurgerBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Nom obligatoire")
	@Column(unique = true)
	private String nom;

	@Column
	@Size(max = 250, message = "La description doit faire moins de 250 caracteres")
	private String description;

	@ManyToMany
	@NotNull
	private List<IngredientBean> ingredients = new ArrayList<>();

	@Column
	public final Note orig = new Note();

	@Column
	public final Note qual = new Note();

	@Column
	public final Note pres = new Note();

	@Column
	public final Note gout = new Note();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public List<IngredientBean> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientBean> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(IngredientBean ingredient) {
		ingredients.add(ingredient);
	}
}
