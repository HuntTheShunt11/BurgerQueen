function addIngredient() {
	var s = $('#ingredientSelector');
	
	var il = $('#ingredientsList');
	
	if(!il.find('input').filter(function(){ return this.value == s.val(); }).length)
		il.append(
			'<li class="list-group-item">' +
			'<input type="hidden" name="ingredients[]" value="' + s.val() + '" />' +
			'<button type="button" class="btn btn-danger" style="margin-right: 16px;"' +
			'onclick="javascript:removeIngredient(this);"' +
			'>X</button>' +
			s.children(':selected').text() +
			'</li>'
		);
}

function removeIngredient(button) {
	button.closest('li').remove();
}
