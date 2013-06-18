$('.open-help-autor').click(function(){
	var help = document.getElementsByClassName('help-text-autor')[0];
	this.style.display = 'none';
	help.style.display = 'block';
});

$('.close-help-autor').click(function(){
	var help = document.getElementsByClassName('help-text-autor')[0];
	var open = document.getElementsByClassName('open-help-autor')[0];
	open.style.display = 'inline';
	help.style.display = 'none';
});