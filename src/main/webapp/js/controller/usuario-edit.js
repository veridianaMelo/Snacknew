
$(function() {
	$("#delete").hide();

	if (id = App.getUrlParameterByName('id')) {
		UsuarioProxy.load(id).done(loadOk).fail(loadFailed);
	}

	MetadataProxy.getDemoiselleVersion().done(function(data) {
		$("#demoiselle-version").html(data);
	});

	$("form").submit(function(event) {
		event.preventDefault();
	});	
	$("#save").click(function() {
	var data = {

			nome : $("#nome").val(),

			email : $("#email").val(),

			senha : $("#senha").val(),

			seat : $("#seat").val(),

		};
		if (id = $("#id").val()) {
			UsuarioProxy.update(id, data).done(saveOk).fail(saveFailed);
		} else {
			UsuarioProxy.insert(data).done(saveOk).fail(saveFailed);
		}
	});

	$("#delete").click(function() {
		bootbox.confirm("Tem certeza que deseja apagar?", function(result) {
			if (result) {
				UsuarioProxy.remove([ $("#id").val() ]).done(removeOk);
			}
		});
	});

	$("#back").click(function() {
		history.back();
	});



});

function loadOk(data) {
	$("#id-row").show();
	$("#id-text").html(data.id);
	$("#id").val(data.id);
	
	$("#id").val(data.id);

	$("#nome").val(data.nome);

	$("#email").val(data.email);

	$("#senha").val(data.senha);

	$("#seat").val(data.seat);
	
	$("#delete").show();
}

function loadFailed(request) {
	switch (request.status) {
		case 404:
			bootbox.alert("Você está tentando acessar um registro inexistente!", function() {
				location.href = "usuario-list.html";
			});
			break;

		default:
			break;
	}
}

function saveOk(data) {
	location.href = 'usuario-list.html';
}

function saveFailed(request) {
	switch (request.status) {
		case 422:
			$($("form input").get().reverse()).each(function() {
				var id = $(this).attr('id');
				var message = null;

				$.each(request.responseJSON, function(index, value) {
					if (id == value.property) {
						message = value.message;
						return;
					}
				});

				if (message) {
					$("#" + id + "-message").html(message).show();
					$(this).focus();
				} else {
					$("#" + id + "-message").hide();
				}
			});
			break;
		default:
			break;
	}
}
function removeOk(data) {
	location.href = 'usuario-list.html';
}