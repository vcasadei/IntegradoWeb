$(document).ready(function() {
    /*autocomplete do keyword*/
    $('#keyword').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaKeyword",
            dataType: "html",
            data: {key: $('#keyword').val()}
        }).done(function(data) {
            $("#keyword").autocomplete({
                source: data
            });
        });
    });
    /*autocomplete do chemical*/
    $('#chemical').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaChemical",
            dataType: "html",
            data: {chemi: $('#chemical').val()}
        }).done(function(data) {
            $("#chemical").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do mesh term*/
    $('#mesh').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaMeshHeading",
            dataType: "html",
            data: {mesh: $('#mesh').val()}
        }).done(function(data) {
            $("#mesh").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do publication type*/
    $('#pubtype').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaPublicationType",
            dataType: "html",
            data: {type: $('#pubtype').val()}
        }).done(function(data) {
            $("#pubtype").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do nome do autor*/
    $('#forename').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaNomeAutor",
            dataType: "html",
            data: {fore: $('#forename').val()}
        }).done(function(data) {
            $("#forename").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do sobrenome do autor*/
    $('#lastname').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaLastAutor",
            dataType: "html",
            data: {last: $('#lastname').val()}
        }).done(function(data) {
            $("#lastname").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete das iniciais do Autor*/
    $('#initialsname').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaInitialsAutor",
            dataType: "html",
            data: {initial: $('#initialsname').val()}
        }).done(function(data) {
            $("#initialsname").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do título do Journal*/
    $('#journalTitle').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaTitJournal",
            dataType: "html",
            data: {tit: $('#journalTitle').val()}
        }).done(function(data) {
            $("#journalTitle").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do issn do Journal*/
    $('#issn').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaIssnJournal",
            dataType: "html",
            data: {issn: $('#issn').val()}
        }).done(function(data) {
            $("#issn").autocomplete({
                source: data
            });
        });
    });

    /*autocomplete do NlmUniqueID do Journal*/
    $('#nlmuniqueid').keypress(function() {
        $.ajax({
            type: "POST",
            url: "BuscaNlmJournal",
            dataType: "html",
            data: {nlm: $('#nlmuniqueid').val()}
        }).done(function(data) {
            $("#nlmuniqueid").autocomplete({
                source: data
            });
        });
    });
});