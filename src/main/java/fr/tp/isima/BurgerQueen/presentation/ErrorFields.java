package fr.tp.isima.BurgerQueen.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import fr.tp.isima.BurgerQueen.common.AbstractUnsupportedOperationMap;
import fr.tp.isima.BurgerQueen.persistence.UniqueConstraintException;

/**
 * Cette classe permet de gerer simplement l'affichage des champs avec la jsp.
 * <ul>
 * <li>Il permet d'afficer les valeurs des champs et les eventuels messages</li>
 * </ul>
 * 
 * @author Benjamin
 *
 */
public class ErrorFields extends AbstractUnsupportedOperationMap<String, Field> {

	private final Map<String, Field> fieldsInErrors;

	private ErrorFields(Map<String, Field> infos) {
		fieldsInErrors = infos;

	}

	@Override
	public Field get(Object name) {
		if (fieldsInErrors.containsKey(name)) {
			return fieldsInErrors.get(name);
		}
		return Field.success((String) name);
	}

	public static ErrorFieldsBuilder newErrorBuilder() {
		return new ErrorFieldsBuilder();
	}

	public static class ErrorFieldsBuilder {
		private final Map<String, Field> errorsFields = new HashMap<String, Field>();

		public ErrorFields build() {
			return new ErrorFields(errorsFields);
		}

		public ErrorFieldsBuilder addField(String name, String msg) {
			errorsFields.put(name, Field.errorField(name, msg));
			return this;
		}

		/**
		 * Les contraintes uniques n'�tant pas g�r�es en standard cette m�thode
		 * permet de construire les champs en erreurs avec une
		 * {@link UniqueConstraintException}
		 * 
		 * @param e
		 * @return
		 */

		public ErrorFieldsBuilder addErrorWithUniqueContraintException(UniqueConstraintException e) {
			errorsFields.put(e.getFieldName(), Field.errorField(e.getFieldName(), "Impossible d'utiliser cette valeur elle existe d�j�"));
			return this;
		}

		/**
		 * Cr�er un objet de champ d'erreur � partir des erreurs de bean
		 * validation standard
		 * 
		 * @param violations
		 * @return
		 */
		public ErrorFieldsBuilder addErrorsWithUniquesContraintsExceptions(Iterable<ConstraintViolation<?>> violations) {
			violations.forEach((constraint) -> addField(constraint.getPropertyPath().toString(), constraint.getMessage()));
			return this;
		}

		public ErrorFieldsBuilder addErrorWithUniqueContraintException(ConstraintViolationException e) {
			return addErrorsWithUniquesContraintsExceptions(e.getConstraintViolations());
		}

	}
}
