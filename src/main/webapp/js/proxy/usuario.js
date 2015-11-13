var UsuarioProxy = {

	url : "api/usuario",

	findAll : function() {
		return $.ajax({
			type : "GET",
			url : this.url,
			/*beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}*/
		});
	},

	load : function(id) {
		return $.ajax({
			type : "GET",
			url : this.url + "/" + id,
			/*beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}*/
		});
	},

	insert : function(usuario) {
		return $.ajax({
			type : "POST",
			url : this.url,
			data : JSON.stringify(usuario),
			contentType : "application/json",
		});
	},

	update : function(id, usuario) {
		return $.ajax({
			type : "PUT",
			url : this.url + "/" + id,
			data : JSON.stringify(usuario),
			contentType : "application/json",
		});
	},

	remove : function(ids) {
		return $.ajax({
			type : "DELETE",
			url : this.url,
			data : JSON.stringify(ids),
			contentType : "application/json",
			/*beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}*/
		});
	}
};