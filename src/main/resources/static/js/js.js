
$('document').ready(function(){

	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal({
			backdrop: 'static'
		});
	});
		
	
	
});
