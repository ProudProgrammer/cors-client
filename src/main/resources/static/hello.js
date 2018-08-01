$(document).ready(function() {
	$.ajax({
		url : "http://localhost:8080/greeting"
	}).then(function(data, status, jqxhr) {
		$('.greeting-id').append(data.id);
		$('.greeting-content').append(data.content);
		$('.status').append(jqxhr.status);
		console.log(jqxhr);
	}).fail(function(data, textStatus, xhr){
		$('.status').append(data.status);
	});;
	$.ajax({
		url : "http://localhost:8080/greetingCorsOriginAll"
	}).then(function(data, status, jqxhr) {
		$('.greeting-id-cors-origin-all').append(data.id);
		$('.greeting-content-cors-origin-all').append(data.content);
		$('.status-cors-origin-all').append(jqxhr.status);
		console.log(jqxhr);
	}).fail(function(data, textStatus, xhr){
		$('.status-cors-origin-9001').append(data.status);
	});
	$.ajax({
		url : "http://localhost:8080/greetingCorsOrigin9000"
	}).then(function(data, status, jqxhr) {
		$('.greeting-id-cors-origin-9000').append(data.id);
		$('.greeting-content-cors-origin-9000').append(data.content);
		$('.status-cors-origin-9000').append(jqxhr.status);
		console.log(jqxhr);
	}).fail(function(data, textStatus, xhr){
		$('.status-cors-origin-9001').append(data.status);
	});
	$.ajax({
		url : "http://localhost:8080/greetingCorsOrigin9001"
	}).then(function(data, status, jqxhr) {
		$('.greeting-id-cors-origin-9001').append(data.id);
		$('.greeting-content-cors-origin-9001').append(data.content);
		$('.status-cors-origin-9001').append(jqxhr.status);
		console.log(jqxhr);
	}).fail(function(data, textStatus, xhr){
		$('.status-cors-origin-9001').append(data.status);
	});
});